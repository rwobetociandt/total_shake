package br.com.desafio.totalshake.w4.service;

import br.com.desafio.totalshake.w4.model.Pagamento;
import br.com.desafio.totalshake.w4.model.dto.PagamentoDto;
import br.com.desafio.totalshake.w4.model.enums.FormaDePagamento;
import br.com.desafio.totalshake.w4.model.enums.Status;
import br.com.desafio.totalshake.w4.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Pagamento> getAll(){
        return pagamentoRepository.findAll();
    }

    public PagamentoDto getOne(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if(pagamento.isPresent()){
            return toPagamentoDto(pagamento.get());
        }
        throw new NullPointerException();
    }

    public PagamentoDto createPagamento(PagamentoDto pagamentoDto) {
        var pagamento = toPagamento(pagamentoDto);
        pagamento.setStatus(Status.CRIADO);
        return toPagamentoDto(pagamentoRepository.save(pagamento));
    }

    public  PagamentoDto toPagamentoDto(Pagamento pagamento){
        return modelMapper.map(pagamento,PagamentoDto.class);
    }

    public Pagamento toPagamento(PagamentoDto pagamentoDto){
        return modelMapper.map(pagamentoDto,Pagamento.class);
    }
}
