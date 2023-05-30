package fatec.probreabastece.com.pobreabastece.controller;

import fatec.probreabastece.com.pobreabastece.model.Endereco;
import fatec.probreabastece.com.pobreabastece.model.Posto;
import fatec.probreabastece.com.pobreabastece.service.PostoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/postos")
public class PostoController {
    @Autowired
    PostoService service;
    @Autowired
    ModelMapper mapper;


    @GetMapping(value = "/todos")
    public List<Posto> todosPostos()
    {
        return  service.todosPostos();
    }

    @PostMapping
    public ResponseEntity<Posto> cadastroPosto(@RequestBody PostoEndereco[] meuArray) {
        Posto posto = new Posto();
        Endereco endereco = new Endereco();
     for (PostoEndereco postoEndereco : meuArray) {
               posto = (Posto) postoEndereco.getPosto();
                System.out.println("dados"+posto.getCnpj());
                endereco = (Endereco) postoEndereco.getEndereco();
            }
        Posto postoCriado = service.save(posto, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(postoCriado);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Posto> listarPosto(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(service.listarMeuPosto(id));

    }

}
