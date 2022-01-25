package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.vo.Coin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.SQLDataException;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Service
@EnableScheduling
public class CoinOneMinService{

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinOneMinRepository coinOneMinRepository;
    @Autowired
    Coin coin;


    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest (){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            CoinOneMinEntity coinOneMinEntity = new CoinOneMinEntity();
            coinOneMinEntity.setId(keyCoin.getId());
            coinOneMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinOneMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.save(coinOneMinEntity);
        }

    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void insertValuesFor1MinuteElapsed() throws SQLDataException {

        Map<String,Coin> mapCoin = new HashMap<>();
        List<Float> highAndLowValue = new ArrayList<>();
        List<Coin> coinList = new ArrayList<>();

        for(int i = 0; i < 1; i++){

            for(Coin keyCoin : coin.mappingApiResults(consumer)){
                highAndLowValue.add(Float.valueOf(keyCoin.getLast()));

            }
        }

        FindMaxAndLowValues findMaxAndLowValues = new FindMaxAndLowValues();
        Float highValue = findMaxAndLowValues.findHighValue(highAndLowValue);
        Float lowValue = findMaxAndLowValues.findLowValue(highAndLowValue);


        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            System.out.println(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.updateValuesForOneMinElapsed(keyCoin.getId(), highValue,lowValue, LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
        }

    }


}
