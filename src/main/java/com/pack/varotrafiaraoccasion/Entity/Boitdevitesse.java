
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Boitdevitesse{

    public Boitdevitesse(){}
        @Id
        @SequenceGenerator(
            name = "boitdevitesse_sequence",
            sequenceName = "boitdevitesse_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "boitdevitesse_sequence"
        )
          Long idboitedevitesse;
          String nomboitdereception;
              public void setIdboitedevitesse( Long idboitedevitesse){
                  this.idboitedevitesse=idboitedevitesse;
              }
          
              public Long getIdboitedevitesse(){
                  return this.idboitedevitesse;
              }
              public void setNomboitdereception( String nomboitdereception){
                  this.nomboitdereception=nomboitdereception;
              }
          
              public String getNomboitdereception(){
                  return this.nomboitdereception;
              }
}
