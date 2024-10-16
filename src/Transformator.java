import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.lang.annotation.ElementType;
/**
 * Transformator
 */
public class Transformator {


    public <I, O> O tranformToDto(I input, Class<O> target) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        
        
        System.out.println(target.getName());
        Class<?> outClass = Class.forName(target.getName());
        System.out.println(outClass.getName());
        O outputObject = (O) outClass.getDeclaredConstructor().newInstance();
        
        Field[] sourceFields = outClass.getDeclaredFields();
        // Method[] tm = outputClass.getDeclaredMethods();                

        // String field = "nome";
        String lookedUpMethodNamed = "setNome";
        // System.out.println(outputClass.getDeclaredMethods()[1].getName());
        Class<?>[] pn = outClass.getDeclaredMethods()[1].getParameterTypes();
        Object testeTxt = input.getClass().getMethod("getNome").invoke(input);
        outClass.getMethod(lookedUpMethodNamed, pn).invoke(outputObject, testeTxt);

        return outputObject;
    }

}