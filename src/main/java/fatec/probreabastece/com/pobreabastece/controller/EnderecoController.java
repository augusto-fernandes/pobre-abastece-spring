package fatec.probreabastece.com.pobreabastece.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fatec.probreabastece.com.pobreabastece.model.Endereco;
import fatec.probreabastece.com.pobreabastece.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value= "/endereco")
public class EnderecoController {
    

    @Autowired
    public EnderecoRepository repository;


    @Autowired
    public ViaCepController viacep;


    public List<Endereco> listarTodosEndereco(){
        return repository.findAll();
    }

    @PostMapping
    public void salvarEndereco(Endereco endereco)
    {
        repository.save(endereco);
    }
    
    @PutMapping(value = "/altera")
    public void alterarEndereco(Endereco endereco)
    {
        if(endereco.getId_endereco()>0)
        repository.save(endereco);
    }
    @DeleteMapping
    public void excluirEndereco(Endereco endereco)
    {
        repository.delete(endereco);
    }
    
    
}
