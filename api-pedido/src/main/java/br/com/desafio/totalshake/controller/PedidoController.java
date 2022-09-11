package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.model.dto.PedidoDto;
import br.com.desafio.totalshake.model.dto.UpdateStatusPedidoDto;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    public ResponseEntity<Page<PedidoDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(pedidoService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> savePedido(@RequestBody @Valid PedidoDto pedidoDto){
        return new ResponseEntity<>(pedidoService.savePedido(pedidoDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable final Long id) {
        pedidoService.deleteById(id);
        return new ResponseEntity<>("Pedido deletado", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePedido(@RequestBody @Valid PedidoDto pedidoDto, @PathVariable Long id){
        return new ResponseEntity<>(pedidoService.update(pedidoDto, id), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/update-status-pedido-pagamento/{id}")
    public void updateStatus(@PathVariable Long id, @RequestBody String status){
        pedidoService.updateStatusPagamento(id, status);
    }


}











