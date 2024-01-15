
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Client{

    public Client(){}
        @Id
        @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
        )
          Long idclient;
          String nomclient;
          String prenomclient;
          java.util.Date datenaissance;
          String email;
          String motdepasse;
          Long idfgenre;
          String tel;
          Long idflocalisation;
              public void setIdclient( Long idclient){
                  this.idclient=idclient;
              }
          
              public Long getIdclient(){
                  return this.idclient;
              }
              public void setNomclient( String nomclient){
                  this.nomclient=nomclient;
              }
          
              public String getNomclient(){
                  return this.nomclient;
              }
              public void setPrenomclient( String prenomclient){
                  this.prenomclient=prenomclient;
              }
          
              public String getPrenomclient(){
                  return this.prenomclient;
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
