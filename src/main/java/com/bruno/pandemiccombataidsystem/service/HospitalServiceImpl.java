package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Hospital;
import com.bruno.pandemiccombataidsystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Optional<Hospital> getHospitalByCNPJ(long cnpj) {
        return hospitalRepository.findByCnpj(cnpj);
    }

    @Override
    public void salvaRegistroHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void apagaRegistroHospital(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }

    @Override
    public List<Hospital> listaHospitais() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital criaHospital(HospitalDTO hospitalDTO) {
        return new Hospital(hospitalDTO.getCnpj(), hospitalDTO.getNome(), hospitalDTO.getEndereco(),
                hospitalDTO.getLocalizacao(), hospitalDTO.getPercentualOcupacao());
    }

    @Override
    public Hospital atualizaPercentual(Hospital hospital, Integer percentualOcupacao) {
        if(percentualOcupacao >= 0 && percentualOcupacao<=100){
            hospital.setPercentualOcupacao(percentualOcupacao);
            return  hospital;
        }
        return null;
    }
}
