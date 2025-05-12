public class CadastroUsuarioComum
{
    public int IdUsuario { get; set; }
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
}