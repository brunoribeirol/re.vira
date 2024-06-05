package com.revira.models.empresa;

import com.revira.models.Endereco;
import com.revira.models.Produto;

import java.util.List;

public class Empresa {
    private String nome;
    private String cnpj;
    private Endereco endereco;
    private List<Produto> produtos;

    public Empresa(String nome, String cnpj, Endereco endereco, List<Produto> produtos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}