package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Suporte;
import br.com.fiap.fintech.finseven.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SuporteService {

    @Autowired
    private SuporteRepository suporteRepository;

    @Transactional
    public Suporte insert(Suporte suporte) {

        return suporteRepository.save(suporte);
    }

    public List<Suporte> getAll() {

        return suporteRepository.findAll();
    }

    public Suporte searchById(Long id) {
        return suporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado de suporte não encontrado com o ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        if (!suporteRepository.existsById(id)) {
            throw new RuntimeException("Chamado de suporte não encontrado com o ID: " + id);
        }
        suporteRepository.deleteById(id);
    }
}