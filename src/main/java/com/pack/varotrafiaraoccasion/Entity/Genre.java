
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Genre{

    public Genre(){}
        @Id
        @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
        )
          Long idgenre;
          String nomgenre;
              public void setIdgenre( Long idgenre){
                  this.idgenre=idgenre;
              }
          
              public Long getIdgenre(){
                  return this.idgenre;
              }
              public void setNomgenre( String nomgenre){
                  this.nomgenre=nomgenre;
              }
          
              public String getNomgenre(){
                  return this.nomgenre;
              }
}
