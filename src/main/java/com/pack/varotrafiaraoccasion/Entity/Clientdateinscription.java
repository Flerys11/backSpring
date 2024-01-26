
package com.pack.varotrafiaraoccasion.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Clientdateinscription{

    public Clientdateinscription(){}
        @Id
        @SequenceGenerator(
            name = "clientdateinscription_sequence",
            sequenceName = "clientdateinscription_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clientdateinscription_sequence"
        )
          Long idclientdateinscription;
          Long idclient;
          java.util.Date date;
              public void setIdclientdateinscription( Long idclientdateinscription){
                  this.idclientdateinscription=idclientdateinscription;
              }
          
              public Long getIdclientdateinscription(){
                  return this.idclientdateinscription;
              }
              public void setIdclient( Long idclient){
                  this.idclient=idclient;
              }
          
              public Long getIdclient(){
                  return this.idclient;
              }
              public void setDate( java.util.Date date){
                  this.date=date;
              }
          
              public java.util.Date getDate(){
                  return this.date;
              }

            public Clientdateinscription(Long idclientdateinscription, Long idclient, Date date) {
                this.idclientdateinscription = idclientdateinscription;
                this.idclient = idclient;
                this.date = date;
            }
              
}
