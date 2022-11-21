package br.com.mhedtech.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico")
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorico;

    private LocalDateTime dataAlterecao = LocalDateTime.now();

    @NotBlank(message = "Descrição é um campo obrigatório")
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private MaquinaEntity maquina;




    public Integer getIdHistorico() {return idHistorico;}

    public void setIdHistorico(Integer idHistorico) {this.idHistorico = idHistorico;}

    public LocalDateTime getDataAlterecao() {return dataAlterecao;}

    public void setDataAlterecao(LocalDateTime dataAlterecao) {this.dataAlterecao = dataAlterecao;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public MaquinaEntity getMaquina() {return maquina;}

    public void setMaquina(MaquinaEntity maquina) {this.maquina = maquina;}


}
