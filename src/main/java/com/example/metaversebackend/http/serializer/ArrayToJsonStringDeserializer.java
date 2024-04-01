package com.example.metaversebackend.http.serializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ArrayToJsonStringDeserializer extends StdDeserializer<String> {

    protected ArrayToJsonStringDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (JsonNode element : node) {
            builder.append(element.toString());
            builder.append(", ");
        }
        if (builder.length() > 2) {
            builder.setLength(builder.length() - 2); // Remove the trailing comma and space
        }
        builder.append("]");
        return builder.toString();

    }
}
