package br.com.desafio.totalshake.w4.model;

import br.com.desafio.totalshake.w4.model.enums.FormaDePagamento;
import br.com.desafio.totalshake.w4.model.enums.Status;
import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    @NotNull
    private BigDecimal valor;

    @Size(min = 1, max = 100)
    @NotNull
    private String nome;

    @Size(min = 1, max = 100)
    @NotNull
    private String numero;

    @Size(min = 3, max = 3)
    @NotNull
    private String expiracao;

    @NotNull
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Column(name = "pedido_id")
    private Long pedidoId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormaDePagamento forma_de_pagamento;
}
