package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinFiveMinEntity;
import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinFiveMinRepository;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Component
@EnableScheduling
@Service
public class CoinFiveMinService{

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinFiveMinRepository coinFiveMinRepository;
    @Autowired
    Coin coin;

    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest(){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            CoinFiveMinEntity coinFiveMinEntity = new CoinFiveMinEntity();
            coinFiveMinEntity.setId(keyCoin.getId());
            coinFiveMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinFiveMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinFiveMinRepository.save(coinFiveMinEntity);
        }

    }

    @Transactional
    @Scheduled(fixedRate = 300000)
    public void insertValuesFor1MinuteElapsed(){

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
            coinFiveMinRepository.updateValuesForFiveMinElapsed(keyCoin.getId(), highValue,lowValue, LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
        }

    }



}





