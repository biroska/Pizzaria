package br.com.biroska.pizzaria.model;

/**
 * Created by Notebook on 20/08/2016.
 */
public class FormaPagamento {

    private Long id;
    private String nome;

    public FormaPagamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
