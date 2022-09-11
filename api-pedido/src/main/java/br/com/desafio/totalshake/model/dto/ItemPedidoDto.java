package br.com.desafio.totalshake.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemPedidoDto {

    private Long id;
    @NotNull
    private Integer quantidade;
    @NotNull
    private String descricao;

}
