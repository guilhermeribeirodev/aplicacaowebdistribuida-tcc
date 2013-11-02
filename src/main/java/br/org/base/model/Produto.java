package br.org.base.model;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 2:19 AM
 * To change this template use File | Settings | File Templates.
 */

public class Produto {

    @Id
    @ObjectId
    private String id;

    private String nome;

    private float valor;

    private String serie;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (Float.compare(produto.valor, valor) != 0) return false;
        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        if (serie != null ? !serie.equals(produto.serie) : produto.serie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (valor != +0.0f ? Float.floatToIntBits(valor) : 0);
        result = 31 * result + (serie != null ? serie.hashCode() : 0);
        return result;
    }
}
