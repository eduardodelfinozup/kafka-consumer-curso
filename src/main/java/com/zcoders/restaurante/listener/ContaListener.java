package com.zcoders.restaurante.listener;

import com.zcoders.restaurante.oferta.OfertaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ContaListener {

    Logger logger = LoggerFactory.getLogger(ContaListener.class);

    @Autowired
    OfertaService ofertaService;

    @KafkaListener(topics = "${spring.kafka1.consumer.topic.nova-conta}",
            containerFactory = "novaContaKafkaListenerContainerFactory")
    public void recebe(NovaContaEvent novaContaEvent) {

        ofertaService.incluirNovaOferta(novaContaEvent.getAgencia(), novaContaEvent.getNumero(), novaContaEvent.getSaldo());

        logger.info("Evento Nova Conta lido com sucesso: {}", novaContaEvent.toString());
    }

}
