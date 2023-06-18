package fatec.probreabastece.com.pobreabastece.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoResponseVIACEP;

@FeignClient(url ="https://viacep.com.br/ws/", name = "viacep" )
public interface EnderecoFeign {

     @GetMapping("/{cep}/json")
     EnderecoResponseVIACEP buscaEnderecoCep(@PathVariable("cep") String cep);
}
