
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Validation{

    public Validation(){}
        @Id
        @SequenceGenerator(
            name = "validation_sequence",
            sequenceName = "validation_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "validation_sequence"
        )
          Long idvalidation;
          java.util.Date datevalidation;
          Long idcaracteristique;
          Long idadministrateur;
          Double commissionvalidation;
              public void setIdvalidation( Long idvalidation){
                  this.idvalidation=idvalidation;
              }
          
              public Long getIdvalidation(){
                  return this.idvalidation;
              }
              public void setDatevalidation( java.util.Date datevalidation){
                  this.datevalidation=datevalidation;
              }
          
              public java.util.Date getDatevalidation(){
                  return this.datevalidation;
              }
              public void setIdcaracteristique( Long idcaracteristique){
                  this.idcaracteristique=idcaracteristique;
              }
          
              public Long getIdcaracteristique(){
                  return this.idcaracteristique;
              }
              public void setIdadministrateur( Long idadministrateur){
                  this.idadministrateur=idadministrateur;
              }
          
              public Long getIdadministrateur(){
                  return this.idadministrateur;
              }
              public void setCommissionvalidation( Double commissionvalidation){
                  this.commissionvalidation=commissionvalidation;
              }
          
              public Double getCommissionvalidation(){
                  return this.commissionvalidation;
              }
}
