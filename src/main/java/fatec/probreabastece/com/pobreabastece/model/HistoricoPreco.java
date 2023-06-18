package fatec.probreabastece.com.pobreabastece.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


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
    private long id;
    private String preco;
    private Date dataAlterecao;
  
    
//    @ManyToMany
//    @JoinTable(name = "COMBUSTIVEL_JOIN", joinColumns =
//     @JoinColumn(name = "idCombustivel"), inverseJoinColumns =
//     @JoinColumn(name = "idCombustivel1"))
//    private List<Combustivel> combustivel;

    @ManyToOne
    @JoinColumn(name = "posto")
    private Posto posto;



}
