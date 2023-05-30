package fatec.probreabastece.com.pobreabastece.service;

import fatec.probreabastece.com.pobreabastece.model.Endereco;
import fatec.probreabastece.com.pobreabastece.model.Posto;
import fatec.probreabastece.com.pobreabastece.repository.EnderecoRepository;
import fatec.probreabastece.com.pobreabastece.repository.PostoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Posto save(Posto posto, Endereco endereco){
        logger.info("Endereço cadastrado");
        enderecoRepository.save(endereco);
        Integer idEndereco = endereco.getIdEndereco();
        posto.setIdEndereco(endereco);
        return  repository.save(posto);
    }
    public Posto listarMeuPosto(Long id){
        Optional<Posto> posto = repository.findById(id);
        return posto.orElse(null);
    }}