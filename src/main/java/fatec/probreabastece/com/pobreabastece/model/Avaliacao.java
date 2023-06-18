package fatec.probreabastece.com.pobreabastece.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "AVALIACAO")
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nota; 
    private String descricaoAvaliacao;
    
    @ManyToOne
    @JoinColumn(name = "posto_id")
    private Posto posto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
