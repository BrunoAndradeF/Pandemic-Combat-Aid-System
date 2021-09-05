package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Override
    public float calculaPorcentagemSuperLotados(Map<Long, Integer> hospitais) {
        float quantidadeSuperLotados = 0;
        for (Long cnpj : hospitais.keySet()) {
            if(hospitais.get(cnpj)>90) {
                quantidadeSuperLotados+=1;
            }
        }
        if(quantidadeSuperLotados>0) return (quantidadeSuperLotados/hospitais.keySet().size())*100;
        else return 0;
    }

    @Override
    public float calculaPorcentagemNaoSuperLotados(Map<Long, Integer> hospitais) {
        float quantidadeNaoSuperLotados = 0;
        for (Long cnpj : hospitais.keySet()) {
            if(hospitais.get(cnpj)<90) {
                quantidadeNaoSuperLotados+=1;
            }
        }
        if(quantidadeNaoSuperLotados>0)return (quantidadeNaoSuperLotados/hospitais.keySet().size())*100;
        else return 0;
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
