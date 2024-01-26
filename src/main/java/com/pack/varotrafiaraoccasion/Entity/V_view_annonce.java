
package com.pack.varotrafiaraoccasion.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class V_view_annonce{

    public V_view_annonce(){}
        @Id
        @SequenceGenerator(
            name = "v_view_annonce_sequence",
            sequenceName = "v_view_annonce_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_view_annonce_sequence"
        )
          String nommodel;
          String nommarque;
          java.util.Date annemodel;
          Double prixdevente;
          String nomimage;
          Long idclient;
          Long idcaracteristique;
          Long idetat;
          String nometat;
          
        public Long getIdetat() {
            return idetat;
        }

        public void setIdetat(Long idetat) {
            this.idetat = idetat;
        }

        public String getNometat() {
            return nometat;
        }

        public void setNometat(String nometat) {
            this.nometat = nometat;
        }

            public V_view_annonce(String nommodel, String nommarque, Date annemodel, Double prixdevente, String nomimage,
                Long idclient, Long idcaracteristique) {
            this.nommodel = nommodel;
            this.nommarque = nommarque;
            this.annemodel = annemodel;
            this.prixdevente = prixdevente;
            this.nomimage = nomimage;
            this.idclient = idclient;
            this.idcaracteristique = idcaracteristique;
        }

            public Long getIdclient() {
                return idclient;
            }

            public V_view_annonce(String nommodel, String nommarque, Date annemodel, Double prixdevente,
                    String nomimage, Long idclient) {
                this.nommodel = nommodel;
                this.nommarque = nommarque;
                this.annemodel = annemodel;
                this.prixdevente = prixdevente;
                this.nomimage = nomimage;
                this.idclient = idclient;
            }

            public void setIdclient(Long idclient) {
                this.idclient = idclient;
            }
            public void setNommodel( String nommodel){
                  this.nommodel=nommodel;
              }
          
              public String getNommodel(){
                  return this.nommodel;
              }
              public void setNommarque( String nommarque){
                  this.nommarque=nommarque;
              }
          
              public String getNommarque(){
                  return this.nommarque;
              }
              public void setAnnemodel( java.util.Date annemodel){
                  this.annemodel=annemodel;
              }
          
              public java.util.Date getAnnemodel(){
                  return this.annemodel;
              }
              public void setPrixdevente( Double prixdevente){
                  this.prixdevente=prixdevente;
              }
          
              public Double getPrixdevente(){
                  return this.prixdevente;
              }
              public void setNomimage( String nomimage){
                  this.nomimage=nomimage;
              }
          
              public String getNomimage(){
                  return this.nomimage;
              }

            public Long getIdcaracteristique() {
                return idcaracteristique;
            }

            public void setIdcaracteristique(Long idcaracteristique) {
                this.idcaracteristique = idcaracteristique;
            }
}
