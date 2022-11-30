package br.com.mhedtech.repository;



import br.com.mhedtech.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository <UsuarioEntity,Integer> {

    @Query(value = "select u from UsuarioEntity u join u.maquina m where m.patrimonio = :patrimonio")
    Optional<UsuarioEntity> buscaUsuarioPorIdMaquina(Long patrimonio);

    Optional<UsuarioEntity> findById(Integer ID);

    @Modifying
    @Query("update UsuarioEntity usuarioEntity set "+
            "usuarioEntity.nome = :nome, usuarioEntity.setor = :setor, usuarioEntity.maquina = (select m from MaquinaEntity m where m.patrimonio = :maquina ) where usuarioEntity.id = :id ")
    void updateUsuarios(@Param("id") Integer id, @Param("nome")String nome, @Param("setor") String setor, @Param("maquina")Long maquina);

}
