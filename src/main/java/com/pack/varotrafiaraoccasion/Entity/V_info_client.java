
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class V_info_client{

    public V_info_client(){}
        @Id
        @SequenceGenerator(
            name = "v_info_client_sequence",
            sequenceName = "v_info_client_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_info_client_sequence"
        )

        Long idclient;
          String nomclient;
          String prenomclient;
          java.util.Date datenaissance;
          String email;
          String nomgenre;
          String tel;
          String nomlocalisation;
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
              public void setNomgenre( String nomgenre){
                  this.nomgenre=nomgenre;
              }
          
              public String getNomgenre(){
                  return this.nomgenre;
              }
              public void setTel( String tel){
                  this.tel=tel;
              }
          
              public String getTel(){
                  return this.tel;
              }
              public void setNomlocalisation( String nomlocalisation){
                  this.nomlocalisation=nomlocalisation;
              }
          
              public String getNomlocalisation(){
                  return this.nomlocalisation;
              }

            public Long getIdclient() {
                return idclient;
            }

            public void setIdclient(Long idclient) {
                this.idclient = idclient;
            }
              
}
