package exercicio02_cache_de_metodos;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exercicio02_campos_semelhantes.ContaOrigem;

public class TestaMetodoEmCache {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // reflection: dá flexibilidade mas reduz o desempenho.
    
        System.out.println("alos");
        ContaOrigem contaOrigem = new ContaOrigem();
    
        Class<?> contaOrigemClass = contaOrigem.getClass();
        System.out.println(contaOrigemClass.getName());
    
        try {
            Method sacar = contaOrigemClass.getMethod("sacar");
            MethodCache cacheSacarOrigem = new MethodCache(sacar);
            

            ContaCorrente cc = new ContaCorrente();
            ContaPoupanca cp = new ContaPoupanca();


            Method sacarOld = cacheSacarOrigem.get();

            sacarOld.invoke(cc);


            // ....


            sacarOld.invoke(cp);
            
            // ...

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    
}
