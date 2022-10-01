package br.com.mhedtech.service;

import br.com.mhedtech.dto.UsuarioDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.entity.UsuarioEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import br.com.mhedtech.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MaquinaRepository maquinaRepository;



    public String criarUsuario(UsuarioDto usuarioDto){

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        Optional<MaquinaEntity> maquina = maquinaRepository.findByPatrimonio(usuarioDto.getMaquina().getPatrimonio());
        if(!maquina.isPresent()){
            return "Maquina não existe no banco!";
        }
        try{
            usuarioEntity.toEntity(usuarioDto);
            usuarioEntity.setMaquina(maquina.get());
            usuarioRepository.save(usuarioEntity);

        }catch (Exception e){

            return e.getMessage();

        }

        return "OK";

    }

    public UsuarioDto buscaUsuarioPeloPatrimonio(Long patrimonio){

        System.out.println(usuarioRepository.buscaUsuarioPorIdMaquina(patrimonio));
        Optional<UsuarioEntity> usuario = usuarioRepository.buscaUsuarioPorIdMaquina(patrimonio);
        if(usuario.isPresent()){
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.toDto(usuario.get());
            return usuarioDto;
        }

        throw new NoResultException();


    }

}
