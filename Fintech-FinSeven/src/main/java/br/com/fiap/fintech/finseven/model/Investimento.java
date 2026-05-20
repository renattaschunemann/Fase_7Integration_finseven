package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_FINSEVEN_INVESTIMENTO")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_investimento")
    @SequenceGenerator(name = "seq_investimento", sequenceName = "SQ_FINSEVEN_INVESTIMENTO", allocationSize = 1)
    @Column(name = "id_investimento")
    private Long id;

    @Column(name = "nm_produto", length = 100, nullable = false)
    private String produto;

    @Column(name = "vl_aplicado", nullable = false)
    private double valorAplicado;

    @Column(name = "tx_rendimento")
    private double taxaRendimento;

    @Column(name = "dt_aplicacao")
    private LocalDate dataAplicacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario") // Força o nome correto da FK de Usuário
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco") // Força o nome correto da FK de Banco
    private Banco banco;

    public Investimento() {}

    public Investimento(String produto, double valorAplicado, double taxaRendimento, LocalDate dataAplicacao, Usuario usuario, Banco banco) {
        this.produto = produto;
        this.valorAplicado = valorAplicado;
        this.taxaRendimento = taxaRendimento;
        this.dataAplicacao = dataAplicacao;
        this.usuario = usuario;
        this.banco = banco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }
    public double getValorAplicado() { return valorAplicado; }
    public void setValorAplicado(double valorAplicado) { this.valorAplicado = valorAplicado; }
    public double getTaxaRendimento() { return taxaRendimento; }
    public void setTaxaRendimento(double taxaRendimento) { this.taxaRendimento = taxaRendimento; }
    public LocalDate getDataAplicacao() { return dataAplicacao; }
    public void setDataAplicacao(LocalDate dataAplicacao) { this.dataAplicacao = dataAplicacao; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Banco getBanco() { return banco; }
    public void setBanco(Banco banco) { this.banco = banco; }
}