package fatec.probreabastece.com.pobreabastece.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.probreabastece.com.pobreabastece.model.Avaliacao;

public interface AvaliacaoRespository extends JpaRepository<Avaliacao, Long> {
    
}
