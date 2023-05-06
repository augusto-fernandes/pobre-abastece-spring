package fatec.probreabastece.com.pobreabastece.repository;

import fatec.probreabastece.com.pobreabastece.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
