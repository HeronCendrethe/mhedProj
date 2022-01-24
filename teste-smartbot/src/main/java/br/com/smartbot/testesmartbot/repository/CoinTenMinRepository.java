package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinTenMinEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CoinTenMinRepository extends PagingAndSortingRepository<CoinTenMinEntity,Integer> {

    @Modifying
    @Query("update CoinTenMinEntity coinTenMinEntity set coinTenMinEntity.closeValue = :close, "+
            "coinTenMinEntity.dateTimeCoin = :timeCoin, coinTenMinEntity.highValue = :high, coinTenMinEntity.lowValue = :low where coinTenMinEntity.id = :id")
    void updateValuesForOneMinElapsed(@Param("id") Integer id, @Param("high") Float high, @Param("low") Float low, @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);


}
