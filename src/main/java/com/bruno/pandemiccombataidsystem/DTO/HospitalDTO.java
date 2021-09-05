package com.bruno.pandemiccombataidsystem.DTO;

public class HospitalDTO {
    private long cnpj;
    private String nome;
    private String endereco;
    private String localizacao;
    private Integer percentualOcupacao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getPercentualOcupacao() {
        return percentualOcupacao;
    }

    public void setPercentualOcupacao(Integer percentualOcupacao) {
        this.percentualOcupacao = percentualOcupacao;
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
