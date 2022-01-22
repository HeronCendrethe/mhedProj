package br.com.smartbot.testesmartbot.contoller;


import br.com.smartbot.testesmartbot.service.CoinOneMinService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/coin")
public class CoinOneMinController {

    @Autowired
    private CoinOneMinService coinService;



}
