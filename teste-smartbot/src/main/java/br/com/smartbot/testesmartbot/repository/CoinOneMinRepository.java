package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CoinOneMinRepository extends PagingAndSortingRepository<CoinOneMinEntity,Integer> {


    @Modifying
    @Query("update CoinOneMinEntity coinOneMinEntity set coinOneMinEntity.closeValue = :close, "+
            "coinOneMinEntity.dateTimeCoin = :timeCoin where coinOneMinEntity.id = :id")
    void updateValuesForOneMinElapsed(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);

    @Modifying
    @Query("update CoinOneMinEntity coinOneMinEntity set "+
            "coinOneMinEntity.dateTimeCoin = :timeCoin,coinOneMinEntity.highValue = :high where coinOneMinEntity.id = :id")
    void updateMaxValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("high") Float high);

    @Modifying
    @Query("update CoinOneMinEntity coinOneMinEntity set "+
            "coinOneMinEntity.dateTimeCoin = :timeCoin,coinOneMinEntity.lowValue = :low where coinOneMinEntity.id = :id")
    void updateLowValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("low") Float low);


    @Query("select highValue from CoinOneMinEntity coinOneMinEntity where coinOneMinEntity.id = :id")
    Float findHighValueById(@Param("id") Integer id);

    @Query("select lowValue from CoinOneMinEntity coinOneMinEntity where coinOneMinEntity.id = :id")
    Float findLowValueById(@Param("id") Integer id);




}
