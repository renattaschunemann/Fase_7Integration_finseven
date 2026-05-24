package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Despesa;
import br.com.fiap.fintech.finseven.model.Receita;
import br.com.fiap.fintech.finseven.model.Investimento;
import br.com.fiap.fintech.finseven.model.Transacao;
import br.com.fiap.fintech.finseven.model.TipoTransacao; // Import direto do seu Enum
import br.com.fiap.fintech.finseven.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/despesas")
    public ResponseEntity<Transacao> insertDespesa(@RequestBody Despesa despesa) {
        despesa.setTipo(TipoTransacao.DESPESA);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.insert(despesa));
    }

    @PostMapping("/receitas")
    public ResponseEntity<Transacao> insertReceita(@RequestBody Receita receita) {
        receita.setTipo(TipoTransacao.RECEITA);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.insert(receita));
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        return ResponseEntity.ok(transacaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> searchById(@PathVariable Long id) {
        try {
            Transacao transacao = transacaoService.searchById(id);
            return ResponseEntity.ok(transacao);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/despesas/{id}")
    public ResponseEntity<Transacao> updateDespesa(@PathVariable Long id, @RequestBody Despesa despesa) {
        try {
            Transacao despesaAtualizada = transacaoService.updateDespesa(id, despesa);
            return ResponseEntity.ok(despesaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/receitas/{id}")
    public ResponseEntity<Transacao> updateReceita(@PathVariable Long id, @RequestBody Receita receita) {
        try {
            Transacao receitaAtualizada = transacaoService.updateReceita(id, receita);
            return ResponseEntity.ok(receitaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            transacaoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}