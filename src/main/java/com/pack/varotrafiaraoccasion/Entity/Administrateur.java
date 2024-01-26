
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Administrateur{

    public Administrateur(){}
        @Id
        @SequenceGenerator(
            name = "administrateur_sequence",
            sequenceName = "administrateur_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "administrateur_sequence"
        )
          Long idadministrateur;
          String nom;
          String prenom;
          java.util.Date datenaissance;
          String email;
          String motdepasse;
          Long idfgenre;
          String tel;
          Long idflocalisation;
              public void setIdadministrateur( Long idadministrateur){
                  this.idadministrateur=idadministrateur;
              }
          
              public Long getIdadministrateur(){
                  return this.idadministrateur;
              }
              public void setNom( String nom){
                  this.nom=nom;
              }
          
              public String getNom(){
                  return this.nom;
              }
              public void setPrenom( String prenom){
                  this.prenom=prenom;
              }
          
              public String getPrenom(){
                  return this.prenom;
              }
              public void setDatenaissance( java.util.Date datenaissance){
                  this.datenaissance=datenaissance;
              }
          
              public java.util.Date getDatenaissance(){
                  return this.datenaissance;
              }
              public void setEmail( String email){
                  this.email=email;
              }
          
              public String getEmail(){
                  return this.email;
              }
              public void setMotdepasse( String motdepasse){
                  this.motdepasse=motdepasse;
              }
          
              public String getMotdepasse(){
                  return this.motdepasse;
              }
              public void setIdfgenre( Long idfgenre){
                  this.idfgenre=idfgenre;
              }
          
              public Long getIdfgenre(){
                  return this.idfgenre;
              }
              public void setTel( String tel){
                  this.tel=tel;
              }
          
              public String getTel(){
                  return this.tel;
              }
              public void setIdflocalisation( Long idflocalisation){
                  this.idflocalisation=idflocalisation;
              }
          
              public Long getIdflocalisation(){
                  return this.idflocalisation;
              }
}
