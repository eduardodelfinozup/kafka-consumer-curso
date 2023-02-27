package com.zcoders.notificacao.recebimento;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinatario;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String titulo;

    private String mensagem;

    private LocalDateTime incluidoEm;

    private LocalDateTime atualizadoEm;

    public Notificacao() {
    }

    public Notificacao(String destinatario, String titulo, String mensagem) {
        this.destinatario = destinatario;
        this.status = Status.NAO_ENVIADO;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.incluidoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

}