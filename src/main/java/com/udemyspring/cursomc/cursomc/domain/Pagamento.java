package com.udemyspring.cursomc.cursomc.domain;

import com.udemyspring.cursomc.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity //define a classe como uma entidade no BD
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //especifica a coluna com Id
    private Integer id;
    private EstadoPagamento estado;

    @OneToOne //relaciona duas entidades (relacionamento um para um)
    @JoinColumn(name = "pedido_id") //nomeia a coluna que possui a chave-estrangeira
    @MapsId //garante que o id do Pedido seja o mesmo id do Pagamento
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        super();
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}