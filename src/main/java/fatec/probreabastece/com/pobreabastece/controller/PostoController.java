package fatec.probreabastece.com.pobreabastece.controller;

import fatec.probreabastece.com.pobreabastece.configuration.util.MediaType;
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


    @GetMapping(produces ={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public List<Posto> todosPostos() {
        return  service.todosPostos();
    }



    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
    public ResponseEntity<Posto> listarPosto(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(service.listarMeuPosto(id));

    }

    @PostMapping(consumes =  { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML },
                 produces = { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
    public ResponseEntity<String> create(@RequestBody Posto posto){

        return service.create(posto);
    }

    @DeleteMapping
    ResponseEntity<String> deletarPosto(@RequestBody Posto posto){

        return service.delete(posto);

    }
    @PutMapping(consumes =  { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML },
            produces = { MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
    ResponseEntity<String> update(@RequestBody Posto posto){
        return service.update(posto);
    }

}
