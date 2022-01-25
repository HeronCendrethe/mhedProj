package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinFiveMinEntity;
import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.entity.CoinTenMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.repository.CoinTenMinRepository;
import br.com.smartbot.testesmartbot.vo.Coin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Service
@EnableScheduling
public class CoinTenMinService {

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinTenMinRepository coinTenMinRepository;
    @Autowired
    Coin coin;

    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest (){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            CoinTenMinEntity coinTenMinEntity = new CoinTenMinEntity();
            coinTenMinEntity.setId(keyCoin.getId());
            coinTenMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinTenMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinTenMinRepository.save(coinTenMinEntity);
        }

    }

    @Transactional
    @Scheduled(fixedRate = 300000)
    public void insertValuesFor1MinuteElapsed() {

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
            coinTenMinRepository.updateValuesForOneMinElapsed(keyCoin.getId(), highValue,lowValue, LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
        }

    }

    public  Integer calculaMedia(Integer x, Integer y, Integer z) throws ArithmeticException{
        return x+z+z/3;
    }



}
