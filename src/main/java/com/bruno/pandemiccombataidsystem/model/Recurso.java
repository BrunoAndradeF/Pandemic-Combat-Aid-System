package com.bruno.pandemiccombataidsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recurso {

    @Id
    /**
     * cnpj desse hospital
     */
    private long cnpj;
    /**
     * quantidade de medicos de um hospital
     */
    private Integer quantidadeMedicos;
    /**
     * quantidade de respiradores de um hospital
     */
    private Integer quantidadeRespiradores;
    /**
     * quantidade de tomografos de um hospital
     */
    private Integer quantidadeTomografos;
    /**
     * quantidade de ambulancias de um hospital
     */
    private Integer quantidadeAmbulancias;
    /**
     * quantidade de enfermeiros de um hospital
     */
    private Integer quantidadeEnfermeiros;

    public Recurso(long cnpj, Integer quantidadeMedicos, Integer quantidadeRespiradores,
                   Integer quantidadeTomografos, Integer quantidadeAmbulancias,
                   Integer quantidadeEnfermeiros) {
        this.cnpj = cnpj;
        this.quantidadeMedicos=quantidadeMedicos;
        this.quantidadeRespiradores=quantidadeRespiradores;
        this.quantidadeTomografos=quantidadeTomografos;
        this.quantidadeAmbulancias=quantidadeAmbulancias;
        this.quantidadeEnfermeiros=quantidadeEnfermeiros;
    }

    private Recurso() {    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getQuantidadeMedicos() {
        return quantidadeMedicos;
    }

    public void setQuantidadeMedicos(Integer quantidadeMedicos) {
        this.quantidadeMedicos = quantidadeMedicos;
    }

    public Integer getQuantidadeRespiradores() {
        return quantidadeRespiradores;
    }

    public void setQuantidadeRespiradores(Integer quantidadeRespiradores) {
        this.quantidadeRespiradores = quantidadeRespiradores;
    }

    public Integer getQuantidadeTomografos() {
        return quantidadeTomografos;
    }

    public void setQuantidadeTomografos(Integer quantidadeTomografos) {
        this.quantidadeTomografos = quantidadeTomografos;
    }

    public Integer getQuantidadeAmbulancias() {
        return quantidadeAmbulancias;
    }

    public void setQuantidadeAmbulancias(Integer quantidadeAmbulancias) {
        this.quantidadeAmbulancias = quantidadeAmbulancias;
    }

    public Integer getQuantidadeEnfermeiros() {
        return quantidadeEnfermeiros;
    }

    public void setQuantidadeEnfermeiros(Integer quantidadeEnfermeiros) {
        this.quantidadeEnfermeiros = quantidadeEnfermeiros;
    }
}
