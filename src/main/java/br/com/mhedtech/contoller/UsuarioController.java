package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.UsuarioDto;
import br.com.mhedtech.service.UsuarioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/registro")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDto usuarioDto){

        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioDto));


    }


    @GetMapping("/busca-usuario-por-patrimonio/{patrimonio}")
    public ResponseEntity<?> buscaUsuarioPorPatrimonio(@PathVariable("patrimonio") Long patrimonio){

        System.out.println(patrimonio);

        UsuarioDto usuarioDto = new UsuarioDto();
        try{
               usuarioDto = usuarioService.buscaUsuarioPeloPatrimonio(patrimonio);
        }catch(NoResultException ex){
            return ResponseEntity.ok("Usuário não encontrado, verifique o numero de patrimonio");
        }

        return ResponseEntity.ok(usuarioDto);


    }
}
