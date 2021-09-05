package com.bruno.pandemiccombataidsystem.model;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * identificador da transacao, numero gerado
     */
    private long id;
    /**
     * cnjp de um dos dois hospitais da relacao de troca
     */
    private long cnpjHospital1;
    /**
     * cnjp de um dos dois hospitais da relacao de troca
     */
    private long cnpjHospital2;

    //recursos oferecidos pelo hospital 1
    /**
     * quantidade de medicos oferecidos pelo hospital 1
     */
    private Integer quantidadeMedicos1;
    /**
     * quantidade de enfermeiros oferecidos pelo hospital 1
     */
    private Integer quantidaEnfermeiros1;
    /**
     * quantidade de respiradores oferecidos pelo hospital 1
     */
    private Integer quantidadeRespiradores1;
    /**
     * quantidade de tomografos oferecidos pelo hospital 1
     */
    private Integer quantidadeTomografos1;
    /**
     * quantidade de ambulancias oferecidos pelo hospital 1
     */
    private Integer quantidadeAmbulancias1;

    //recursos oferecidos pelo hospital 2

    /**
     * quantidade de medicos oferecidos pelo hospital 2
     */
    private Integer quantidadeMedicos2;
    /**
     * quantidade de enfermeiros oferecidos pelo hospital 2
     */
    private Integer quantidaEnfermeiros2;
    /**
     * quantidade de respiradores oferecidos pelo hospital 2
     */
    private Integer quantidadeRespiradores2;
    /**
     * quantidade de tomografos oferecidos pelo hospital 2
     */
    private Integer quantidadeTomografos2;
    /**
     * quantidade de ambulancias oferecidos pelo hospital 2
     */
    private Integer quantidadeAmbulancias2;


    public Transacao(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2) {
        this.cnpjHospital1=formularioTrocaRecursosDTO1.getCnpj();

        this.quantidadeMedicos1=formularioTrocaRecursosDTO1.getQuantidadeMedicos();
        this.quantidaEnfermeiros1=formularioTrocaRecursosDTO1.getQuantidadeEnfermeiros();
        this.quantidadeRespiradores1=formularioTrocaRecursosDTO1.getQuantidadeRespiradores();
        this.quantidadeTomografos1=formularioTrocaRecursosDTO1.getQuantidadeTomografos();
        this.quantidadeAmbulancias1=formularioTrocaRecursosDTO1.getQuantidadeAmbulancias();


        this.cnpjHospital2=formularioTrocaRecursosDTO2.getCnpj();

        this.quantidadeMedicos2=formularioTrocaRecursosDTO2.getQuantidadeMedicos();
        this.quantidaEnfermeiros2=formularioTrocaRecursosDTO2.getQuantidadeEnfermeiros();
        this.quantidadeRespiradores2=formularioTrocaRecursosDTO2.getQuantidadeRespiradores();
        this.quantidadeTomografos2=formularioTrocaRecursosDTO2.getQuantidadeTomografos();
        this.quantidadeAmbulancias2=formularioTrocaRecursosDTO2.getQuantidadeAmbulancias();
    }

    public Transacao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCnpjHospital1() {
        return cnpjHospital1;
    }

    public void setCnpjHospital1(long cnpjHospital1) {
        this.cnpjHospital1 = cnpjHospital1;
    }

    public long getCnpjHospital2() {
        return cnpjHospital2;
    }

    public void setCnpjHospital2(long cnpjHospital2) {
        this.cnpjHospital2 = cnpjHospital2;
    }

    public Integer getQuantidadeMedicos1() {
        return quantidadeMedicos1;
    }

    public void setQuantidadeMedicos1(Integer quantidadeMedicos1) {
        this.quantidadeMedicos1 = quantidadeMedicos1;
    }

    public Integer getQuantidaEnfermeiros1() {
        return quantidaEnfermeiros1;
    }

    public void setQuantidaEnfermeiros1(Integer quantidaEnfermeiros) {
        this.quantidaEnfermeiros1 = quantidaEnfermeiros;
    }

    public Integer getQuantidadeRespiradores1() {
        return quantidadeRespiradores1;
    }

    public void setQuantidadeRespiradores1(Integer quantidadeRespiradores1) {
        this.quantidadeRespiradores1 = quantidadeRespiradores1;
    }

    public Integer getQuantidadeTomografos1() {
        return quantidadeTomografos1;
    }

    public void setQuantidadeTomografos1(Integer quantidadeTomografos1) {
        this.quantidadeTomografos1 = quantidadeTomografos1;
    }

    public Integer getQuantidadeAmbulancias1() {
        return quantidadeAmbulancias1;
    }

    public void setQuantidadeAmbulancias1(Integer quantidadeAmbulancias1) {
        this.quantidadeAmbulancias1 = quantidadeAmbulancias1;
    }

    public Integer getQuantidadeMedicos2() {
        return quantidadeMedicos2;
    }

    public void setQuantidadeMedicos2(Integer quantidadeMedicos2) {
        this.quantidadeMedicos2 = quantidadeMedicos2;
    }

    public Integer getQuantidaEnfermeiros2() {
        return quantidaEnfermeiros2;
    }

    public void setQuantidaEnfermeiros2(Integer quantidaEnfermeiros2) {
        this.quantidaEnfermeiros2 = quantidaEnfermeiros2;
    }

    public Integer getQuantidadeRespiradores2() {
        return quantidadeRespiradores2;
    }

    public void setQuantidadeRespiradores2(Integer quantidadeRespiradores2) {
        this.quantidadeRespiradores2 = quantidadeRespiradores2;
    }

    public Integer getQuantidadeTomografos2() {
        return quantidadeTomografos2;
    }

    public void setQuantidadeTomografos2(Integer quantidadeTomografos2) {
        this.quantidadeTomografos2 = quantidadeTomografos2;
    }

    public Integer getQuantidadeAmbulancias2() {
        return quantidadeAmbulancias2;
    }

    public void setQuantidadeAmbulancias2(Integer quantidadeAmbulancias2) {
        this.quantidadeAmbulancias2 = quantidadeAmbulancias2;
    }
}
