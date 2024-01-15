
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Energie{

    public Energie(){}
        @Id
        @SequenceGenerator(
            name = "energie_sequence",
            sequenceName = "energie_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "energie_sequence"
        )
          Long idenergie;
          String nomenergie;
              public void setIdenergie( Long idenergie){
                  this.idenergie=idenergie;
              }
          
              public Long getIdenergie(){
                  return this.idenergie;
              }
              public void setNomenergie( String nomenergie){
                  this.nomenergie=nomenergie;
              }
          
              public String getNomenergie(){
                  return this.nomenergie;
              }
}
