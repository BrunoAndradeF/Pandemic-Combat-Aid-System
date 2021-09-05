package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Hospital;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HospitalService {

    public Optional<Hospital> getHospitalByCNPJ(long cnpj);

    public void salvaRegistroHospital(Hospital hospital);

    public void apagaRegistroHospital(Hospital hospital);

    public Hospital criaHospital(HospitalDTO hospitalDTO);

    public Hospital atualizaPercentual(Hospital hospital, Integer percentualOcupacao);

    public List<Hospital> listaHospitais();

    public Map<Long, Integer> listaOcupacoesHospitais();

}
