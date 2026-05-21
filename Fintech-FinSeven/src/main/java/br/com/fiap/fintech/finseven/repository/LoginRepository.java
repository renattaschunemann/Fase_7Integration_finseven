package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
}