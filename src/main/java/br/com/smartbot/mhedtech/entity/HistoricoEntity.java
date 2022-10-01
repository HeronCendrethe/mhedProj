package br.com.smartbot.mhedtech.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico")
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHistorico;

    private LocalDateTime dataAlterecao = LocalDateTime.now();

    @NotBlank(message = "Descrição é um campo obrigatório")
    private String descricao;

    @OneToOne( fetch = FetchType.LAZY)
    private MaquinaEntity maquina;


}
