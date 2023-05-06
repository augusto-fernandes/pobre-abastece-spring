package fatec.probreabastece.com.pobreabastece.repository;

import fatec.probreabastece.com.pobreabastece.model.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository  extends JpaRepository<Posto, Long> {
}
