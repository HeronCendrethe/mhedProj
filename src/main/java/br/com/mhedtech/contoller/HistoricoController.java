package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.HistoricoDto;
import br.com.mhedtech.repository.HistoricoRepository;
import br.com.mhedtech.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("historico")
public class HistoricoController {

    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private HistoricoService historicoService;

    @PostMapping("/cria-historico")
    public ResponseEntity<String> criaHistorico(@RequestBody HistoricoDto historicoDto){

        try {
            System.out.println(historicoDto.getDescricao());

            historicoService.criaHistorico(historicoDto);
            return ResponseEntity.ok("Historico criado com sucesso!");
        }catch (Exception ex){
            return ResponseEntity.ok("Não foi possivel criar historico");
        }



    }


}
