
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Caracteristique{

    public Caracteristique(){}
        @Id
        @SequenceGenerator(
            name = "caracteristique_sequence",
            sequenceName = "caracteristique_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "caracteristique_sequence"
        )
          Long idcaracteristique;
          Long idfetat;
          Long idclient;
          Long idfboitedevitesse;
          Long idfmarque;
          Long idfmodel;
          Long idfenergie;
          Long idftypevehicule;
          Long idlocalisation;
          Double autonomie;
          Double kilometrage;
          java.util.Date anneedefabrication;
          java.util.Date annemodel;
          Double capacite;
          Double consomation;
          Double prixdevente;
          Long coleur;
          Integer nbrporte;
          Integer nbrplace;
          Double longueur;
          Double largeur;
          Double hauteur;
          Double volumeducoffre;
          Double commission;
          static java.util.Date anneactuelle = new java.util.Date();
              public void setIdcaracteristique( Long idcaracteristique){
                  this.idcaracteristique=idcaracteristique;
              }
          
              public Long getIdcaracteristique(){
                  return this.idcaracteristique;
              }
              public void setIdfetat( Long idfetat){
                  this.idfetat=idfetat;
              }
          
              public Long getIdfetat(){
                  return this.idfetat;
              }
              public void setIdclient( Long idclient){
                  this.idclient=idclient;
              }
          
              public Long getIdclient(){
                  return this.idclient;
              }
              public void setIdfboitedevitesse( Long idfboitedevitesse){
                  this.idfboitedevitesse=idfboitedevitesse;
              }
          
              public Long getIdfboitedevitesse(){
                  return this.idfboitedevitesse;
              }
              public void setIdfmarque( Long idfmarque){
                  this.idfmarque=idfmarque;
              }
          
              public Long getIdfmarque(){
                  return this.idfmarque;
              }
              public void setIdfmodel( Long idfmodel){
                  this.idfmodel=idfmodel;
              }
          
              public Long getIdfmodel(){
                  return this.idfmodel;
              }
              public void setIdfenergie( Long idfenergie){
                  this.idfenergie=idfenergie;
              }
          
              public Long getIdfenergie(){
                  return this.idfenergie;
              }
              public void setIdftypevehicule( Long idftypevehicule){
                  this.idftypevehicule=idftypevehicule;
              }
          
              public Long getIdftypevehicule(){
                  return this.idftypevehicule;
              }
              public void setIdlocalisation( Long idlocalisation){
                  this.idlocalisation=idlocalisation;
              }
          
              public Long getIdlocalisation(){
                  return this.idlocalisation;
              }
              public void setAutonomie( Double autonomie) throws Exception{
                if(autonomie<0){
                        throw new Exception("valeur de l'autonomie negatif");
                }
                  this.autonomie=autonomie;
              }
          
              public Double getAutonomie(){
                  return this.autonomie;
              }
              public void setKilometrage( Double kilometrage)throws Exception{
                if(kilometrage<0){
                        throw new Exception("valeur de l'autonomie negatif");
                }
                  this.kilometrage=kilometrage;
              }
          
              public Double getKilometrage(){
                  return this.kilometrage;
              }
              public void setAnneedefabrication( java.util.Date anneedefabrication)throws Exception{
                    if(anneedefabrication.getTime()>anneactuelle.getTime()){
                            throw new Exception("date de fabrication non valide");
                    }
                    this.anneedefabrication=anneedefabrication;
              }
          
              public java.util.Date getAnneedefabrication(){
                  return this.anneedefabrication;
              }
              public void setAnnemodel( java.util.Date annemodel)throws Exception{
                if(annemodel.getTime()>anneactuelle.getTime()){
                            throw new Exception("date du model non valide");
                }
                  this.annemodel=annemodel;
              }
          
              public java.util.Date getAnnemodel(){
                  return this.annemodel;
              }
              public void setCapacite( Double capacite)  throws Exception{
                if(capacite<0){
                        throw new Exception("capacitee negatif");
                }
                  this.capacite=capacite;
              }
          
              public Double getCapacite(){
                  return this.capacite;
              }
              public void setConsomation( Double consomation)  throws Exception{
                if(consomation<0){
                        throw new Exception("consomation negatif");
                }
                  this.consomation=consomation;
              }
          
              public Double getConsomation(){
                  return this.consomation;
              }
              public void setPrixdevente( Double prixdevente) throws Exception{
                if(prixdevente<0){
                        throw new Exception("prixdevente negatif");
                }
                  this.prixdevente=prixdevente;
              }
          
              public Double getPrixdevente(){
                  return this.prixdevente;
              }
              public void setColeur( Long coleur){
                  this.coleur=coleur;
              }
          
              public Long getColeur(){
                  return this.coleur;
              }
              public void setNbrporte( Integer nbrporte) throws Exception{
                if(nbrporte<0){
                        throw new Exception("nbrdeporte negatif");
                }
                  this.nbrporte=nbrporte;
              }
          
              public Integer getNbrporte(){
                  return this.nbrporte;
              }
              public void setNbrplace( Integer nbrplace) throws Exception{
                if(nbrplace<0){
                        throw new Exception("nbrplace negatif");
                }
                  this.nbrplace=nbrplace;
              }
          
              public Integer getNbrplace(){
                  return this.nbrplace;
              }
              public void setLongueur( Double longueur) throws Exception{
                if(longueur<0){
                        throw new Exception("longeur negatif");
                }
                  this.longueur=longueur;
              }
          
              public Double getLongueur(){
                  return this.longueur;
              }
              public void setLargeur( Double largeur) throws Exception{
                if(largeur<0){
                        throw new Exception("largeur negatif");
                }
                  this.largeur=largeur;
              }
          
              public Double getLargeur(){
                  return this.largeur;
              }
              public void setHauteur( Double hauteur) throws Exception{
                if(hauteur<0){
                        throw new Exception("hauter");
                }
                  this.hauteur=hauteur;
              }
          
              public Double getHauteur(){
                  return this.hauteur;
              }
              public void setVolumeducoffre( Double volumeducoffre) throws Exception{
                if(volumeducoffre<0){
                        throw new Exception("volumecoffre negatif");
                }
                  this.volumeducoffre=volumeducoffre;
              }
          
              public Double getVolumeducoffre(){
                  return this.volumeducoffre;
              }
              public void setCommission( Double commission) throws Exception{
                if(commission<0){
                        throw new Exception("commission negatif");
                }
                  this.commission=commission;
              }
          
              public Double getCommission(){
                  return this.commission;
              }
}
