package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Override
    /**
     * calcula e retorna a porcentagem correspondente ao numero de hospitais super lotados(mais de 90% de ocupacao)
     * @param hospitais colecao de relacoes entre cnpj do hospital cadastrado e seu percentual de ocupacap
     * @return float equivalente a porcentagem de hospitais super-lotados
     */
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
    /**
     * calcula e retorna a porcentagem correspondente ao numero de hospitais não super lotados(menos de 90% de ocupacao)
     * @param hospitais colecao de relacoes entre cnpj do hospital cadastrado e seu percentual de ocupacap
     * @return float equivalente a porcentagem de hospitais que nao estao super-lotados
     */
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
    /**
     * NAO IMPLEMENTADO
     */
    public Hospital getHospitalMaisTempoSuperLotado() {
        return null;
    }

    @Override
    /**
     * NAO IMPLEMENTADO
     */
    public Hospital getHospitalMaisTempoNaoSuperLotado() {
        return null;
    }

    @Override
    /**
     * NAO IMPLEMENTADO
     */
    public List<Hospital> getHistoricoNegociacao(long cnpj) {
        return null;
    }
}
