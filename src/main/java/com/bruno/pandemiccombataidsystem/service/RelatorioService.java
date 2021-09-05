package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.model.Hospital;

import java.util.List;

public interface RelatorioService {

    public List<Hospital> getHospitaisSuperLotados();

    public List<Hospital> getHospitaisNaoSuperLotados();

    public Integer getMediaRecursos(String recurso);

    public Hospital getHospitalMaisTempoSuperLotado();

    public Hospital getHospitalMaisTempoNaoSuperLotado();

    public List<Hospital> getHistoricoNegociacao(long cnpj);
}
