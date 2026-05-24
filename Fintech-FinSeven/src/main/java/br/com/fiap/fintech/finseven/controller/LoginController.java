package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Login;
import br.com.fiap.fintech.finseven.model.Usuario;
import br.com.fiap.fintech.finseven.service.LoginService; // Linha 4: verifique se o pacote bate com o seu projeto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/email/{email}")
    public ResponseEntity<Login> searchByEmail(@PathVariable String email) {
        try {
            Login login = loginService.searchByEmail(email);
            return ResponseEntity.ok(login);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String senha = credentials.get("senha");
        try {
            Login login = loginService.autenticar(email, senha);
            return ResponseEntity.ok(login);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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