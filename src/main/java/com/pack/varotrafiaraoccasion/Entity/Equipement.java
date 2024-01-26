
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Equipement{

    public Equipement(){}
        @Id
        @SequenceGenerator(
            name = "equipement_sequence",
            sequenceName = "equipement_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipement_sequence"
        )
          Long idequipement;
          String nomequipement;
              public void setIdequipement( Long idequipement){
                  this.idequipement=idequipement;
              }
          
              public Long getIdequipement(){
                  return this.idequipement;
              }
              public void setNomequipement( String nomequipement){
                  this.nomequipement=nomequipement;
              }
          
              public String getNomequipement(){
                  return this.nomequipement;
              }

            public Equipement(Long idequipement, String nomequipement) {
                this.idequipement = idequipement;
                this.nomequipement = nomequipement;
            }

}
