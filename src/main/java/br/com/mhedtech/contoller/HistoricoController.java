package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.HistoricoDto;
import br.com.mhedtech.repository.HistoricoRepository;
import br.com.mhedtech.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;

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


    @GetMapping("/lista-historico")
    public ResponseEntity<?> listaHistorico    (@RequestParam("sort") Sort.Direction direction,
                                              @RequestParam("properties") String properties,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("size") Integer size) {


        try {
            HistoricoDto historicoDto = new HistoricoDto();
            return ResponseEntity.ok(historicoService.listaHistorico(Sort.by(direction, properties), page, size));

        } catch (NoResultException ex) {
            return ResponseEntity.ok("Historicos não encontrados.");
        }

    }


}
