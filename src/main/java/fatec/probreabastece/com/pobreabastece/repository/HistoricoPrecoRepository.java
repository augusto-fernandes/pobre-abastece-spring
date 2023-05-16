package fatec.probreabastece.com.pobreabastece.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fatec.probreabastece.com.pobreabastece.model.HistoricoPreco;

@Repository
public interface HistoricoPrecoRepository extends JpaRepository<HistoricoPreco, Long>{
    
}
