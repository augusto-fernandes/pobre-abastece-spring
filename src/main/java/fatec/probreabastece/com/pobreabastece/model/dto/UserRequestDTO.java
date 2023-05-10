package fatec.probreabastece.com.pobreabastece.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    private String nome;
    private String localizacao;
    private String phone;
    private String email;
    private String password;
}
