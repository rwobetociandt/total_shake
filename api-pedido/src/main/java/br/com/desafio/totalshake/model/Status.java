package br.com.desafio.totalshake.model;

public enum Status {
    REALIZADO(0),
    CANCELADO(1),
    PAGO(2),
    NAO_AUTORIZADO(3),
    CONFIRMADO(4),
    PRONTO(5),
    SAIU_PARA_ENTREGA(6),
    ENTREGUE(7);
    public final Integer valor;
    Status(Integer valor) {
        this.valor = valor;
    }

}
