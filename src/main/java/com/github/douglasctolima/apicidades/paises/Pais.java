package com.github.douglasctolima.apicidades.paises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais") //nome da tabela.
public class Pais {

    @Id
    private Long id; //nome da entity = nome da coluna, não é preciso mapear.

    @Column(name = "nome") //nome da coluna.
    private String nomeEn; //mapeamento da coluna "nome".

    @Column(name = "nome_pt") //nome da coluna.
    private String nomePt; //mapeamento da coluna "nome_pt".

    @Column
    private String sigla; //nome da entity = nome da coluna, não é preciso mapear.

    @Column
    private Integer bacen; //nome da entity = nome da coluna, não é preciso mapear.

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeEn() {
        return nomeEn;
    }

    public String getNomePt() {
        return nomePt;
    }

    public String getSigla() {
        return sigla;
    }

    public Integer getBacen() {
        return bacen;
    }
}
