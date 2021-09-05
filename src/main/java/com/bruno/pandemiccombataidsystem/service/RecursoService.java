package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoService {

    public Optional<Recurso> getRecursoByCNPJ(long cnpj);

    public void salvaRegistroRecurso(Recurso recurso);

    public void apagaRegistroRecurso(Recurso recurso);

    public Recurso criaRecurso(HospitalDTO hospitalDTO);

    public List<Recurso> listaRecursos();

    public boolean trocaRecursos(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, Integer percentual1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2, Integer percentual2);

    public Double mediaRecurso(String recurso);
}
