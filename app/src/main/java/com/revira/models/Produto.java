package com.revira.models;

import java.util.List;
public class Produto {
    private String nome;
    private String categoria;
    private List<Produto> produtosValidos;

    public Produto(String nome, String categoria, List<Produto> produtosValidos) {
        this.nome = nome;
        this.categoria = categoria;
        this.produtosValidos = produtosValidos;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<Produto> getProdutosValidos() {
        return produtosValidos;
    }
}