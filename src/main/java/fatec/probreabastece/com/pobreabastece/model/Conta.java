package fatec.probreabastece.com.pobreabastece.model;

import java.util.List;
import java.util.Set;

import org.yaml.snakeyaml.emitter.Emitable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_conta;
    private String nome;
    private String email; 
    private String senha; 
    private String tipo_conta;
    
@ManyToMany(mappedBy = "id_conta")
private List<HistoricoPreco> historico;

@OneToMany(mappedBy = "id_conta")
private List<Avaliacao> avaliacao;

}
