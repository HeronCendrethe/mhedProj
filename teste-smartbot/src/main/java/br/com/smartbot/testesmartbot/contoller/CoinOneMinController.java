package br.com.smartbot.testesmartbot.contoller;


import br.com.smartbot.testesmartbot.service.CoinOneMinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/coin")
public class CoinOneMinController {

    @Autowired
    private CoinOneMinService coinService;

    @GetMapping("/search-coin")
    public ResponseEntity<?> getCoins() throws IOException {
       return ResponseEntity.ok(coinService.findAllCoins());
    }
}