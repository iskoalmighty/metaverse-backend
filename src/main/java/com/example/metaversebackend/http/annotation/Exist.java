package com.example.metaversebackend.http.annotation;

import com.example.metaversebackend.http.validation.DataExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DataExistValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exist {
    String message() default "Record not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String entityName();

    String columnName() default "id";
}
