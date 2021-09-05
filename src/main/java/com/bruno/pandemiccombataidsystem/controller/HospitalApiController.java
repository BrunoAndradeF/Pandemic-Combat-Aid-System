package com.bruno.pandemiccombataidsystem.controller;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Hospital;
import com.bruno.pandemiccombataidsystem.model.Recurso;
import com.bruno.pandemiccombataidsystem.model.Transacao;
import com.bruno.pandemiccombataidsystem.service.HospitalService;
import com.bruno.pandemiccombataidsystem.service.RecursoService;
import com.bruno.pandemiccombataidsystem.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class HospitalApiController {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    RecursoService recursoService;

    @Autowired
    TransacaoService transacaoService;

    @RequestMapping(value="/hospital", method = RequestMethod.POST)
    public ResponseEntity<?> cadastraHospital(@RequestBody HospitalDTO hospitalDTO){

        Optional<Hospital> hospitalOp = hospitalService.getHospitalByCNPJ(hospitalDTO.getCnpj());

        if(hospitalOp.isEmpty()) {
            Hospital hospital = hospitalService.criaHospital(hospitalDTO);
            hospitalService.salvaRegistroHospital(hospital);

            Recurso recurso = recursoService.criaRecurso(hospitalDTO);
            recursoService.salvaRegistroRecurso(recurso);

            return new ResponseEntity<Hospital>(hospital, HttpStatus.CREATED);
        }
        return null;//error já existe hospital
    }

    @RequestMapping(value = "/hospital/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaPercentualOcupacao(@PathVariable("id") long cnpj, @RequestBody Integer percentualOcupacaoNovo) {
        Optional<Hospital> hospitalOp = hospitalService.getHospitalByCNPJ(cnpj);

        if(!hospitalOp.isEmpty()){
            Hospital hospital = hospitalOp.get();

            hospitalService.atualizaPercentual(hospital,percentualOcupacaoNovo);
            hospitalService.salvaRegistroHospital(hospital);

            return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
        }
        return null;// error. nao existe hospital
    }

    @RequestMapping(value = "hospital/lista", method = RequestMethod.GET)
    public ResponseEntity<?> listaHospitais() {
        return new ResponseEntity<List<Hospital>>(hospitalService.listaHospitais(), HttpStatus.OK);
    }

    @RequestMapping(value = "hospital/troca", method = RequestMethod.PUT)
    public ResponseEntity<?> trocaRecursos(@RequestBody FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2){

        Optional<Hospital> hospitalOp1 = hospitalService.getHospitalByCNPJ(formularioTrocaRecursosDTO1.getCnpj());
        if(hospitalOp1.isEmpty()) return null; //hospital 1 nao cadastrado

        Optional<Hospital> hospitalOp2 = hospitalService.getHospitalByCNPJ(formularioTrocaRecursosDTO2.getCnpj());
        if(hospitalOp2.isEmpty()) return null; //hospital 2 nao cadastrado

        if(recursoService.trocaRecursos(formularioTrocaRecursosDTO1, hospitalOp1.get().getPercentualOcupacao(),
                formularioTrocaRecursosDTO2, hospitalOp2.get().getPercentualOcupacao())){
            Transacao transacao = transacaoService.criaTransacao(formularioTrocaRecursosDTO1, formularioTrocaRecursosDTO2);
            transacaoService.salvaTransacao(transacao);

            return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
        }
        return null;

    }

}
