public class App {
    public static void main(String[] args) throws Exception {
        var p = new Pessoa("Vinicius", 19);
        var q = new Transformator();

        PessoaDto pdt = q.tranformToDto(p, PessoaDto.class);
        System.out.println(pdt.getNome());
        System.out.println(pdt.getIdade());
        
    }
}
