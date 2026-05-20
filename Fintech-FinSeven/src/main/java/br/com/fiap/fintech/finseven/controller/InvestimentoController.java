package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Investimento;
import br.com.fiap.fintech.finseven.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping
    public ResponseEntity<Investimento> insert(@RequestBody Investimento investimento) {
        Investimento novo = investimentoService.insert(investimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<Investimento>> getAll() {
        return ResponseEntity.ok(investimentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investimento> searchById(@PathVariable Long id) {
        return investimentoService.searchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investimento> update(@PathVariable Long id, @RequestBody Investimento investimento) {
        try {
            return ResponseEntity.ok(investimentoService.update(id, investimento));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            investimentoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}