
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Photocaracteristique{

    public Photocaracteristique(){}
        @Id
        @SequenceGenerator(
            name = "photocaracteristique_sequence",
            sequenceName = "photocaracteristique_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photocaracteristique_sequence"
        )
          Long idphotocaracteristique;
          Long idfcaracteristique;
          String nomimage;
              public void setIdphotocaracteristique( Long idphotocaracteristique){
                  this.idphotocaracteristique=idphotocaracteristique;
              }
          
              public Long getIdphotocaracteristique(){
                  return this.idphotocaracteristique;
              }
              public void setIdfcaracteristique( Long idfcaracteristique){
                  this.idfcaracteristique=idfcaracteristique;
              }
          
              public Long getIdfcaracteristique(){
                  return this.idfcaracteristique;
              }
              public void setNomimage( String nomimage){
                  this.nomimage=nomimage;
              }
          
              public String getNomimage(){
                  return this.nomimage;
              }

            public Photocaracteristique(Long idphotocaracteristique, Long idfcaracteristique, String nomimage) {
                this.idphotocaracteristique = idphotocaracteristique;
                this.idfcaracteristique = idfcaracteristique;
                this.nomimage = nomimage;
            }
              
}
