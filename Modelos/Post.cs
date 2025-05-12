using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

public class Post
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int Id { get; set; }
    public string Conteudo { get; set; }
    public DateTime DataCriacao { get; set; }
    public Usuario Criador { get; set; }

    public Post()
    {
    }

    public Post(CriarPost criarPost, Usuario criador)
    {
        Conteudo = criarPost.Conteudo;
        DataCriacao = criarPost.DataCriacao;
        Criador = criador;
    }
}
