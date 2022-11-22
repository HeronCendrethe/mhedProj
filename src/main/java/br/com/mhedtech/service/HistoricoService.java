package br.com.mhedtech.service;

import br.com.mhedtech.dto.HistoricoDto;

import br.com.mhedtech.entity.HistoricoEntity;
import br.com.mhedtech.entity.MaquinaEntity;

import br.com.mhedtech.repository.HistoricoRepository;
import br.com.mhedtech.repository.MaquinaRepository;


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
public class HistoricoService {
    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private MaquinaRepository maquinaRepository;

    private  Logger logger;


    public void criaHistorico(HistoricoDto historicoDto) throws NoResultException{
        HistoricoEntity historicoEntity = new HistoricoEntity();
        historicoDto.setEntity(historicoEntity);
        Optional<MaquinaEntity> maquina = maquinaRepository.findByPatrimonio(historicoDto.getMaquina());
        if(!maquina.isPresent())
            throw new NoResultException();

        try{
            historicoEntity.setMaquina(maquina.get());
            historicoRepository.save(historicoEntity);
        }catch (Exception ex){
            logger.error("Não foi possivel cadastrar Historico ->" , ex.getMessage());

        }


    }


    public Page<HistoricoEntity> listaHistorico (Sort sort, Integer page, Integer size) throws NoResultException {

        try {
            Pageable pageable = PageRequest.of(page,size,sort);
            return historicoRepository.findAll(pageable);
        }catch (Exception ex){
            logger.error("Não foi possivel localizar historicos ->" , ex.getMessage());
            throw new NoResultException();
        }

    }

}
