
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Marque{

    public Marque(){}
        @Id
        @SequenceGenerator(
            name = "marque_sequence",
            sequenceName = "marque_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "marque_sequence"
        )
          Long idmarque;
          String nommarque;
              public void setIdmarque( Long idmarque){
                  this.idmarque=idmarque;
              }
          
              public Long getIdmarque(){
                  return this.idmarque;
              }
              public void setNommarque( String nommarque){
                  this.nommarque=nommarque;
              }
          
              public String getNommarque(){
                  return this.nommarque;
              }
}
