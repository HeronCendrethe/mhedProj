package br.com.mhedtech.repository;

import br.com.mhedtech.entity.PerifericoEntity;
import br.com.mhedtech.entity.UsuarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PerifericoRepository extends PagingAndSortingRepository<PerifericoEntity,Integer > {


    Optional<PerifericoEntity> findById(Integer ID);

}
