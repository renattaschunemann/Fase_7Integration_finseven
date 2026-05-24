package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Login;
import br.com.fiap.fintech.finseven.model.Usuario;
import br.com.fiap.fintech.finseven.service.LoginService; // Linha 4: verifique se o pacote bate com o seu projeto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login login) {
        Login novoLogin = loginService.insert(login); // Corrigido para chamar .salvar()
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLogin);
    }

    @GetMapping
    public ResponseEntity<List<Login>> getAll() {
        List<Login> logins = loginService.getAll(); // Corrigido para chamar .listarTodos()
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> searchById(@PathVariable Long id) {
        try {
            Usuario usuario = loginService.searchUsuarioById(id);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioAtualizado = loginService.updateUsuario(id, usuario);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}