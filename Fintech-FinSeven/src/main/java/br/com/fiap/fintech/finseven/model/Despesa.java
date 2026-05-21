package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DESPESA")
public class Despesa extends Transacao {

    @Column(name = "ds_forma_pagto", length = 50)
    private String formaPagamento;

    public Despesa() {
        super();
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}