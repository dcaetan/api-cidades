package com.github.douglasctolima.apicidades.estados;

import com.github.douglasctolima.apicidades.paises.Pais;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Estado")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Estado {
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column
    private String uf;

    @Column
    private Integer ibge;

    /*
    //Opção 1 - referencia apenas um id (neste caso, id = 1, referente ao brasil).
    @Column(name = "pais")
    private Integer paisId;
    */

    //Opção 2 - referencia a entity pais.
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Pais pais;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    //Opção 2 - referencia a entity pais.
    public Pais getPais() {
        return pais;
    }

  /*
  //Opção 1 - referencia apenas um id (neste caso, id = 1, referente ao brasil).
  public Integer getPaisId() {
      return paisId;
  }*/
}