package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Login;
import br.com.fiap.fintech.finseven.model.Usuario;
import br.com.fiap.fintech.finseven.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    public Login insert(Login login) {

        return loginRepository.save(login);
    }

    public List<Login> getAll() {

        return loginRepository.findAll();
    }

    public Optional<Login> searchById(Integer id) {

        return loginRepository.findById(id);
    }

    public Usuario searchUsuarioById(Long id) {
        return loginRepository.findAll().stream()
                .map(Login::getUsuario)
                .filter(u -> u != null && u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = searchUsuarioById(id);

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setCpf(usuarioAtualizado.getCpf());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());

        return usuarioExistente;
    }
}