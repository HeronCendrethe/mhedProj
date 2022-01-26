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
            "coinTenMinEntity.dateTimeCoin = :timeCoin where coinTenMinEntity.id = :id")
    void updateValuesForTenMinElapsed(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("close") Float close);

    @Modifying
    @Query("update CoinTenMinEntity coinTenMinEntity set "+
            "coinTenMinEntity.dateTimeCoin = :timeCoin,coinTenMinEntity.highValue = :high where coinTenMinEntity.id = :id")
    void updateMaxValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("high") Float high);

    @Modifying
    @Query("update CoinTenMinEntity coinTenMinEntity set "+
            "coinTenMinEntity.dateTimeCoin = :timeCoin,coinTenMinEntity.lowValue = :low where coinTenMinEntity.id = :id")
    void updateLowValueForFiveSeconds(@Param("id") Integer id,  @Param("timeCoin") LocalDateTime timeCoin, @Param("low") Float low);

    @Query("select highValue from CoinTenMinEntity coinTenMinEntity where coinTenMinEntity.id = :id")
    Float findHighValueById(@Param("id") Integer id);

    @Query("select lowValue from CoinTenMinEntity coinTenMinEntity where coinTenMinEntity.id = :id")
    Float findLowValueById(@Param("id") Integer id);


}
