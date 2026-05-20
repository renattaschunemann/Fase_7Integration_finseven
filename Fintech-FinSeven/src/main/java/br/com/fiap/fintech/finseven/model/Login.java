package br.com.fiap.fintech.finseven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
    @SequenceGenerator(name = "seq_login", sequenceName = "SQ_FINSEVEN_LOGIN", allocationSize = 1)
    @Column(name = "id_login")
    private int idLogin;

    @Column(name = "ds_senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "qt_tentativas")
    private int tentativasLogin;

    @Column(name = "st_bloqueado")
    private boolean contaBloqueada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;


    public Login() {
    }

    public Login(String senha, int tentativasLogin, boolean contaBloqueada, Usuario usuario) {
        this.senha = senha;
        this.tentativasLogin = tentativasLogin;
        this.contaBloqueada = contaBloqueada;
        this.usuario = usuario;
    }

    public Login(int idLogin, String senha, int tentativasLogin, boolean contaBloqueada, Usuario usuario) {
        this.idLogin = idLogin;
        this.senha = senha;
        this.tentativasLogin = tentativasLogin;
        this.contaBloqueada = contaBloqueada;
        this.usuario = usuario;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTentativasLogin() {
        return tentativasLogin;
    }

    public void setTentativasLogin(int tentativasLogin) {
        this.tentativasLogin = tentativasLogin;
    }

    public boolean isContaBloqueada() {
        return contaBloqueada;
    }

    public void setContaBloqueada(boolean contaBloqueada) {
        this.contaBloqueada = contaBloqueada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


