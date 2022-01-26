package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinTenMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinTenMinRepository;
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
            Float nowValue = Float.valueOf(keyCoin.getLast());
            CoinTenMinEntity coinTenMinEntity = new CoinTenMinEntity();
            coinTenMinEntity.setHighValue(nowValue);
            coinTenMinEntity.setLowValue(nowValue);
            coinTenMinEntity.setId(keyCoin.getId());
            coinTenMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinTenMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinTenMinRepository.save(coinTenMinEntity);
        }

    }

    @Transactional
    @Scheduled(fixedRate = 600000)
    public void insertValuesFor1MinuteElapsed() {

        Map<String,Coin> mapCoin = new HashMap<>();
        List<Float> highAndLowValue = new ArrayList<>();
        List<Coin> coinList = new ArrayList<>();

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            System.out.println(Float.valueOf(keyCoin.getLast()));
            coinTenMinRepository.updateValuesForTenMinElapsed(keyCoin.getId(),LocalDateTime.now(),Float.valueOf(keyCoin.getLast()));
        }

    }

    @Transactional
    @Scheduled(fixedRate = 6000)
    public void maxAndLowValues(){

        for(Coin keyCoin : coin.mappingApiResults(consumer)){
            Float nowValue = Float.valueOf(keyCoin.getLast());

            Float maxValueDB = coinTenMinRepository.findHighValueById(keyCoin.getId());

            if(maxValueDB < nowValue){
                coinTenMinRepository.updateMaxValueForFiveSeconds(keyCoin.getId(), LocalDateTime.now(),nowValue);

            }

            Float lowValueDB = coinTenMinRepository.findLowValueById(keyCoin.getId());

            if(lowValueDB > nowValue){
                coinTenMinRepository.updateLowValueForFiveSeconds(keyCoin.getId(),LocalDateTime.now(),nowValue);
            }
        }
    }

}
