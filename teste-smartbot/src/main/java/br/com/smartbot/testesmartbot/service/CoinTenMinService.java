package br.com.smartbot.testesmartbot.service;

import br.com.smartbot.testesmartbot.entity.CoinOneMinEntity;
import br.com.smartbot.testesmartbot.entity.CoinTenMinEntity;
import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import br.com.smartbot.testesmartbot.repository.CoinOneMinRepository;
import br.com.smartbot.testesmartbot.repository.CoinTenMinRepository;
import br.com.smartbot.testesmartbot.vo.Coin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CoinTenMinService {

    @Autowired
    CoinConsumer consumer;
    @Autowired
    CoinTenMinRepository coinTenMinRepository;

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
            CoinTenMinEntity coinTenMinEntity = new CoinTenMinEntity();
            coinTenMinEntity.setId(keyCoin.getId());
            coinTenMinEntity.setDateTimeCoin(LocalDateTime.now());
            coinTenMinEntity.setOpenValue(Float.valueOf(keyCoin.getLast()));
            coinTenMinRepository.save(coinTenMinEntity);
        }

    }

}
