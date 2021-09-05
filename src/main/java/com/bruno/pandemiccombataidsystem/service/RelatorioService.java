package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.model.Hospital;

import java.util.List;
import java.util.Map;

public interface RelatorioService {

    public float calculaPorcentagemSuperLotados(Map<Long, Integer> hospitals);

    public float calculaPorcentagemNaoSuperLotados(Map<Long, Integer> hospitals);

    public Hospital getHospitalMaisTempoSuperLotado();

    public Hospital getHospitalMaisTempoNaoSuperLotado();

    public List<Hospital> getHistoricoNegociacao(long cnpj);
}
