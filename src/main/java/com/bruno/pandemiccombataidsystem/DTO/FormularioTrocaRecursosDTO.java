package com.bruno.pandemiccombataidsystem.DTO;


public class FormularioTrocaRecursosDTO {
    private long cnpj;
    private Integer quantidadeMedicos;
    private Integer quantidadeRespiradores;
    private Integer quantidadeTomografos;
    private Integer quantidadeAmbulancias;
    private Integer quantidadeEnfermeiros;

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
