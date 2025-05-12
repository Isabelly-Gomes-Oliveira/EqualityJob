using Microsoft.EntityFrameworkCore;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options)
        : base(options) { }

    public DbSet<Usuario> Usuarios { get; set; }
    public DbSet<UsuarioComum> UsuariosComuns { get; set; }
    public DbSet<Empregador> Empregadores { get; set; }
    public DbSet<Post> Postagens { get; set; }
    public DbSet<VagaEmprego> VagasEmprego { get; set; }
}