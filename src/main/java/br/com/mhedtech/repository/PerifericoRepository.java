package br.com.mhedtech.repository;

import br.com.mhedtech.entity.PerifericoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerifericoRepository extends PagingAndSortingRepository<PerifericoEntity,Integer > {

}
