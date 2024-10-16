package exercicio02_campos_semelhantes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class ContaTransformator {

    public <I, O> O transformToDto(I input, Class<O> target) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Class<?> source = input.getClass();

        Field[] fields = source.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            System.out.println(fields[i].getName());
        }

        System.out.println("Target class:");
        Field[] fields2 = target.getDeclaredFields();
        for (int i = 0, len = fields2.length; i < len; i++) {
            System.out.println(fields2[i].getName());
        }
        
        O output = target.getDeclaredConstructor().newInstance();

        for (int i = 0; i < fields.length; i++) {
            //Boolean sourceFieldInTargetClass = null;
            for (int j = 0; j < fields2.length; j++) {
                if (fields[i].getName().equals(fields2[j].getName()) && 
                fields[i].getType().getName().equals(fields2[j].getType().getName())) 
                {
                //    sourceFieldInTargetClass = true;
                    System.out.println("it worked!");
                    fields [i].setAccessible(true);
                    fields2[j].setAccessible(true);
                    fields2[j].set(output, fields[i].get(input));
                    System.out.println("valor copiado: " + fields2[j].get(output));
                    break;
                }
            }
        }




        return null;
    }
}
