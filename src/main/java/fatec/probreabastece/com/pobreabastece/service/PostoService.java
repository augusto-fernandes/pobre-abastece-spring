package fatec.probreabastece.com.pobreabastece.service;

import fatec.probreabastece.com.pobreabastece.model.Posto;
import fatec.probreabastece.com.pobreabastece.repository.EnderecoRepository;
import fatec.probreabastece.com.pobreabastece.repository.PostoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class PostoService {

    @Autowired
    PostoRepository repository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ModelMapper mapper;

    private Logger logger = Logger.getLogger(PostoService.class.getName());

    public List<Posto> todosPostos()
    {
        logger.info( "Todos os postos");
        return repository.findAll();
    }


    public ResponseEntity<String> create(Posto posto){
        logger.info("Cadastro posto");
        if(postoCadastrado(posto.getEmail()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O email informado já existe");

        else {
            repository.save(posto);
            return ResponseEntity.ok("Posto cadastrado com sucesso");
        }
    }
    public Posto listarMeuPosto(Long id){
        Optional<Posto> posto = repository.findById(id);
        return posto.orElse(null);
    }
    @Transactional
    public ResponseEntity<String> delete(Posto posto) {
        logger.info(" tentando deletar posto");
        if(postoCadastrado(posto.getEmail())) {
            repository.deleteByEmail(posto.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body("Posto Deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O email informado não em nossa base de dados");
        }


    }

    public ResponseEntity<String> update(Posto posto){
        logger.info("Alteração posto");
        if(postoCadastrado(posto.getEmail())) {
            repository.save(posto);
            return ResponseEntity.ok("Posto cadastrado com sucesso");
        }
        else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O email informado não existe existe");

        }
    }

    public boolean postoCadastrado(String email){
        return repository.existsByEmail(email);
    }

}