
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

public class VagaEmprego
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int Id { get; set; }
    public string Titulo { get; set; }
    public string Descricao { get; set; }
    public string Cargo { get; set; }
    public double Salario { get; set; }
    public string Endereco { get; set; }
    public List<string> Modalidades { get; set; } = new List<string>();
    public List<string> FaixasEtarias { get; set; } = new List<string>();
    public bool AceitaNecessidadeEspecial { get; set; }
    public List<string> NecessidadesEspeciais { get; set; } = new List<string>();
    public List<string> CausasApoiadas { get; set; } = new List<string>();
    public string ExperienciaNecessaria { get; set; }
    public List<string> Imagens { get; set; } = new List<string>();
}
