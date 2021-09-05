package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.model.Transacao;
import com.bruno.pandemiccombataidsystem.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService{

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    /**
     * cria e retorna uma entidade Transacao
     * @param form1 formulario de troca de um dos hospitais da relacao
     * @param form1 formulario de troca do outro hospital da relacao
     * @return entidade Transacao criada
     */
    public Transacao criaTransacao(FormularioTrocaRecursosDTO form1, FormularioTrocaRecursosDTO form2) {
        return new Transacao(form1, form2);
    }

    @Override
    /**
     * salva uma transacao no repositorio
     * @param transacao entidade do tipo Transcao a ser salva
     */
    public void salvaTransacao(Transacao transacao) {
        transacaoRepository.save(transacao);
    }

    @Override
    /**
     * lista todas as transacoes salvas
     * @return lista com todas as transacoes salvas
     */
    public List<Transacao> listaTransacoes() {
        return transacaoRepository.findAll();
    }
}
