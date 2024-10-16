public class PessoaDto {

    public String nome;
    public int idade;

    public PessoaDto() {
    }

    public PessoaDto(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}