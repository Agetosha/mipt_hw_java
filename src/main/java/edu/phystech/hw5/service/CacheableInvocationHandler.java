package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.Cacheable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kzlv4natoly
 */
public class CacheableInvocationHandler implements InvocationHandler {

    private final Object target;
    private final Map<Method, Map<Object, Object>> cache = new ConcurrentHashMap<>();

    public CacheableInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        if (method.isAnnotationPresent(Cacheable.class)) {
            Object arg = (arguments != null && arguments.length > 0) ? arguments[0] : null;
            
            Map<Object, Object> methodCache = cache.computeIfAbsent(method, m -> new ConcurrentHashMap<>());
            
            if (methodCache.containsKey(arg)) {
                return methodCache.get(arg);
            }
            
            try {
                Object result = method.invoke(target, arguments);
                methodCache.put(arg, result);
                return result;
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
        
        try {
            return method.invoke(target, arguments);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}