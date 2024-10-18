import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.lang.annotation.ElementType;
import java.util.stream.Stream;
/**
 * Transformator
 */
public class Transformator {


    public <I, O> O tranformToDto(I input, Class<O> target) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        O output = target.getConstructor().newInstance();
        
        Field[] sourceFields = input.getClass().getDeclaredFields();
        //Stream<Field> targetFields = Arrays.stream(target.getDeclaredFields());
        Arrays.stream(sourceFields).forEach(sourceField -> 
            Arrays.stream(target.getDeclaredFields()).forEach(targetField -> 
            {
                boolean fieldsMatch = validate(sourceField, targetField);
                if (fieldsMatch) {                    
                    try {
                        sourceField.setAccessible(true);
                        targetField.setAccessible(true);
                        targetField.set(output, sourceField.get(input));
                        sourceField.setAccessible(false);
                        targetField.setAccessible(false);
                        return;
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }));
        return output;
    }

    

    private boolean validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName())
         && sourceField.getType().equals(targetField.getType())   
        ) {
            return true;
        }
        return false;
    }
}