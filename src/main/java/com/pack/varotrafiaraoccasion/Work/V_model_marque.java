
package com.pack.varotrafiaraoccasion.Work;


public class V_model_marque{

    public V_model_marque(){}
   

          Long idmodel;
          Long idmarque;
          String nommarque;
          String nommodel;
    
              public void setIdmodel( Long idmodel){
                  this.idmodel=idmodel;
              }
              public Long getIdmodel(){
                  return this.idmodel;
              }
              public void setIdmarque( Long idmarque){
                  this.idmarque=idmarque;
              }
              public Long getIdmarque(){
                  return this.idmarque;
              }
              public void setNommarque( String nommarque){
                  this.nommarque=nommarque;
              }
              public String getNommarque(){
                  return this.nommarque;
              }
              public void setNommodel( String nommodel){
                  this.nommodel=nommodel;
              }
              public String getNommodel(){
                  return this.nommodel;
              }
}
