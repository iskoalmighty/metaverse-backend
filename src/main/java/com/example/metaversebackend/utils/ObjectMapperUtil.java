package com.example.metaversebackend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapperUtil {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String objectToString(Object object) {
        String json = "";
        if(object != null) {
            try {
                json = objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return json;
    }

    public <T> T stringToObject(final String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
