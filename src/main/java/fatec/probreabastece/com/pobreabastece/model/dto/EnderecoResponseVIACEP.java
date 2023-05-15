package fatec.probreabastece.com.pobreabastece.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseVIACEP {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    
}
