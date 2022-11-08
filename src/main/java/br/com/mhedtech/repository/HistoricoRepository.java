package br.com.mhedtech.repository;

import br.com.mhedtech.entity.HistoricoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface HistoricoRepository extends PagingAndSortingRepository<HistoricoEntity,Integer >{

    Optional<HistoricoEntity> findBydescricao(String descricao);
}
