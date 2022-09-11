package br.com.desafio.totalshake.w4.proxy;

import br.com.desafio.totalshake.w4.model.dto.UpdateStatusPedidoDto;
import br.com.desafio.totalshake.w4.model.enums.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "api-pedido")
public interface PedidoProxy {

    @PutMapping(value = "/pedidos/update-status-pedido-pagamento/{id}")
    public void updateStatus(@PathVariable Long id, @RequestBody String status);
}
