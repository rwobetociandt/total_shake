package br.com.desafio.totalshake.model.dto;

import br.com.desafio.totalshake.model.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDto {

    private Long id;
    private Status status;
    private LocalDateTime dataHora;
    @NotNull
    private List<ItemPedidoDto> itensPedido = new ArrayList<>();

}
