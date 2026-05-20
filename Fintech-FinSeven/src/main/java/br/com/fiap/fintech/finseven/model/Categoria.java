package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
    @SequenceGenerator(
            name = "seq_categoria",
            sequenceName = "SQ_FINSEVEN_CATEGORIA",
            allocationSize = 1
    )
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "ds_categoria", length = 100, nullable = false)
    private String descricao;

    @Column(name = "tp_transacao", length = 30, nullable = false)
    private String tipoTransacao;

    public Categoria() {}

    public Categoria(Long id, String descricao, String tiposTransacao) {
        this.id = id;
        this.descricao = descricao;
        this.tipoTransacao = tiposTransacao;
    }

    public Categoria(String descricao, String tiposTransacao) {
        this.descricao = descricao;
        this.tipoTransacao = tiposTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTiposTransacao() {
        return tipoTransacao;
    }

    public void setTiposTransacao(String tiposTransacao) {
        this.tipoTransacao = tiposTransacao;
    }
}