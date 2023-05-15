package fatec.probreabastece.com.pobreabastece.service;

import org.springframework.stereotype.Service;

import fatec.probreabastece.com.pobreabastece.feign.EnderecoFeign;
import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoRequestVIACEP;
import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoResponseVIACEP;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnderecoServiceCEP {

    private final EnderecoFeign enderecoFeign;

    public EnderecoResponseVIACEP executa(EnderecoRequestVIACEP request) {
        return enderecoFeign.buscaEnderecoCep(request.getCep());
    }
    
}
