package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Recurso;
import com.bruno.pandemiccombataidsystem.repository.RecursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

    static final int PONTUACAO_MEDICO=3;
    static final int PONTUACAO_ENFERMEIRO=3;
    static final int PONTUACAO_RESPIRADOR=5;
    static final int PONTUACAO_AMBULANCIA=10;
    static final int PONTUACAO_TOMOGRAFO=12;

    @Autowired
    RecursosRepository recursosRepository;

    @Override
    public Optional<Recurso> getRecursoByCNPJ(long cnpj) {
        return recursosRepository.findByCnpj(cnpj);
    }

    @Override
    public void salvaRegistroRecurso(Recurso recurso) {
        recursosRepository.save(recurso);
    }

    @Override
    public void apagaRegistroRecurso(Recurso recurso) {
        recursosRepository.delete(recurso);
    }

    @Override
    public Recurso criaRecurso(HospitalDTO hospitalDTO) {
        return new Recurso(hospitalDTO.getCnpj(), hospitalDTO.getQuantidadeMedicos(),
                hospitalDTO.getQuantidadeRespiradores(), hospitalDTO.getQuantidadeTomografos(),
                hospitalDTO.getQuantidadeAmbulancias(), hospitalDTO.getQuantidadeEnfermeiros());
    }

    @Override
    public List<Recurso> listaRecursos() {
        return recursosRepository.findAll();
    }

    @Override
    public boolean trocaRecursos(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, Integer percentual1,
                                   FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2, Integer percentual2) {
        int totalPontos1 = getTotalPontosForm(formularioTrocaRecursosDTO1);
        int totalPontos2 = getTotalPontosForm(formularioTrocaRecursosDTO2);

        Boolean trocaRealizada=false;

        if(totalPontos1==totalPontos2) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
        } else if (totalPontos1>totalPontos2){
            if(percentual2 > 90) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
            }
        } else {
            if(percentual1 > 90) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
            }
        }
        return trocaRealizada;
    }

    private int getTotalPontosForm(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO) {
        return formularioTrocaRecursosDTO.getQuantidadeAmbulancias() * PONTUACAO_AMBULANCIA
                + formularioTrocaRecursosDTO.getQuantidadeMedicos() * PONTUACAO_MEDICO
                + formularioTrocaRecursosDTO.getQuantidadeRespiradores() * PONTUACAO_RESPIRADOR
                + formularioTrocaRecursosDTO.getQuantidadeTomografos() * PONTUACAO_TOMOGRAFO
                + formularioTrocaRecursosDTO.getQuantidadeEnfermeiros() * PONTUACAO_ENFERMEIRO;
    }

    private void realizaTroca(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2) {

        atualizaRecursos(formularioTrocaRecursosDTO1 ,formularioTrocaRecursosDTO2);
        atualizaRecursos(formularioTrocaRecursosDTO2, formularioTrocaRecursosDTO1);
    }

    private void atualizaRecursos(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2) {
        Recurso recursos1 = recursosRepository.findByCnpj(formularioTrocaRecursosDTO1.getCnpj()).get();
        Recurso recursos2 = recursosRepository.findByCnpj(formularioTrocaRecursosDTO2.getCnpj()).get();


        recursos1.setQuantidadeMedicos(recursos1.getQuantidadeMedicos() + formularioTrocaRecursosDTO2.getQuantidadeMedicos()
                - formularioTrocaRecursosDTO1.getQuantidadeMedicos());

        recursos1.setQuantidadeEnfermeiros(recursos1.getQuantidadeEnfermeiros() + formularioTrocaRecursosDTO2.getQuantidadeEnfermeiros()
                - formularioTrocaRecursosDTO1.getQuantidadeEnfermeiros());

        recursos1.setQuantidadeAmbulancias(recursos1.getQuantidadeAmbulancias() + formularioTrocaRecursosDTO2.getQuantidadeAmbulancias()
                - formularioTrocaRecursosDTO1.getQuantidadeAmbulancias());

        recursos1.setQuantidadeRespiradores(recursos1.getQuantidadeRespiradores() + formularioTrocaRecursosDTO2.getQuantidadeRespiradores()
                - formularioTrocaRecursosDTO1.getQuantidadeRespiradores());

        recursos1.setQuantidadeTomografos(recursos1.getQuantidadeTomografos() + formularioTrocaRecursosDTO2.getQuantidadeTomografos()
                - formularioTrocaRecursosDTO1.getQuantidadeTomografos());
    }
}
