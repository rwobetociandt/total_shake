package br.com.desafio.totalshake.model;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pedido_id")
    private List< ItemPedido > itensPedido = new ArrayList<>();

}
