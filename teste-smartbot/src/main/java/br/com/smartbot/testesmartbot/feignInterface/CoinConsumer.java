package br.com.smartbot.testesmartbot.feignInterface;

import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(url= "https://poloniex.com/public?command=returnTicker" , name = "poloniex")
public interface CoinConsumer {

    @GetMapping()
    Object find();

}
