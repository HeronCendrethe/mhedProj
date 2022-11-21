package br.com.mhedtech.entity;


import br.com.mhedtech.Enum.MaquinaEnum;
import br.com.mhedtech.dto.MaquinaDto;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "maquina")
public class MaquinaEntity {

    @Id
    private Long patrimonio;

    @NotBlank(message = "O nome da máquina não pode ser vazio")
    private String nomeMaquina;

    @NotBlank(message = "O nome da config não pode ser vazio")
    private String config;

    private LocalDateTime dataCompra;

    private String officeChave;

    private String antivirusChave;

    @Enumerated(EnumType.STRING)
    private MaquinaEnum status;



    public void toEntity(MaquinaDto maquinaDto){
        this.patrimonio = maquinaDto.getPatrimonio();
        this.nomeMaquina = maquinaDto.getNomeMaquina();
        this.config = maquinaDto.getConfig();
        this.dataCompra = maquinaDto.getDataCompra();
        this.officeChave = maquinaDto.getOfficeChave();
        this.antivirusChave = maquinaDto.getAntivirusChave();
        this.status=maquinaDto.getStatus();

    }

    public MaquinaEnum getStatus() {return status;}

    public void setStatus(MaquinaEnum status) {this.status = status;}


    public Long getPatrimonio() {return patrimonio;}

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
