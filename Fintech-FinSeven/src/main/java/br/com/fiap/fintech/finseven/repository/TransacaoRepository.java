package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}