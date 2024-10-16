public class App {
    public static void main(String[] args) throws Exception {
        var p = new Pessoa("Vinicius", 17);
        var q = new Transformator();
        System.out.println(q.tranformToDto(p, PessoaDto.class).getNome());
        
    }
}
