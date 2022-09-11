package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import br.com.desafio.totalshake.model.dto.PedidoDto;
import br.com.desafio.totalshake.model.dto.UpdateStatusPedidoDto;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final ItemPedidoRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Page<PedidoDto> findAll(Pageable pageable) {
        var pedidos = pedidoRepository.findAll(pageable);
         Page<PedidoDto> pedidosAll = pedidos.map(this::toPedidoDto);
         return pedidosAll;
    }
    @Transactional(readOnly = true)
    public PedidoDto findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent()){
            return toPedidoDto(pedido.get());
        }
        throw new NullPointerException();
    }

    @Transactional
    public PedidoDto savePedido(PedidoDto pedidoDto) {
        if(pedidoDto.getItensPedido().size() <= 0){
            throw new IllegalArgumentException();
        }
        pedidoDto.setDataHora(LocalDateTime.now(ZoneId.of("UTC")));
        pedidoDto.setStatus(Status.REALIZADO);
        return toPedidoDto(pedidoRepository.save(toPedido(pedidoDto)));
    }

    @Transactional
    public PedidoDto update(PedidoDto pedidoDto, Long id) {
        PedidoDto pedido = findById(id);
        if(pedidoDto.getItensPedido().size() <= 0){
            throw new IllegalArgumentException();
        }
        pedido.getItensPedido().forEach(item -> itemRepository.deleteById(item.getId()));
        pedido.setItensPedido(pedidoDto.getItensPedido());
        pedidoRepository.save(toPedido(pedido));
        return pedido;
    }

    @Transactional
    public void updateStatusPagamento(Long id, String status) {
        findById(id);
        if(status.equals("CONFIRMADO")) {
            pedidoRepository.updatePedidoStatus(id, 2);
        } else if (status.equals("CANCELADO")) {
            pedidoRepository.updatePedidoStatus(id, 1);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        findById(id);
        pedidoRepository.deleteById(id);
    }

    public PedidoDto toPedidoDto(Pedido pedido){
        return modelMapper.map(pedido,PedidoDto.class);
    }

    public Pedido toPedido(PedidoDto pedidodto){
        return modelMapper.map(pedidodto,Pedido.class);
    }

}
