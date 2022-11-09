package br.com.mhedtech.entity;


import br.com.mhedtech.dto.MaquinaDto;
import br.com.mhedtech.dto.PerifericoDto;

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


    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public MaquinaEntity getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinaEntity maquina) {
        this.maquina = maquina;
    }


}
