
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Localisation{

    public Localisation(){}
        @Id
        @SequenceGenerator(
            name = "localisation_sequence",
            sequenceName = "localisation_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "localisation_sequence"
        )
          Long idlocalisation;
          String nomlocalisation;
              public void setIdlocalisation( Long idlocalisation){
                  this.idlocalisation=idlocalisation;
              }
          
              public Long getIdlocalisation(){
                  return this.idlocalisation;
              }
              public void setNomlocalisation( String nomlocalisation){
                  this.nomlocalisation=nomlocalisation;
              }
          
              public String getNomlocalisation(){
                  return this.nomlocalisation;
              }
}
