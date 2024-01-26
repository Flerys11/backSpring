
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Favorie{

    public Favorie(){}
        @Id
        @SequenceGenerator(
            name = "favorie_sequence",
            sequenceName = "favorie_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "favorie_sequence"
        )
          Long idfavorie;
          Long idfcaracteristique;
          Long idclient;
              public void setIdfavorie( Long idfavorie){
                  this.idfavorie=idfavorie;
              }
          
              public Long getIdfavorie(){
                  return this.idfavorie;
              }
              public void setIdfcaracteristique( Long idfcaracteristique){
                  this.idfcaracteristique=idfcaracteristique;
              }
          
              public Long getIdfcaracteristique(){
                  return this.idfcaracteristique;
              }
              public void setIdclient( Long idclient){
                  this.idclient=idclient;
              }
          
              public Long getIdclient(){
                  return this.idclient;
              }
}
