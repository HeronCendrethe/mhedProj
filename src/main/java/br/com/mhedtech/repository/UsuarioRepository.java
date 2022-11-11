package br.com.mhedtech.repository;


import br.com.mhedtech.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository <UsuarioEntity,Integer> {

    @Query(value = "select u from UsuarioEntity u join u.maquina m where m.patrimonio = :patrimonio")
    Optional<UsuarioEntity> buscaUsuarioPorIdMaquina(Long patrimonio);

    Optional<UsuarioEntity> findById(Integer ID);


}
