package br.com.fiap.fintech.finseven.model;


import jakarta.persistence.*;

@Entity
@Table(name = "T_FINSEVEN_BANCO")

public class Banco {

    @Id
    @Column(name = "ID_BANCO")
    @SequenceGenerator(name = "banco", sequenceName = " SQ_FINSEVEN_BANCO", allocationSize = 1)
    @GeneratedValue(generator = "banco", strategy = GenerationType.SEQUENCE)
    private Long id;

}