package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_FINSEVEN_TRANSACAO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tp_transacao", discriminatorType = DiscriminatorType.STRING)
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transacao")
    @SequenceGenerator(name = "seq_transacao", sequenceName = "SQ_FINSEVEN_TRANSACAO", allocationSize = 1)
    @Column(name = "id_transacao")
    private long id;

    @Column(name = "id_banco", nullable = false)
    private long idBanco;

    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @Column(name = "vl_transacao", nullable = false)
    private double valor;

    @Column(name = "dt_transacao", nullable = false)
    private LocalDate data;

    @Column(name = "ds_transacao", length = 200)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_enum", length = 30)
    private TipoTransacao tipo;

    public Transacao() {
    }

    public Transacao(long id, long idBanco, Long idCategoria, double valor, LocalDate data, String descricao, TipoTransacao tipo) {
        this.id = id;
        this.idBanco = idBanco;
        this.idCategoria = idCategoria;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(long idBanco) {
        this.idBanco = idBanco;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
}