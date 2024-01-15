
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Model{

    public Model(){}
        @Id
        @SequenceGenerator(
            name = "model_sequence",
            sequenceName = "model_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_sequence"
        )
          Long idmodel;
          String nommodel;
          Long idfmarque;
              public void setIdmodel( Long idmodel){
                  this.idmodel=idmodel;
              }
          
              public Long getIdmodel(){
                  return this.idmodel;
              }
              public void setNommodel( String nommodel){
                  this.nommodel=nommodel;
              }
          
              public String getNommodel(){
                  return this.nommodel;
              }
              public void setIdfmarque( Long idfmarque){
                  this.idfmarque=idfmarque;
              }
          
              public Long getIdfmarque(){
                  return this.idfmarque;
              }
}
