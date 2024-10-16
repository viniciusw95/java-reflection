import java.beans.BeanProperty;
import java.beans.ConstructorProperties;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import javax.management.ConstructorParameters;
import javax.management.DescriptorKey;

public class Pessoa {
    
    public String nome;
    private int idade;
    public Pessoa() {
        
    }

    public Pessoa(int a, int b, int c) {

    }
    
    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
