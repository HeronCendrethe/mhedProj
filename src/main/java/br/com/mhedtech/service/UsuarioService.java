package br.com.mhedtech.service;

import br.com.mhedtech.dto.UsuarioDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.entity.UsuarioEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import br.com.mhedtech.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;
import org.slf4j.Logger;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MaquinaRepository maquinaRepository;


    private Logger logger;



    public String criarUsuario(UsuarioDto usuarioDto){

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        Optional<MaquinaEntity> maquina = maquinaRepository.findByPatrimonio(usuarioDto.getMaquina());
        if(!maquina.isPresent()){
            return "Maquina não existe no banco!";
        }
        try{
            usuarioEntity.setMaquina(maquina.get());
            usuarioEntity.toEntity(usuarioDto);
            usuarioEntity.getMaquina();
            usuarioRepository.save(usuarioEntity);

        }catch (Exception e){

            return e.getMessage();

        }

        return "OK";

    }

    public UsuarioDto buscaUsuarioPeloPatrimonio(Long patrimonio) throws NoResultException{

        System.out.println(usuarioRepository.buscaUsuarioPorIdMaquina(patrimonio));
        Optional<UsuarioEntity> usuario = usuarioRepository.buscaUsuarioPorIdMaquina(patrimonio);
        if(usuario.isPresent()){
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.toDto(usuario.get());
            return usuarioDto;
        }

        throw new NoResultException();


    }

    public Page<UsuarioEntity> listaUsuarios(Sort sort,Integer page, Integer size) throws NoResultException {
        try {

            Pageable pageable = PageRequest.of(page,size,sort);
            return usuarioRepository.findAll(pageable);

        }catch (Exception ex){
            logger.error("Não foi possivel localizar usuarios ->" , ex.getMessage());
            throw new NoResultException();
        }


    }

    public void deletaUsuario(Integer ID) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findById(ID);
        if (usuario.isPresent()){
            UsuarioEntity usuarioEntity = usuario.get();
            usuarioRepository.delete(usuarioEntity);
        }else{
            throw new ObjectNotFoundException(ID, "-> Usuario não encontrado");
        }


    }
}
