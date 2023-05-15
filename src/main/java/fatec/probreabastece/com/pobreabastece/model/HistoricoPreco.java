package fatec.probreabastece.com.pobreabastece.model;

import java.text.DecimalFormat;
import java.util.Set;

import org.hibernate.mapping.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HISTORICO_PRECO")
public class HistoricoPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_historico;
    private String preco;
    private String data_alterecao;
  
    
    @ManyToMany
    @JoinTable(name = "COMBUSTIVEL_JOIN",
     joinColumns = 
     @JoinColumn(name = "id_combustivel")
     , inverseJoinColumns = 
     @JoinColumn(name = "id_combustivel1"))
    public java.util.List<Combustivel> id_combustivel;

    @ManyToMany
    @JoinTable(name = "POSTO_JOIN", 
    joinColumns = 
    @JoinColumn(name = "id_posto"), 
    inverseJoinColumns = 
    @JoinColumn(name = "id_posto1"))
    public java.util.List<Posto> id_posto;

    @ManyToMany
    @JoinTable(name = "CONTA_JOIN", 
    joinColumns = 
    @JoinColumn(name = "id_conta"),
    inverseJoinColumns = 
    @JoinColumn(name = "id_conta1"))
    public java.util.List<Conta> id_conta;

}
