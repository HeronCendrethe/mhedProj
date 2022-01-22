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
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CoinFiveMinService{

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinTenMinService coinTenMinService;
    @Autowired
    CoinFiveMinRepository coinFiveMinRepository;

    @PostConstruct
    public void insertPrimaryValuesForPrimaryRequest (){
        Map<String, Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

        ObjectMapper mapper = new ObjectMapper();

        List<Coin> coin = mapper.convertValue(
                coinList,
                new TypeReference<List<Coin>>() { });

        for(Coin keyCoin : coin){
            CoinFiveMinEntity coinFiveMinEntity = new CoinFiveMinEntity();
            coinFiveMinEntity.setId(keyCoin.getId());
            coinFiveMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinFiveMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinFiveMinRepository.save(coinFiveMinEntity);
        }

    }




}
