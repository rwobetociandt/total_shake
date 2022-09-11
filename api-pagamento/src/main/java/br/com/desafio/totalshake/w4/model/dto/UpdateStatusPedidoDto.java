package br.com.desafio.totalshake.w4.model.dto;
import br.com.desafio.totalshake.w4.model.enums.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateStatusPedidoDto {
    private Status status;
}
