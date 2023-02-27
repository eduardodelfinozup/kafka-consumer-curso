package com.zcoders.notificacao.listener;

import com.zcoders.notificacao.recebimento.NotificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NovaVendaListener {
    Logger logger = LoggerFactory.getLogger(NovaVendaListener.class);

    @Autowired
    private NotificacaoService notificacaoService;

    @KafkaListener(topics = "${spring.kafka2.consumer.topic.nova-venda}",
            containerFactory = "novaVendaKafkaListenerContainerFactory")
    public void recebe(NovaVendaEvent novaVendaEvent) {

        notificacaoService.incluirNovaVenda(novaVendaEvent.getEmailCliente(), novaVendaEvent.getTituloLivro(), novaVendaEvent.getTipoPagamento().name());

        logger.info("Evento Nova Conta lido com sucesso: {}", novaVendaEvent.toString());
    }
}
