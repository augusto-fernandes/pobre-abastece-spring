package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@Entity
@Table(name="endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_endereco")
    private Integer id_endereco;
    private Integer cep;
    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @OneToOne (mappedBy = "id_endereco")
    private Posto posto;

}
