using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

var builder = WebApplication.CreateBuilder(args);

// Configuração do banco de dados
// Deixar o banco de dados em memória pra testar mais fácil
// Se for usar o SQL Server, descomentar a linha abaixo e comentar a linha de cima
builder.Services.AddDbContext<AppDbContext>(opt =>
    opt.UseInMemoryDatabase("EqualityJobDB"));
// opt.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

// Configura a autenticação JWT
// Chave secreta que é usada para assinar o token
const string CHAVE_JWT = "chave secreta que deve ter pelo menos 16 caracteres";
builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = "EqualityJobAPI",
            ValidAudience = "EqualityJobClient",
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(CHAVE_JWT))
        };
    });

builder.Services.AddAuthorization();
builder.Services.AddEndpointsApiExplorer();

// Adiciona a possibilidade de mandar o header de autenticação com o token JWT no Swagger
builder.Services.AddSwaggerGen(options =>
{
    options.AddSecurityDefinition("Bearer", new OpenApiSecurityScheme()
    {
        Name = "Authorization",
        Type = SecuritySchemeType.ApiKey,
        Scheme = "Bearer",
        BearerFormat = "JWT",
        In = ParameterLocation.Header,
        Description = "JWT Authorization header using the Bearer scheme. \r\n\r\n Enter 'Bearer' [space] and then your token in the text input below.\r\n\r\nExample: \"Bearer 1safsfsdfdfd\"",
    });
    options.AddSecurityRequirement(new OpenApiSecurityRequirement {
        {
            new OpenApiSecurityScheme {
                Reference = new OpenApiReference {
                    Type = ReferenceType.SecurityScheme,
                        Id = "Bearer"
                }
            },
            new string[] {}
        }
    });
});

var app = builder.Build();

// Middleware
app.UseSwagger();
app.UseSwaggerUI();
app.UseAuthentication();
app.UseAuthorization();

// Rotas

// Registra um usuário, que pode ser um empregador ou um usuário comum
app.MapPost("/auth/registrar/usuario", async (AppDbContext db, Usuario usuario) =>
{
    db.Usuarios.Add(usuario);
    await db.SaveChangesAsync();

    return Results.Created($"/usuarios/{usuario.Id}", usuario);
});

// Registra um usuário comum
app.MapPost("/auth/registrar/usuario-comum", async (AppDbContext db, CadastroUsuarioComum dadosCadastroUsuarioComum) =>
{
    // Acha o usuário a qual o usuário comum pertence
    var usuario = await db.Usuarios.FindAsync(dadosCadastroUsuarioComum.IdUsuario);
    if (usuario == null) return Results.NotFound();

    // Cria o usuário comum a partir dos dados de cadastro
    var usuarioComum = new UsuarioComum(dadosCadastroUsuarioComum, usuario);
    db.UsuariosComuns.Add(usuarioComum);
    await db.SaveChangesAsync();

    return Results.Created($"/usuarios/{usuarioComum.Id}", usuarioComum);
});

// Registra um empregador
app.MapPost("/auth/registrar/empregador", async (AppDbContext db, CadastroEmpregador dadosCadastroEmpregador) =>
{
    // Acha o usuário a qual o empregador pertence
    var usuario = await db.Usuarios.FindAsync(dadosCadastroEmpregador.IdUsuario);
    if (usuario == null) return Results.NotFound();

    // Cria o empregador a partir dos dados de cadastro
    var empregador = new Empregador(dadosCadastroEmpregador, usuario);
    db.Empregadores.Add(empregador);
    await db.SaveChangesAsync();

    return Results.Created($"/empregadores/{empregador.Id}", empregador);
});

// Login
app.MapPost("/auth/login", async (AppDbContext db, LoginUsuario login) =>
{
    // Acha o usuário pelo CPF e senha
    var usuario = await db.Usuarios.FirstOrDefaultAsync(usuario => usuario.CPF == login.CPF && usuario.Senha == login.Senha);
    if (usuario == null) return Results.Unauthorized();

    // Cria o token JWT, com as claims do usuário
    var claims = new[]
    {
        new Claim(ClaimTypes.NameIdentifier, usuario.Id.ToString()),
        new Claim(ClaimTypes.MobilePhone, usuario.Celular)
    };

    // Gera a chave de segurança e as credenciais, usando o algoritmo SHA256
    var chaveJwt = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(CHAVE_JWT));
    var credenciais = new SigningCredentials(chaveJwt, SecurityAlgorithms.HmacSha256);

    // Cria o token com as claims, a chave de segurança e as credenciais
    // Define o emissor e o público do token, que são os mesmos configurados anteriormente, além da data de expiração
    var token = new JwtSecurityToken(
        issuer: "EqualityJobAPI",
        audience: "EqualityJobClient",
        claims: claims,
        expires: DateTime.UtcNow.AddHours(1),
        signingCredentials: credenciais
    );

    // Pega o token como string, e retorna como resposta
    var tokenString = new JwtSecurityTokenHandler().WriteToken(token);
    return Results.Ok(new { token = tokenString });
});

// Listar usuários comuns
app.MapGet("/usuarios", async (AppDbContext db) =>
{
    var usuarios = await db.UsuariosComuns.ToListAsync();
    return Results.Ok(usuarios);
}).RequireAuthorization();

// Pegar o perfil de um usuário comum pelo ID
app.MapGet("/usuarios/{id}", async (AppDbContext db, int id) =>
{
    var usuario = await db.UsuariosComuns.FindAsync(id);
    return usuario is not null ? Results.Ok(usuario) : Results.NotFound();
}).RequireAuthorization();

// Listar empregadores
app.MapGet("/empregadores", async (AppDbContext db) =>
{
    var empregadores = await db.Empregadores.ToListAsync();
    return Results.Ok(empregadores);
}).RequireAuthorization();

// Pegar o perfil de um empregador pelo ID
app.MapGet("/empregadores/{id}", async (AppDbContext db, int id) =>
{
    var empregador = await db.Empregadores.FindAsync(id);
    return empregador is not null ? Results.Ok(empregador) : Results.NotFound();
}).RequireAuthorization();

// Listar vagas de emprego
app.MapGet("/vagas-emprego", async (AppDbContext db) =>
{
    var vagasEmprego = await db.VagasEmprego.ToListAsync();
    return Results.Ok(vagasEmprego);
}).RequireAuthorization();


// Criar vaga de emprego
app.MapPost("/vagas-emprego", async (AppDbContext db, VagaEmprego vagaEmprego) =>
{
    db.VagasEmprego.Add(vagaEmprego);
    await db.SaveChangesAsync();

    return Results.Created($"/vagas-emprego/{vagaEmprego.Id}", vagaEmprego);
}).RequireAuthorization();

// Listar postagens
app.MapGet("/postagens", async (AppDbContext db) =>
{
    var postagens = await db.Postagens.ToListAsync();
    return Results.Ok(postagens);
}).RequireAuthorization();

// Listar postagens de um usuário
app.MapGet("/postagens/usuario/{idUsuario}", async (AppDbContext db, int idUsuario) =>
{
    // Include carrega o criador da postagem
    var postagens = await db.Postagens.Include(post => post.Criador).Where(p => p.Criador.Id == idUsuario).ToListAsync();
    return Results.Ok(postagens);
}).RequireAuthorization();

// Criar postagem
app.MapPost("/postagens", async (AppDbContext db, CriarPost dadosCadastroPostagem) =>
{
    // Acha o usuário a qual a postagem pertence
    var usuario = await db.Usuarios.FindAsync(dadosCadastroPostagem.IdCriador);
    if (usuario == null) return Results.NotFound();

    // Cria a postagem a partir dos dados de cadastro
    var novaPostagem = new Post(dadosCadastroPostagem, usuario);
    db.Postagens.Add(novaPostagem);
    await db.SaveChangesAsync();

    return Results.Created($"/postagens/{novaPostagem.Id}", novaPostagem);
}).RequireAuthorization();

app.Run();
