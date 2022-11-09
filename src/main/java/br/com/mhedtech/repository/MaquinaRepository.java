package br.com.mhedtech.repository;

import br.com.mhedtech.entity.MaquinaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MaquinaRepository extends PagingAndSortingRepository<MaquinaEntity,Integer> {

    Optional<MaquinaEntity> findByPatrimonio(Long Id);



}
