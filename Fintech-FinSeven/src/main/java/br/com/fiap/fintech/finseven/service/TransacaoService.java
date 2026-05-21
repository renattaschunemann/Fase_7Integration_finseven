package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Despesa;
import br.com.fiap.fintech.finseven.model.Receita;
import br.com.fiap.fintech.finseven.model.Transacao;
import br.com.fiap.fintech.finseven.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public Transacao insert(Transacao transacao) {

        return transacaoRepository.save(transacao);
    }

    public List<Transacao> getAll() {

        return transacaoRepository.findAll();
    }

    public Transacao searchById(Long id) {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada com o ID: " + id));
    }

    @Transactional
    public Transacao updateDespesa(Long id, Despesa despesaAtualizada) {
        Despesa despesaExistente = (Despesa) searchById(id);

        despesaExistente.setValor(despesaAtualizada.getValor());
        despesaExistente.setData(despesaAtualizada.getData());
        despesaExistente.setDescricao(despesaAtualizada.getDescricao());
        despesaExistente.setFormaPagamento(despesaAtualizada.getFormaPagamento());

        return transacaoRepository.save(despesaExistente);
    }

    @Transactional
    public Transacao updateReceita(Long id, Receita receitaAtualizada) {
        Receita receitaExistente = (Receita) searchById(id);

        receitaExistente.setValor(receitaAtualizada.getValor());
        receitaExistente.setData(receitaAtualizada.getData());
        receitaExistente.setDescricao(receitaAtualizada.getDescricao());
        receitaExistente.setOrigem(receitaAtualizada.getOrigem());

        return transacaoRepository.save(receitaExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!transacaoRepository.existsById(id)) {
            throw new RuntimeException("Transação não encontrada com o ID: " + id);
        }
        transacaoRepository.deleteById(id);
    }
}