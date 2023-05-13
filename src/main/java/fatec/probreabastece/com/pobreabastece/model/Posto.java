package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
@Table(name = "POSTO")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_posto;
    private String nome;
    private String cnpj;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posto posto = (Posto) o;
        return Objects.equals(nome, posto.nome) && Objects.equals(cnpj, posto.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cnpj);
    }
}
