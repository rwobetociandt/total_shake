package br.com.desafio.totalshake.w4.model.dto;

import br.com.desafio.totalshake.w4.model.enums.FormaDePagamento;
import br.com.desafio.totalshake.w4.model.enums.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PagamentoDto {

    private Long id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private String nome;

    @NotNull
    private String numero;

    @NotNull
    private String expiracao;

    @NotNull
    private String codigo;

    private Status status;

    @NotNull
    private Long pedidoId;

    @NotNull
    private FormaDePagamento forma_de_pagamento;

}
