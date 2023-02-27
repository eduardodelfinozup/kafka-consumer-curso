package com.zcoders.notificacao.recebimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public void incluirNovaVenda(String emailCliente, String  tituloLivro, String mesagemVenda) {
        Notificacao tituloDoLivro = new Notificacao(emailCliente, tituloLivro, mesagemVenda);

        notificacaoRepository.save(tituloDoLivro);
    }
}
