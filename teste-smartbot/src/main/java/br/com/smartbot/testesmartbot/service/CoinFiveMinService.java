package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinFiveMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinFiveMinRepository;
import br.com.smartbot.testesmartbot.dto.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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
            Float nowValue = Float.valueOf(keyCoin.getLast());
            CoinFiveMinEntity coinFiveMinEntity = new CoinFiveMinEntity();
            coinFiveMinEntity.setHighValue(nowValue);
            coinFiveMinEntity.setLowValue(nowValue);
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


        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            System.out.println(Float.valueOf(keyCoin.getLast()));
            coinFiveMinRepository.updateValuesForFiveMinElapsed(keyCoin.getId(), LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
        }

    }

    @Transactional
    @Scheduled(fixedRate = 6000)
    public void maxAndLowValues(){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            Float nowValue = Float.valueOf(keyCoin.getLast());

            Float maxValueDB = coinFiveMinRepository.findHighValueById(keyCoin.getId());

            if(maxValueDB < nowValue){
                coinFiveMinRepository.updateMaxValueForFiveSeconds(keyCoin.getId(), LocalDateTime.now(),nowValue);

            }

            Float lowValueDB = coinFiveMinRepository.findLowValueById(keyCoin.getId());

            if(lowValueDB > nowValue){
                coinFiveMinRepository.updateLowValueForFiveSeconds(keyCoin.getId(),LocalDateTime.now(),nowValue);
            }
        }
    }



}





