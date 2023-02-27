package com.zcoders.oferta.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class NovaContaDeserializer implements Deserializer<NovaContaEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public NovaContaEvent deserialize(String s, byte[] data) {
        try {
            return objectMapper.readValue(data, NovaContaEvent.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
