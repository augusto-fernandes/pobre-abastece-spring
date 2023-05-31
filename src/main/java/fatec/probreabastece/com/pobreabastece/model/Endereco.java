package fatec.probreabastece.com.pobreabastece.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.util.ClassUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


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
    private Integer idEndereco;
    private Integer cep;
    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Posto posto;


}
