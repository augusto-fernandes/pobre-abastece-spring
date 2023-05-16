package fatec.probreabastece.com.pobreabastece.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.probreabastece.com.pobreabastece.model.Conta;

public interface ContaRespository extends JpaRepository<Conta, Long> {
    
}
