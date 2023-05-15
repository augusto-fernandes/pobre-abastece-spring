package fatec.probreabastece.com.pobreabastece.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoRequestVIACEP;
import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoResponseVIACEP;
import fatec.probreabastece.com.pobreabastece.service.EnderecoServiceCEP;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RequestMapping("/pcep")
@RestController
public class ViaCepController {

    private final EnderecoServiceCEP enderecoService;

    @GetMapping("/consulta")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequestVIACEP enderecoRequest) {
        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
    }
    
}
