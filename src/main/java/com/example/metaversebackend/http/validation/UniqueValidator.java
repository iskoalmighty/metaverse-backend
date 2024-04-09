package com.example.metaversebackend.http.validation;

import com.example.metaversebackend.http.annotation.Unique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @PersistenceContext
    private final EntityManager entityManager;
    private final HttpServletRequest httpServletRequest;
    private String entityName;
    private String columnName;
    private String columnException;


    @Override
    public void initialize(Unique constraintAnnotation) {
        this.entityName = constraintAnnotation.entityName();
        this.columnName = constraintAnnotation.columnName();
        this.columnException = constraintAnnotation.columnException();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String sqlQuery = "";
        sqlQuery = String.format("SELECT COUNT(e) from %s e WHERE e.%s = :value", entityName, columnName);
        if(!columnException.isEmpty()) {
            sqlQuery = String.format("%s AND e.%s != :%s", sqlQuery, columnException, columnException);
        }
        TypedQuery<Long> typedQuery = entityManager.createQuery(sqlQuery, Long.class)
                .setParameter("value", value);

        if(!columnException.isEmpty()) {
            Map<String, String> pathVariables = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            typedQuery.setParameter(this.columnException,  pathVariables.get("id"));
        }
        return typedQuery.getSingleResult() == 0;
    }
}
