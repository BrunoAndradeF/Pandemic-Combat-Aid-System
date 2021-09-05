package com.bruno.pandemiccombataidsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {

    @Id
    private long cnpj;

    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    private String localizacao;

    @NotNull
    private Integer percentualOcupacao;

    public Hospital(long cnpj, String nome, String endereco, String localizacao,Integer percentualOcupacao) {
        this.cnpj=cnpj;
        this.nome=nome;
        this.endereco=endereco;
        this.localizacao=localizacao;
        this.percentualOcupacao=percentualOcupacao;
    }

    private Hospital() {    }

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

}
