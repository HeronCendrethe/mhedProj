package br.com.mhedtech.dto;


import br.com.mhedtech.entity.UsuarioEntity;
import java.time.LocalDateTime;

public class UsuarioDto {


    private String nome;


    private String setor;

    private LocalDateTime dataMaq;

    private Long maquina;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDateTime getDataMaq() {
        return dataMaq;
    }

    public void setDataMaq(LocalDateTime dataMaq) {
        this.dataMaq = dataMaq;
    }

    public Long getMaquina() {return maquina;}

    public void setMaquina(Long maquina) {this.maquina = maquina;}




    public void toDto(UsuarioEntity usuarioEntity){

        this.nome = usuarioEntity.getNome();
        this.setor = usuarioEntity.getSetor();
        this.dataMaq = usuarioEntity.getDataMaq();

    }
}
