package br.com.mhedtech.service;

import br.com.mhedtech.dto.PerifericoDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.entity.PerifericoEntity;
import br.com.mhedtech.entity.UsuarioEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import br.com.mhedtech.repository.PerifericoRepository;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class PerifericoService {

    @Autowired
    PerifericoRepository perifericoRepository;

    @Autowired
    MaquinaRepository maquinaRepository;

    private Logger logger;


    public void criarPeriferico(PerifericoDto perifericoDto){
        PerifericoEntity perifericoEntity = new PerifericoEntity();


        Optional<MaquinaEntity> maquina = maquinaRepository.findByPatrimonio(perifericoDto.getMaquina());
        if(!maquina.isPresent())
            throw new NoResultException();

            perifericoDto.setEntity(perifericoEntity);
            perifericoEntity.setMaquina(maquina.get());
            perifericoRepository.save(perifericoEntity);

    }


    public Page<PerifericoEntity> listaPeriferico (Sort sort, Integer page, Integer size) throws NoResultException{

        try {
            Pageable pageable = PageRequest.of(page,size,sort);
            return perifericoRepository.findAll(pageable);
        }catch (Exception ex){
            logger.error("Não foi possivel localizar usuarios ->" , ex.getMessage());
            throw new NoResultException();
        }

    }


    public void deletaPeriferico(Integer ID){
        Optional<PerifericoEntity> periferico = perifericoRepository.findById(ID);
        if (periferico.isPresent()){
            PerifericoEntity perifericoEntity = periferico.get();
            perifericoRepository.delete(perifericoEntity);
        }else{
            throw new ObjectNotFoundException(ID, "-> Periferico não encontrado");
        }
    }
}
