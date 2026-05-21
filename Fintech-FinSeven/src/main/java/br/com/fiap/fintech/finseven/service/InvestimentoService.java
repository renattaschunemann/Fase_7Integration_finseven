package br.com.fiap.fintech.finseven.service;

import br.com.fiap.fintech.finseven.model.Banco;
import br.com.fiap.fintech.finseven.model.Investimento;
import br.com.fiap.fintech.finseven.model.Login;
import br.com.fiap.fintech.finseven.model.Usuario;
import br.com.fiap.fintech.finseven.repository.BancoRepository;
import br.com.fiap.fintech.finseven.repository.InvestimentoRepository;
import br.com.fiap.fintech.finseven.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private LoginRepository loginRepository;


    @Transactional
    public Investimento insert(Investimento investimento) {
        Banco bancoReal = bancoRepository.findById(investimento.getBanco().getIdBanco())
                .orElseThrow(() -> new RuntimeException("Banco não encontrado"));

        List<Login> todosLogins = loginRepository.findAll();
        Usuario usuarioReal = null;

        Long idBuscado = investimento.getUsuario().getId();

        for (Login login : todosLogins) {
            if (login.getUsuario() != null && login.getUsuario().getId().equals(idBuscado)) {
                usuarioReal = login.getUsuario();
                break;
            }
        }

        if (usuarioReal == null) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + idBuscado);
        }

        investimento.setBanco(bancoReal);
        investimento.setUsuario(usuarioReal);

        return investimentoRepository.save(investimento);
    }

    public List<Investimento> getAll() {
        return investimentoRepository.findAll();
    }

    public Optional<Investimento> searchById(Long id) {
        return investimentoRepository.findById(id);
    }

    @Transactional
    public Investimento update(Long id, Investimento atualizado) {
        Investimento existente = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com ID: " + id));

        existente.setProduto(atualizado.getProduto());
        existente.setValorAplicado(atualizado.getValorAplicado());
        existente.setTaxaRendimento(atualizado.getTaxaRendimento());
        existente.setDataAplicacao(atualizado.getDataAplicacao());

        return investimentoRepository.save(existente);
    }

    @Transactional
    public void delete(Long id) {
        if (!investimentoRepository.existsById(id)) {
            throw new RuntimeException("Investimento não encontrado com ID: " + id);
        }
        investimentoRepository.deleteById(id);
    }

    public BancoRepository getBancoRepository() {
        return bancoRepository;
    }

    public void setBancoRepository(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}