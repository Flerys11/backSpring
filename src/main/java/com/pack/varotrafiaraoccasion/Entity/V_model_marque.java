
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class V_model_marque{

    public V_model_marque(){}
        @Id
        @SequenceGenerator(
            name = "v_model_marque_sequence",
            sequenceName = "v_model_marque_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_model_marque_sequence"
        )
          Long idmodel;
          Long idmarque;
          String nommarque;
          String nommodel;
              public void setIdmodel( Long idmodel){
                  this.idmodel=idmodel;
              }
          
              public Long getIdmodel(){
                  return this.idmodel;
              }
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
              public void setNommodel( String nommodel){
                  this.nommodel=nommodel;
              }
          
              public String getNommodel(){
                  return this.nommodel;
              }
}
