package br.com.mhedtech.service;


import br.com.mhedtech.dto.MaquinaDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.entity.PerifericoEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;


@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    private Logger logger;

    public String criarMaquina(MaquinaDto maquinaDto){
       MaquinaEntity maquinaEntity = new MaquinaEntity();
        try{
            maquinaEntity.toEntity(maquinaDto);
            maquinaRepository.save(maquinaEntity);

        }catch (Exception e){

            return e.getMessage();

        }

        return "OK";
    }

    public Page<MaquinaEntity> listaMaquina (Sort sort, Integer page, Integer size) throws NoResultException {

        try {
            Pageable pageable = PageRequest.of(page,size,sort);
            return maquinaRepository.findAll(pageable);
        }catch (Exception ex){
            logger.error("Não foi possivel localizar maquina ->" , ex.getMessage());
            throw new NoResultException();
        }

    }


}
