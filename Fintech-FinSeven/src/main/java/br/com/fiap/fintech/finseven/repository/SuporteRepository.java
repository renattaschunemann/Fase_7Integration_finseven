package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Suporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuporteRepository extends JpaRepository<Suporte, Long> {
}