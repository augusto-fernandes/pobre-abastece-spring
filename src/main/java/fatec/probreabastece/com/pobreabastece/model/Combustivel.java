package fatec.probreabastece.com.pobreabastece.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COMBUSTIVEL")
public class Combustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_combustivel;
    private String descricao_combustivel;

    @ManyToMany(mappedBy = "id_combustivel")
    public List<HistoricoPreco> historico;

}
