package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Categoria;
import br.com.fiap.fintech.finseven.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria insert(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria update(Long id, Categoria categoriaAtualizada) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));

        categoriaExistente.setDescricao(categoriaAtualizada.getDescricao());
        categoriaExistente.setTiposTransacao(categoriaAtualizada.getTiposTransacao());

        return categoriaRepository.save(categoriaExistente);
    }

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> searchById(Long id) {

        return categoriaRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com o ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

}