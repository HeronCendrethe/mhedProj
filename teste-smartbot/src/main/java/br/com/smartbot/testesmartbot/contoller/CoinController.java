package br.com.smartbot.testesmartbot.contoller;


import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;

import br.com.smartbot.testesmartbot.service.CoinService;
import br.com.smartbot.testesmartbot.vo.Coin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/api/coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping("/search-coin")
    public ResponseEntity<?> getCoins() throws IOException {
       return ResponseEntity.ok(coinService.findAllCoins());
    }
}