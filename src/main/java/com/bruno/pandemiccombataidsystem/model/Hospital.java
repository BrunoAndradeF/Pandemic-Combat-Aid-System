package com.bruno.pandemiccombataidsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {

    @Id
    /**
     * chave primaria do hospital, o seu cpf
     */
    private long cnpj;

    @NotNull
    /**
     * nome do hospital
     */
    private String nome;

    @NotNull
    /**
     * endereco do hospital
     */
    private String endereco;

    /**
     * localizacao do hospital
     */
    private String localizacao;

    @NotNull
    /**
     * percentual de ocupacao
     */
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
