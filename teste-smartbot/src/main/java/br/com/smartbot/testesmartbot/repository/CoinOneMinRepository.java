package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CoinOneMinRepository extends PagingAndSortingRepository<CoinOneMinEntity,Integer> {

    @Query("insert into CoinOneMinEntity c (c.id) values (:ID)")
    void insertIds (@Param("ID") Integer ids);

//    @Query(value = "update coin_one_min set id = :#{#id},open_value = ::#{#open},date_time_coin = ::#{#dateTime}; ", nativeQuery = true)
//    void insertValuesPrimaryRequest(@Param(":id") Integer ID, @Param(":open") BigDecimal coin, @Param("dateTime")LocalDateTime dateTime);



}
