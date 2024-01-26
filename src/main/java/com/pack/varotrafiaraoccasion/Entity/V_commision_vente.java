
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class V_commision_vente{

    public V_commision_vente(){}
        @Id
        @SequenceGenerator(
            name = "v_commision_vente_sequence",
            sequenceName = "v_commision_vente_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_commision_vente_sequence"
        )
          Double sum;
          Double annee;
          Double mois;
              public void setSum( Double sum){
                  this.sum=sum;
              }
          
              public Double getSum(){
                  return this.sum;
              }
              public void setAnnee( Double annee){
                  this.annee=annee;
              }
          
              public Double getAnnee(){
                  return this.annee;
              }
              public void setMois( Double mois){
                  this.mois=mois;
              }
          
              public Double getMois(){
                  return this.mois;
              }
}
