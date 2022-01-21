package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CoinOneMinService {

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinOneMinRepository coinOneMinRepository;

    public List<Coin> findAllCoins (){
        Map<String,Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

//        for(Coin keyCoin : coinList){
//
//            coinOneMinRepository.insertValuesPrimaryRequest(Integer.valueOf(keyCoin.getId()), BigDecimal.class.cast(keyCoin.getLast()), LocalDateTime.now());
//        }


        return  coinList;
    }

}
