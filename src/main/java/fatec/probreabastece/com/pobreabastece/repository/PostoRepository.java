package fatec.probreabastece.com.pobreabastece.repository;

import fatec.probreabastece.com.pobreabastece.model.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository  extends JpaRepository<Posto, Long> {
    boolean existsByEmail(String email);

    @Modifying
    @Query("DELETE FROM Posto p WHERE p.email = :email")
    void deleteByEmail(String email);
}
