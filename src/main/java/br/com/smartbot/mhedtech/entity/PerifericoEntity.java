package br.com.smartbot.mhedtech.entity;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
@Table(name = "perifericos")
public class PerifericoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPeriferico;

    private LocalDateTime dataCompra;

    private String config;

    private String modelo;

    @ManyToOne
    private MaquinaEntity maquina;
}
