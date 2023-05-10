package fatec.probreabastece.com.pobreabastece.model.dto;

import fatec.probreabastece.com.pobreabastece.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class UserResponseDTO {

    private Long id;
    private  String nome;
    private  String localizacao;
    private  String phone;
    private  String email;

    public UserResponseDTO(User user){
        id = user.getId();
        nome = user.getNome();
        localizacao = user.getNome();
        phone = user.getPhone();
        email = user.getEmail();


    }


}
