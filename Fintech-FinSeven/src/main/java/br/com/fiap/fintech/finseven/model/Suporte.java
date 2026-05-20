package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_SUPORTE")
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_suporte")
    @SequenceGenerator(name = "seq_suporte", sequenceName = "SQ_FINSEVEN_SUPORTE", allocationSize = 1)
    @Column(name = "id_suporte")
    private Long id;

    @Column(name = "ds_assunto", length = 150, nullable = false)
    private String assunto;

    @Column(name = "ds_mensagem", length = 1000, nullable = false)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Suporte() {}

    public Suporte(String assunto, String mensagem, Usuario usuario) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}