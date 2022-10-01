package br.com.smartbot.mhedtech.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "maquina")
public class MaquinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patrimonio;

    @NotBlank(message = "O nome da máquina não pode ser vazio")
    private String nomeMaquina;

    @NotBlank(message = "O nome da config não pode ser vazio")
    private String config;

    private LocalDateTime dataCompra;

    private String officeChave;

    private String antivirusChave;




}
