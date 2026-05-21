package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}