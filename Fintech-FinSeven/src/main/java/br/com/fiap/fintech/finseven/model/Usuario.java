package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "SQ_FINSEVEN_USUARIO", allocationSize = 1)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nm_usuario", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "ds_email", length = 100, nullable = false, unique = true)
    private String email;

    public Usuario() {}

    public Usuario(Long id, String nome, Long cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuario(String nome, Long cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf; }
    public String getEmail() { return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}