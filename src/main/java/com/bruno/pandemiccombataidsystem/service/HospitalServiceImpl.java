package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Hospital;
import com.bruno.pandemiccombataidsystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    /**
     * retorna o hospital com cnpj correspondente
     */
    public Optional<Hospital> getHospitalByCNPJ(long cnpj) {
        return hospitalRepository.findByCnpj(cnpj);
    }

    @Override
    /**
     * salva o hospital passado como parametro no repositorio
     */
    public void salvaRegistroHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    /**
     * apaga o hospital passado como parametro do repositorio
     */
    public void apagaRegistroHospital(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }

    @Override
    /**
     * lista todos os hospitais cadastrados
     */
    public List<Hospital> listaHospitais() {
        return hospitalRepository.findAll();
    }

    @Override
    /**
     * retorna uma Map<Long, Integer> de todos hospitais cadastrados. Em que a chave é o cnpj de um hospital
     * cadastrado e o valor associado corresponde ao percentual de ocupacao desse hospital.
     */
    public Map<Long, Integer> listaOcupacoesHospitais() {
        Map<Long, Integer> colecaoOcupacoes = new HashMap<>();
        for (Hospital hospital : listaHospitais()) {
            colecaoOcupacoes.put(hospital.getCnpj(), hospital.getPercentualOcupacao());
        }
        return colecaoOcupacoes;
    }

    @Override
    /**
     * cria e retorna uma entidade Hospital
     */
    public Hospital criaHospital(HospitalDTO hospitalDTO) {
        return new Hospital(hospitalDTO.getCnpj(), hospitalDTO.getNome(), hospitalDTO.getEndereco(),
                hospitalDTO.getLocalizacao(), hospitalDTO.getPercentualOcupacao());
    }

    @Override
    /**
     * atualiza o percentual de ocupacao de um dado hospital
     */
    public Hospital atualizaPercentual(Hospital hospital, Integer percentualOcupacao) {
        if(percentualOcupacao >= 0 && percentualOcupacao<=100){
            hospital.setPercentualOcupacao(percentualOcupacao);
            return  hospital;
        }
        return null;
    }
}
