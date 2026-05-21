package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_BANCO")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banco")
    @SequenceGenerator(name = "seq_banco", sequenceName = "SQ_FINSEVEN_BANCO", allocationSize = 1)
    @Column(name = "id_banco")
    private long codigo;

    @Column(name = "nm_banco", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_agencia", length = 10, nullable = false)
    private String agencies;

    @Column(name = "nr_conta", length = 20, nullable = false)
    private String conta;

    @Column(name = "tp_conta", length = 30, nullable = false)
    private String tipo;

    @Column(name = "vl_saldo", nullable = false)
    private double saldo;

    public Banco() {}

    public long getIdBanco() {
        return codigo;
    }
    public void setIdBanco(long idBanco) {
        this.codigo = idBanco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAgencia() {
        return agencies;
    }
    public void setAgencia(String agencia) {
        this.agencies = agencia; }

    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}