
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Etat{

    public Etat(){}
        @Id
        @SequenceGenerator(
            name = "etat_sequence",
            sequenceName = "etat_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "etat_sequence"
        )
          Long idetat;
          String nometat;
              public void setIdetat( Long idetat){
                  this.idetat=idetat;
              }
          
              public Long getIdetat(){
                  return this.idetat;
              }
              public void setNometat( String nometat){
                  this.nometat=nometat;
              }
          
              public String getNometat(){
                  return this.nometat;
              }
}
