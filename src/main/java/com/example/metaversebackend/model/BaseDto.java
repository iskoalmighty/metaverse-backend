package com.example.metaversebackend.model;

public abstract class BaseDto<T extends BaseEntity> {

    public abstract BaseDto parseModel(T entity);
    public abstract T toEntity();

}
