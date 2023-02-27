package com.zcoders.notificacao.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class NovaVendaDeserializer implements Deserializer<NovaVendaEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public NovaVendaEvent deserialize(String s, byte[] data) {
        try {
            return objectMapper.readValue(data, NovaVendaEvent.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
