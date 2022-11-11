package br.com.mhedtech.contoller;

import br.com.mhedtech.dto.UsuarioDto;
import br.com.mhedtech.entity.UsuarioEntity;
import br.com.mhedtech.repository.UsuarioRepository;
import br.com.mhedtech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/registro")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDto usuarioDto){
        System.out.println(usuarioDto.getNome());

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


    @GetMapping("/lista-usuarios")
    public ResponseEntity<?> listaUsuarios(@RequestParam("sort")Sort.Direction direction,@RequestParam String properties, @RequestParam("page") Integer page, @RequestParam("size") Integer size ){
        try {
            UsuarioDto usuarioDto = new UsuarioDto();

            return ResponseEntity.ok( usuarioService.listaUsuarios(Sort.by(direction, properties),page,size));

        }catch(NoResultException ex){
            return ResponseEntity.ok("Usuarios não encontrados.");

        }


    }


}
