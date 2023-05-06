package fatec.probreabastece.com.pobreabastece.repository;

import fatec.probreabastece.com.pobreabastece.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
