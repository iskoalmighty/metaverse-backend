package com.example.metaversebackend.http.validation;

import com.example.metaversebackend.http.annotation.Exist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DataExistValidator implements ConstraintValidator<Exist, Object> {

    @PersistenceContext
    private final EntityManager entityManager;
    private String entityName;
    private String columnName;

    public DataExistValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(Exist constraintAnnotation) {
        this.entityName = constraintAnnotation.entityName();
        this.columnName = constraintAnnotation.columnName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) return true;
        long count = 0;
        switch (value.getClass().getName()) {
            case "[Ljava.lang.Long;":
                Long[] integers = (Long[]) value;
                for(Long integer: integers) {
                    count = countExistingRecord(integer);
                    if(count < 1) break;
                }
                break;

            default:
                count = countExistingRecord(value);
                break;
        }
        return count > 0;
    }

    private Long countExistingRecord(Object value) {
        String sqlQuery = String.format(
                "SELECT COUNT(e) from %s e WHERE e.%s = :value",
                entityName,
                columnName
        );
        return entityManager.createQuery(sqlQuery, Long.class)
                .setParameter("value", value)
                .getSingleResult();
    }

}
