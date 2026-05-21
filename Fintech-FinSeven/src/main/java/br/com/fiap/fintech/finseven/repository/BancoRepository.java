package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}