package br.com.mhedtech.repository;

import br.com.mhedtech.entity.MaquinaEntity;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaquinaRepository extends PagingAndSortingRepository<MaquinaEntity,Integer> {

    Optional<MaquinaEntity> findByPatrimonio(Long Id);


}
