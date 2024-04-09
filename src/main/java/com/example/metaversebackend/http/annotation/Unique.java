package com.example.metaversebackend.http.annotation;

import com.example.metaversebackend.http.validation.UniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Data already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String entityName();
    String columnName();

    String columnException() default "";
}
