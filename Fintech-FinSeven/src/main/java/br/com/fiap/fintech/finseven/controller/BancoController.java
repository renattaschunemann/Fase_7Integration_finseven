package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Banco;
import br.com.fiap.fintech.finseven.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @PostMapping
    public ResponseEntity<Banco> insert(@RequestBody Banco banco) {
        Banco novoBanco = bancoService.insert(banco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBanco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banco> update(@PathVariable Long id, @RequestBody Banco banco) {
        try {
            Banco bancoAtualizado = bancoService.update(id, banco);
            return ResponseEntity.ok(bancoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Banco>> getAll() {
        List<Banco> bancos = bancoService.getAll();
        return ResponseEntity.ok(bancos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> searchById(@PathVariable Long id) {
        return bancoService.searchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            bancoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}