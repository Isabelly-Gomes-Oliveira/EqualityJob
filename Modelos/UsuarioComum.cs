
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

public class UsuarioComum
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int Id { get; set; }
    public Usuario Usuario { get; set; }
    public string Estado { get; set; }
    public string Cidade { get; set; }
    public string Bairro { get; set; }
    public string Rua { get; set; }
    public DateTime DataNascimento { get; set; }
    public string? Etnia { get; set; }
    public string? IdentidadeGenero { get; set; }
    public string? Sexualidade { get; set; }
    public string? Formacao { get; set; }
    public bool? PossuiExperiencia { get; set; }
    public List<string> CondicoesEspeciais { get; set; } = new List<string>();
    public string? Email { get; set; }
    public string? ResumoProfissional { get; set; }

    // Construtor padrão para o Entity Framework
    public UsuarioComum()
    {
    }

    // Construtor para criar um usuário comum a partir de um cadastro
    public UsuarioComum(CadastroUsuarioComum cadastro, Usuario usuario)
    {
        Usuario = usuario;
        Estado = cadastro.Estado;
        Cidade = cadastro.Cidade;
        Bairro = cadastro.Bairro;
        Rua = cadastro.Rua;
        DataNascimento = cadastro.DataNascimento;
        Etnia = cadastro.Etnia;
        IdentidadeGenero = cadastro.IdentidadeGenero;
        Sexualidade = cadastro.Sexualidade;
        Formacao = cadastro.Formacao;
        PossuiExperiencia = cadastro.PossuiExperiencia;
        CondicoesEspeciais = cadastro.CondicoesEspeciais;
        Email = cadastro.Email;
        ResumoProfissional = cadastro.ResumoProfissional;
    }
}
