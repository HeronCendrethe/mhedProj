package br.com.mhedtech.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "perifericos")
public class PerifericoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeriferico;

    private LocalDateTime dataCompra;

    private String config;

    private String modelo;

    @ManyToOne
    private MaquinaEntity maquina;
}
