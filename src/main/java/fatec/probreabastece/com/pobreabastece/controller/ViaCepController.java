package fatec.probreabastece.com.pobreabastece.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoResponseVIACEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.probreabastece.com.pobreabastece.model.dto.EnderecoRequestVIACEP;
import fatec.probreabastece.com.pobreabastece.service.EnderecoServiceCEP;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/endereco")
public class ViaCepController {

    private final EnderecoServiceCEP enderecoService;

    @GetMapping
    public ResponseEntity consultaCep(@RequestBody EnderecoRequestVIACEP enderecoRequest) {


        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
    }
    
}
