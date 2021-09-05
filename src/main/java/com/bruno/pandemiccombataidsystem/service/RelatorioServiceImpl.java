package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    //@Autowired


    @Override
    public List<Hospital> getHospitaisSuperLotados() {

        return null;
    }

    @Override
    public List<Hospital> getHospitaisNaoSuperLotados() {
        return null;
    }

    @Override
    public Integer getMediaRecursos(String recurso) {
        return null;
    }

    @Override
    public Hospital getHospitalMaisTempoSuperLotado() {
        return null;
    }

    @Override
    public Hospital getHospitalMaisTempoNaoSuperLotado() {
        return null;
    }

    @Override
    public List<Hospital> getHistoricoNegociacao(long cnpj) {
        return null;
    }
}
