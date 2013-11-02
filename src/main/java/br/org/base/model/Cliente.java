package br.org.base.model;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;
import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 2:19 AM
 * To change this template use File | Settings | File Templates.
 */

public class Cliente  {

    @Id
    @ObjectId
    private String id;

    private String nome;

    private String documento;


    private DateTime criacao;


    private int idade;

    public Cliente() {

    }

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }


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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public DateTime getCriacao() {
        return criacao;
    }

    public void setCriacao(DateTime criacao) {
        this.criacao = criacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idade != cliente.idade) return false;
        if (criacao != null ? !criacao.equals(cliente.criacao) : cliente.criacao != null) return false;
        if (documento != null ? !documento.equals(cliente.documento) : cliente.documento != null) return false;
        if (id != null ? !id.equals(cliente.id) : cliente.id != null) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (criacao != null ? criacao.hashCode() : 0);
        result = 31 * result + idade;
        return result;
    }
}
