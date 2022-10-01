package br.com.mhedtech.dto;


import java.time.LocalDateTime;

public class MaquinaDto {

    private Long patrimonio;

    private String nomeMaquina;

    private String config;

    private LocalDateTime dataCompra;

    private String officeChave;

    private String antivirusChave;

    public Long getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Long patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getOfficeChave() {
        return officeChave;
    }

    public void setOfficeChave(String officeChave) {
        this.officeChave = officeChave;
    }

    public String getAntivirusChave() {
        return antivirusChave;
    }

    public void setAntivirusChave(String antivirusChave) {
        this.antivirusChave = antivirusChave;
    }
}
