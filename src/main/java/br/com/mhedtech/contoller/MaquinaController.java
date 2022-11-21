package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.MaquinaDto;
import br.com.mhedtech.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("maquina")
public class MaquinaController {


    @Autowired
    private MaquinaService maquinaService;


    @PostMapping("/cadastro-maquina")
    public ResponseEntity<?> criarUsuario(@RequestBody MaquinaDto maquinaDto){
            return ResponseEntity.ok(maquinaService.criarMaquina(maquinaDto));
    }

}
