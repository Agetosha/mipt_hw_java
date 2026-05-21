package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.validation.NotBlank;
import edu.phystech.hw5.annotation.validation.Size;
import edu.phystech.hw5.exception.ValidationException;

import java.lang.reflect.Field;

/**
 * @author kzlv4natoly
 */
public interface Validator {
    
    default void validate(Object object) {
        if (object == null) return;
        
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType().equals(String.class)) {
                field.setAccessible(true);
                String value;
                try {
                    value = (String) field.get(object);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access field", e);
                }

                NotBlank notBlank = field.getAnnotation(NotBlank.class);
                if (notBlank != null) {
                    if (value == null || value.trim().isEmpty()) {
                        throw new ValidationException(notBlank.message());
                    }
                }

                Size size = field.getAnnotation(Size.class);
                if (size != null) {
                    int length = (value == null) ? 0 : value.length();
                    if (length < size.min() || length > size.max()) {
                        throw new ValidationException(size.message());
                    }
                }
            }
        }
    }
}