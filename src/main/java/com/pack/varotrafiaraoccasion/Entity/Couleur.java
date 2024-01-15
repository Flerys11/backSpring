
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Couleur{

    public Couleur(){}
        @Id
        @SequenceGenerator(
            name = "couleur_sequence",
            sequenceName = "couleur_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "couleur_sequence"
        )
          Long idcouleur;
          String nomcouleur;
              public void setIdcouleur( Long idcouleur){
                  this.idcouleur=idcouleur;
              }
          
              public Long getIdcouleur(){
                  return this.idcouleur;
              }
              public void setNomcouleur( String nomcouleur){
                  this.nomcouleur=nomcouleur;
              }
          
              public String getNomcouleur(){
                  return this.nomcouleur;
              }
}
