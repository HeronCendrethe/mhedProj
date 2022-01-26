package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinFiveMinRepository;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.dto.Coin;
import br.com.smartbot.testesmartbot.repository.CoinTenMinRepository;
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
@Service
@EnableScheduling
public class CoinOneMinService{

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinOneMinRepository coinOneMinRepository;
    @Autowired
    CoinFiveMinRepository coinFiveMinRepository;
    @Autowired
    CoinTenMinRepository coinTenMinRepository;
    @Autowired
    Coin coin;


    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest (){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            Float nowValue = Float.valueOf(keyCoin.getLast());
            CoinOneMinEntity coinOneMinEntity = new CoinOneMinEntity();
            coinOneMinEntity.setHighValue(nowValue);
            coinOneMinEntity.setLowValue(nowValue);
            coinOneMinEntity.setId(keyCoin.getId());
            coinOneMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinOneMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.save(coinOneMinEntity);
        }

    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void insertValuesFor1MinuteElapsed(){

        Map<String,Coin> mapCoin = new HashMap<>();
        List<Float> highAndLowValue = new ArrayList<>();
        List<Coin> coinList = new ArrayList<>();


        for(Coin keyCoin : coin.mappingApiResults(consumer)){

            System.out.println(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.updateValuesForOneMinElapsed(keyCoin.getId(), LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
          }
       }

    @Transactional
    @Scheduled(fixedRate = 5000)
    public void maxAndLowValues(){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            Float nowValue = Float.valueOf(keyCoin.getLast());

            Float maxValueDB = coinOneMinRepository.findHighValueById(keyCoin.getId());

            if(maxValueDB < nowValue){
                coinOneMinRepository.updateMaxValueForFiveSeconds(keyCoin.getId(), LocalDateTime.now(),nowValue);

            }

            Float lowValueDB = coinOneMinRepository.findLowValueById(keyCoin.getId());

            if(lowValueDB > nowValue){
                coinOneMinRepository.updateLowValueForFiveSeconds(keyCoin.getId(),LocalDateTime.now(),nowValue);
            }
        }
    }
}
