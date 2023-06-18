package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cep;
    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @OneToOne (mappedBy = "endereco")
    private Posto posto;

    @OneToMany(mappedBy = "endereco")
    private List<User> user;


}
