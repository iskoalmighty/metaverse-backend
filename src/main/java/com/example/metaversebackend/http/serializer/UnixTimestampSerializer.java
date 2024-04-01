package com.example.metaversebackend.http.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UnixTimestampSerializer extends StdSerializer<LocalDateTime> {

    protected UnixTimestampSerializer() {
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        jsonGenerator.writeNumber(instant.getEpochSecond());
    }
}
