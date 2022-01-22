package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.vo.Coin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CoinOneMinService{

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinOneMinRepository coinOneMinRepository;


    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest (){
        Map<String,Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

        ObjectMapper mapper = new ObjectMapper();

        List<Coin> coin = mapper.convertValue(
                coinList,
                new TypeReference<List<Coin>>() { });

        for(Coin keyCoin : coin){
            CoinOneMinEntity coinOneMinEntity = new CoinOneMinEntity();
            coinOneMinEntity.setId(keyCoin.getId());
            coinOneMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinOneMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.save(coinOneMinEntity);
        }

    }

    public void insertValuesFor1MinuteElapsed(){

        Map<String,Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

        ObjectMapper mapper = new ObjectMapper();

        List<Coin> coin = mapper.convertValue(
                coinList,
                new TypeReference<List<Coin>>() { });
        for(int i = 0; i < 60000; i++){



        }

        for(Coin keyCoin : coin){
            CoinOneMinEntity coinOneMinEntity = new CoinOneMinEntity();
            coinOneMinEntity.setId(keyCoin.getId());
            coinOneMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinOneMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinOneMinRepository.save(coinOneMinEntity);
        }

    }

}
