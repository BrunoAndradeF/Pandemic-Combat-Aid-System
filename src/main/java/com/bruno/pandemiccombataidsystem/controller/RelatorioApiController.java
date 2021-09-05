package com.bruno.pandemiccombataidsystem.controller;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import com.bruno.pandemiccombataidsystem.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RelatorioApiController {

    @Autowired
    RelatorioService relatorioService;


    @RequestMapping(value = "/relatorio", method = RequestMethod.GET)
    public List<Hospital> listaSuperLotados(){
        return relatorioService.getHospitaisSuperLotados();
    }

}
