package br.com.smartbot.testesmartbot.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url= "https://poloniex.com/public?command=returnTicker" , name = "poloniex")
public interface CoinConsumer {

    @GetMapping()
    Object find();

}
