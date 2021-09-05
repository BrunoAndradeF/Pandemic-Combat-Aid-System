package com.bruno.pandemiccombataidsystem.controller;

import com.bruno.pandemiccombataidsystem.service.HospitalService;
import com.bruno.pandemiccombataidsystem.service.RecursoService;
import com.bruno.pandemiccombataidsystem.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class RelatorioApiController {

    @Autowired
    RelatorioService relatorioService;

    @Autowired
    HospitalService hospitalService;

    @Autowired
    RecursoService recursoService;


    @RequestMapping(value="/relatorio/super-lotados", method = RequestMethod.GET)
    public ResponseEntity<?> porcentagemSuperLotados() {
        return new ResponseEntity<String>("porcentagem de hospitais com mais de 90%: "
                + String.format("%.4f",relatorioService.calculaPorcentagemSuperLotados(hospitalService.listaOcupacoesHospitais())), HttpStatus.OK);
    }

    @RequestMapping(value="/relatorio/nao-super-lotados", method = RequestMethod.GET)
    public ResponseEntity<?> porcentagemNaoSuperLotados() {
        return new ResponseEntity<String>("porcentagem de hospitais com menos de 90%: "
                + String.format("%.4f",relatorioService.calculaPorcentagemNaoSuperLotados(hospitalService.listaOcupacoesHospitais())), HttpStatus.OK);
    }

    @RequestMapping(value="/relatorio/media/{recurso}", method = RequestMethod.GET)
    public ResponseEntity<?> mediaRecurso(@PathVariable("recurso") String recurso){
        return new ResponseEntity<String>(String.format("%.4f", recursoService.mediaRecurso(recurso)), HttpStatus.OK);
    }

}
