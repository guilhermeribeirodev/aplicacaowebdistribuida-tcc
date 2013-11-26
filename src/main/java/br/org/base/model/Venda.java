package br.org.base.model;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/24/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Venda implements Serializable {

    @Id
    @ObjectId
    private String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private DateTime criacao = new DateTime();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public DateTime getCriacao() {


        return criacao;
    }

    public void setCriacao(DateTime criacao) {

        this.criacao = criacao;
    }
}
