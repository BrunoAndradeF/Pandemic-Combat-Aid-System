package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.model.Transacao;

import java.util.List;

public interface TransacaoService {

    public Transacao criaTransacao(FormularioTrocaRecursosDTO form1, FormularioTrocaRecursosDTO form2);

    public void salvaTransacao(Transacao transacao);

    public List<Transacao> listaTransacoes();
}
