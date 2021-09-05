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
    public Transacao criaTransacao(FormularioTrocaRecursosDTO form1, FormularioTrocaRecursosDTO form2) {
        return new Transacao(form1, form2);
    }

    @Override
    public void salvaTransacao(Transacao transacao) {
        transacaoRepository.save(transacao);
    }

    @Override
    public List<Transacao> listaTransacoes() {
        return transacaoRepository.findAll();
    }
}
