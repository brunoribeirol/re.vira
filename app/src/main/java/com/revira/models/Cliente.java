package com.revira.models;

public class Cliente {
    private String nome;
    private String cpf;
    private int bonusCliente;

    public Cliente(String nome, String cpf, int bonusCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.bonusCliente = bonusCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getBonusCliente() {
        return bonusCliente;
    }

    public void setBonusCliente(int bonusCliente) {
        this.bonusCliente = bonusCliente;
    }
}