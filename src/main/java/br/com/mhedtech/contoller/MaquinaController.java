package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.MaquinaDto;
import br.com.mhedtech.dto.PerifericoDto;
import br.com.mhedtech.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;


@Controller
@RequestMapping("maquina")
public class MaquinaController {


    @Autowired
    private MaquinaService maquinaService;


    @PostMapping("/cadastro-maquina")
    public ResponseEntity<?> criarUsuario(@RequestBody MaquinaDto maquinaDto){
            return ResponseEntity.ok(maquinaService.criarMaquina(maquinaDto));
    }


    @GetMapping("/lista-maquina")
    public ResponseEntity<?> listaMaquina    (@RequestParam("sort") Sort.Direction direction,
                                             @RequestParam("properties") String properties,
                                             @RequestParam("page") Integer page,
                                             @RequestParam("size") Integer size) {


        try {
            MaquinaDto maquinaDto = new MaquinaDto();
            return ResponseEntity.ok(maquinaService.listaMaquina(Sort.by(direction, properties), page, size));

        } catch (NoResultException ex) {
            return ResponseEntity.ok("Maquinas não encontradas.");
        }

    }
}
