package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Banco;
import br.com.fiap.fintech.finseven.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    @Transactional
    public Banco insert(Banco banco) {
        return bancoRepository.save(banco);
    }

    @Transactional
    public Banco update(Long id, Banco bancoAtualizado) {
        Banco bancoExistente = bancoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banco não encontrado com o ID: " + id));

        bancoExistente.setNome(bancoAtualizado.getNome());
        bancoExistente.setAgencia(bancoAtualizado.getAgencia());
        bancoExistente.setConta(bancoAtualizado.getConta());
        bancoExistente.setTipo(bancoAtualizado.getTipo());
        bancoExistente.setSaldo(bancoAtualizado.getSaldo());

        return bancoRepository.save(bancoExistente);
    }

    public List<Banco> getAll() {
        return bancoRepository.findAll();
    }

    public Optional<Banco> searchById(Long id) {
        return bancoRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        if (!bancoRepository.existsById(id)) {
            throw new RuntimeException("Banco não encontrado com o ID: " + id);
        }
        bancoRepository.deleteById(id);
    }
}