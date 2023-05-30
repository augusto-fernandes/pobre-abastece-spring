package fatec.probreabastece.com.pobreabastece.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.Objects;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POSTO")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPosto;
    private String nome;
    private String cnpj;
    private String bandeira;
    private String horario_atendimento;
    private String servicos;
    private String pagamento;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    private Endereco idEndereco;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "idPosto")
    public List<HistoricoPreco> historico;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "idPosto")
    private List<Avaliacao> avaliacao;

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
