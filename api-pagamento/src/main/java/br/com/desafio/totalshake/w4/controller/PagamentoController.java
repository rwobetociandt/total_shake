package br.com.desafio.totalshake.w4.controller;

import br.com.desafio.totalshake.w4.model.Pagamento;
import br.com.desafio.totalshake.w4.model.dto.PagamentoDto;
import br.com.desafio.totalshake.w4.model.dto.UpdateStatusPedidoDto;
import br.com.desafio.totalshake.w4.proxy.PedidoProxy;
import br.com.desafio.totalshake.w4.service.PagamentoService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PedidoProxy pedidoProxy;

    @Autowired
    private PagamentoService pagamentoService;

    private Logger logger = LoggerFactory.getLogger(PagamentoController.class);

    @GetMapping
    public ResponseEntity<List<Pagamento>> getAll(){
        return new ResponseEntity<>(pagamentoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> getOne(@PathVariable Long id){
        return new ResponseEntity<>(pagamentoService.getOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> createPagamento(@RequestBody PagamentoDto pagamentoDto){
        return new ResponseEntity<>(pagamentoService.createPagamento(pagamentoDto), HttpStatus.CREATED);
    }

    @PutMapping("/status-pagamento/{idPedido}")
    public void statusPedido(@PathVariable Long idPedido, @RequestBody UpdateStatusPedidoDto status){
        pedidoProxy.updateStatus(idPedido, status.getStatus().name());
    }

}
