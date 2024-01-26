
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Detaillecaequipement{

    public Detaillecaequipement(){}
        @Id
        @SequenceGenerator(
            name = "detaillecaequipement_sequence",
            sequenceName = "detaillecaequipement_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "detaillecaequipement_sequence"
        )
          Long iddetaillecaequipement;
          Long idfcaracteristique;
          Long idfequipement;
              public void setIddetaillecaequipement( Long iddetaillecaequipement){
                  this.iddetaillecaequipement=iddetaillecaequipement;
              }
          
              public Long getIddetaillecaequipement(){
                  return this.iddetaillecaequipement;
              }
              public void setIdfcaracteristique( Long idfcaracteristique){
                  this.idfcaracteristique=idfcaracteristique;
              }
          
              public Long getIdfcaracteristique(){
                  return this.idfcaracteristique;
              }
              public void setIdfequipement( Long idfequipement){
                  this.idfequipement=idfequipement;
              }
          
              public Long getIdfequipement(){
                  return this.idfequipement;
              }

            public Detaillecaequipement(Long iddetaillecaequipement, Long idfcaracteristique, Long idfequipement) {
                this.iddetaillecaequipement = iddetaillecaequipement;
                this.idfcaracteristique = idfcaracteristique;
                this.idfequipement = idfequipement;
            }
              
}
