package br.com.mhedtech.service;


import br.com.mhedtech.dto.MaquinaDto;
import br.com.mhedtech.entity.MaquinaEntity;
import br.com.mhedtech.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

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


}
