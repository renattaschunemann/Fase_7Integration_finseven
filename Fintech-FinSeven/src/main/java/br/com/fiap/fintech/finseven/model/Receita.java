package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RECEITA")
public class Receita extends Transacao {

    @Column(name = "ds_origem", length = 100)
    private String origem;

    public Receita() {

        super();
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}