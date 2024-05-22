package com.revira.models;

public class Endereco {
    private String cep;
    private String cidade;
    private String logradouro;
    private String bairro;
    private int numero;

    public Endereco(String cep, String cidade, String logradouro, String bairro, int numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }
}