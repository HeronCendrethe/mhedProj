package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.PerifericoDto;
import br.com.mhedtech.repository.PerifericoRepository;
import br.com.mhedtech.service.PerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("periferico")
public class PerificoController {

    @Autowired
    PerifericoRepository perifericoRepository;

    @Autowired
    PerifericoService perifericoService;



    @PostMapping("/cria-periferico")
    public ResponseEntity<String> criaPeriferico(@RequestBody PerifericoDto perifericoDto){

        try {
            System.out.println(perifericoDto.getConfig());
            System.out.println(perifericoDto.getModelo());


            perifericoService.criarPeriferico(perifericoDto);
            return ResponseEntity.ok("Periferico criado com sucesso!");
        }catch (Exception ex){
            StringBuilder mensagemRetorno = new StringBuilder();
            mensagemRetorno.append("Não foi possivel criar o periferico ->");
            mensagemRetorno.append(ex.getMessage());
            return ResponseEntity.ok(mensagemRetorno.toString());
        }



    }
}
