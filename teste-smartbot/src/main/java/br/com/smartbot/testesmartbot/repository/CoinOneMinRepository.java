package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CoinOneMinRepository extends PagingAndSortingRepository<CoinOneMinEntity,Integer> {


    @Modifying
    @Query("update CoinOneMinEntity coinOneMinEntity set coinOneMinEntity.closeValue = :close, "+
            "coinOneMinEntity.dateTimeCoin = :timeCoin, coinOneMinEntity.highValue = :high, coinOneMinEntity.lowValue = :low where coinOneMinEntity.id = :id")
    void updateValuesForOneMinElapsed(@Param("id") Integer id,@Param("high") Float high, @Param("low") Float low, @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);



}
