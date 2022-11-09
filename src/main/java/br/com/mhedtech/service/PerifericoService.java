package br.com.mhedtech.service;

import br.com.mhedtech.dto.PerifericoDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.entity.PerifericoEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import br.com.mhedtech.repository.PerifericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class PerifericoService {

    @Autowired
    PerifericoRepository perifericoRepository;

    @Autowired
    MaquinaRepository maquinaRepository;


    public void criarPeriferico(PerifericoDto perifericoDto){
        PerifericoEntity perifericoEntity = new PerifericoEntity();


        Optional<MaquinaEntity> maquina = maquinaRepository.findByPatrimonio(perifericoDto.getMaquina());
        if(!maquina.isPresent())
            throw new NoResultException();

            perifericoDto.setEntity(perifericoEntity);
            perifericoEntity.setMaquina(maquina.get());
            perifericoRepository.save(perifericoEntity);

    }
}
