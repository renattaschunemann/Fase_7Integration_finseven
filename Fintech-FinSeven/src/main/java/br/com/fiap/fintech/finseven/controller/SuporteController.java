package br.com.fiap.fintech.finseven.controller;

import br.com.fiap.fintech.finseven.model.Suporte;
import br.com.fiap.fintech.finseven.service.SuporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suporte")
public class SuporteController {

    @Autowired
    private SuporteService suporteService;

    @PostMapping
    public ResponseEntity<Suporte> insert(@RequestBody Suporte suporte) { //Abrir Chamado de Suporte.
        Suporte novoChamado = suporteService.insert(suporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }

    @GetMapping
    public ResponseEntity<List<Suporte>> getAll() {
        return ResponseEntity.ok(suporteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suporte> searchById(@PathVariable Long id) {
        try {
            Suporte suporte = suporteService.searchById(id);
            return ResponseEntity.ok(suporte);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            suporteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}