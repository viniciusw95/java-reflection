package exercicio02_campos_semelhantes;
import java.lang.reflect.InvocationTargetException;

public class TesteConta {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        // Ler de um BD:
        ContaOrigem contaOrigem = new ContaOrigem();        
        ContaTransformator fabrica = new ContaTransformator();

        fabrica.transformToDto(contaOrigem, ContaOrigemDto.class);
        
        

        
    }
}
