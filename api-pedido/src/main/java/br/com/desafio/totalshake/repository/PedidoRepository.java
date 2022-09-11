package br.com.desafio.totalshake.repository;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Modifying
    @Query(value = "UPDATE pedido SET status = ?2 WHERE id = ?1", nativeQuery = true)
    void updatePedidoStatus(Long id, Integer status);
}
