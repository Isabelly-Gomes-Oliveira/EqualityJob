using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

public class Empregador
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int Id { get; set; }
    public Usuario Usuario { get; set; }
    public string Nome { get; set; }
    public string Celular { get; set; }
    public string? AreaAtuacao { get; set; }
    public string? Email { get; set; }
    public string Estado { get; set; }
    public string Cidade { get; set; }
    public string Bairro { get; set; }
    public string Rua { get; set; }
    public string? ResumoEmpresa { get; set; }

    // Construtor padrão para o Entity Framework
    public Empregador()
    {
    }

    // Construtor para criar um empregador a partir de um cadastro
    public Empregador(CadastroEmpregador cadastro, Usuario usuario)
    {
        Usuario = usuario;
        Nome = cadastro.Nome;
        Celular = cadastro.Celular;
        AreaAtuacao = cadastro.AreaAtuacao;
        Email = cadastro.Email;
        Estado = cadastro.Estado;
        Cidade = cadastro.Cidade;
        Bairro = cadastro.Bairro;
        Rua = cadastro.Rua;
        ResumoEmpresa = cadastro.ResumoEmpresa;
    }
}
