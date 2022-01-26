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
            "coinFiveMinEntity.dateTimeCoin = :timeCoin where coinFiveMinEntity.id = :id")
    void updateValuesForFiveMinElapsed(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);

    @Modifying
    @Query("update CoinFiveMinEntity coinFiveMinEntity set "+
            "coinFiveMinEntity.dateTimeCoin = :timeCoin,coinFiveMinEntity.highValue = :high where coinFiveMinEntity.id = :id")
    void updateMaxValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("high") Float high);

    @Modifying
    @Query("update CoinFiveMinEntity coinFiveMinEntity set "+
            "coinFiveMinEntity.dateTimeCoin = :timeCoin,coinFiveMinEntity.lowValue = :low where coinFiveMinEntity.id = :id")
    void updateLowValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("low") Float low);


    @Query("select highValue from CoinFiveMinEntity coinFiveMinEntity where coinFiveMinEntity.id = :id")
    Float findHighValueById(@Param("id") Integer id);

    @Query("select lowValue from CoinFiveMinEntity coinFiveMinEntity where coinFiveMinEntity.id = :id")
    Float findLowValueById(@Param("id") Integer id);
}


