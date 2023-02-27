package com.zcoders.notificacao.listener;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class NovaVendaListenerConfiguration {
    @Value("${spring.kafka2.consumer.bootstrap-servers}")
    private String bootstrapAddress;
    @Value("${spring.kafka2.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka2.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Bean
    public ConsumerFactory<String, Object> novaVendaConsumerFactory() {
        Map<String, Object> properties =  new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, NovaVendaDeserializer.class );
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NovaVendaEvent>
    novaVendaKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NovaVendaEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(novaVendaConsumerFactory());
        return factory;
    }
}
