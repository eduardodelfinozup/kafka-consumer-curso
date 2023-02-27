package com.zcoders.notificacao.envio;

import com.zcoders.notificacao.recebimento.Notificacao;
import org.springframework.stereotype.Component;

@Component
public class EnviarEmail implements EnviarNotificacao {
    @Override
    public void send(Notificacao notificao) {

        // envio do e-mail para o Servidor de E-mail
    }
}