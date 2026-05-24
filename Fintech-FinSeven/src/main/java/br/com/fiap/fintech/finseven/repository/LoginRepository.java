package br.com.fiap.fintech.finseven.repository;

import br.com.fiap.fintech.finseven.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsuarioEmail(String email);
    Optional<Login> findByUsuarioEmailAndSenha(String email, String senha);
}