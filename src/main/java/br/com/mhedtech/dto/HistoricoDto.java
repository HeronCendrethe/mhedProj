package br.com.mhedtech.dto;

import br.com.mhedtech.entity.HistoricoEntity;

import java.time.LocalDateTime;

public class HistoricoDto {

    private LocalDateTime dataAlteracao;

    private String descricao;
    private Long maquina;



    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getMaquina() {
        return maquina;
    }

    public void setMaquina(Long maquina) {
        this.maquina = maquina;
    }

    public void setEntity(HistoricoEntity historicoEntity){
        historicoEntity.setDataAlterecao(this.dataAlteracao);
        historicoEntity.setDescricao(this.descricao);



    }


}
