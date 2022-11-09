package br.com.mhedtech.dto;


import br.com.mhedtech.entity.PerifericoEntity;
import java.time.LocalDateTime;

public class PerifericoDto {

    private LocalDateTime dataCompra;

    private String config;

    private String modelo;
    private Long maquina;


    public LocalDateTime getDataCompra() {return dataCompra;}

    public void setDataCompra(LocalDateTime dataCompra) {this.dataCompra = dataCompra;}

    public String getConfig() {return config;}

    public void setConfig(String config) {this.config = config;}

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public Long getMaquina() {return maquina;}

    public void setMaquina(Long maquina) {this.maquina = maquina;}



    public void setEntity(PerifericoEntity perifericoEntity){

        perifericoEntity.setModelo(this.getModelo());
        perifericoEntity.setConfig(this.getConfig());
        perifericoEntity.setDataCompra(this.getDataCompra());


    }

}
