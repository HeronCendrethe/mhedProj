package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.contoller.CoinController;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoinService {

    @Autowired
    CoinConsumer consumer;

    public List<Coin> findAllCoins (){
        Map<String,Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

        return  coinList;
    }

}
