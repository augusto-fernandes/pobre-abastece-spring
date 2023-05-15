package fatec.probreabastece.com.pobreabastece.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id_posto;
    private String nome;
    private String cnpj;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco id_endereco;

    @ManyToMany(mappedBy = "id_posto")
    public Set<HistoricoPreco> historico;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_posto")
    private java.util.Set<Avaliacao> avaliacao;

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
