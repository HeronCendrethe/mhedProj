package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinFiveMinEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CoinFiveMinRepository extends PagingAndSortingRepository<CoinFiveMinEntity,Integer> {

    @Modifying
    @Query("update CoinFiveMinEntity coinFiveMinEntity set coinFiveMinEntity.closeValue = :close, "+
            "coinFiveMinEntity.dateTimeCoin = :timeCoin, coinFiveMinEntity.highValue = :high, coinFiveMinEntity.lowValue = :low where coinFiveMinEntity.id = :id")
    void updateValuesForFiveMinElapsed(@Param("id") Integer id, @Param("high") Float high, @Param("low") Float low, @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);
}


