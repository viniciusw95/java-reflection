package exercicio02_cache_de_metodos;

import java.lang.reflect.Method;

/**
 * SacarWrapper
 */
public class MethodCache {

    private final Method cachedMethod;

    public MethodCache(Method method) {
        if (method == null) {
            throw new NullPointerException("methodo deve ser não nulo. . .");
        }
        cachedMethod = method;
    }

    public Method get() {
        return cachedMethod; 
    }
}