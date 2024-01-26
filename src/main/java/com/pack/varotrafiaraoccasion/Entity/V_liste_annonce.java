
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "v_liste_annonce")
public class V_liste_annonce{

    public V_liste_annonce(){}
        @Id
        @SequenceGenerator(
            name = "v_liste_annonce_sequence",
            sequenceName = "v_liste_annonce_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_liste_annonce_sequence"
        )
      
        Double consomation;
        Long idclient;
        Long idphotocaracteristique;
        Long  idcaracteristique;
        Double commission;
        Double volumeducoffre;
        Double hauteur;
        Double largeur;
        Double longueur;
        Integer nbrplace;
        Integer nbrporte;
        Double prixdevente;
        Double capacite;
        java.util.Date annemodel;
        java.util.Date anneedefabrication;
        Double kilometrage;
        Double autonomie;
        String nomlocalisation;
        Long idlocalisation;
        String nometat;
        Long idetat;
        String nomboitdereception;
        Long idboitedevitesse;
        String nommarque;
        Long idmarque;
        String nommodel;
        Long idmodel;
        String nomenergie;
        Long idenergie;
        String nomtypevehicule;
        Long idtypevehicule;
        String nomcouleur;
        Long idcouleur;
        String nomclient;
        String prenomclient;
        String tel;
        String email;
        Long idequipement;
        String nomimage;
        String nomequipement;
        
              public void setCommission( Double commission){
                  this.commission=commission;
              }
          
              public Double getCommission(){
                  return this.commission;
              }
              public void setVolumeducoffre( Double volumeducoffre){
                  this.volumeducoffre=volumeducoffre;
              }
          
              public Double getVolumeducoffre(){
                  return this.volumeducoffre;
              }
              public void setHauteur( Double hauteur){
                  this.hauteur=hauteur;
              }
          
              public Double getHauteur(){
                  return this.hauteur;
              }
              public void setLargeur( Double largeur){
                  this.largeur=largeur;
              }
          
              public Double getLargeur(){
                  return this.largeur;
              }
              public void setLongueur( Double longueur){
                  this.longueur=longueur;
              }
          
              public Double getLongueur(){
                  return this.longueur;
              }
              public void setNbrplace( Integer nbrplace){
                  this.nbrplace=nbrplace;
              }
          
              public Integer getNbrplace(){
                  return this.nbrplace;
              }
              public void setNbrporte( Integer nbrporte){
                  this.nbrporte=nbrporte;
              }
          
              public Integer getNbrporte(){
                  return this.nbrporte;
              }
              public void setPrixdevente( Double prixdevente){
                  this.prixdevente=prixdevente;
              }
          
              public Double getPrixdevente(){
                  return this.prixdevente;
              }
              public void setCapacite( Double capacite){
                  this.capacite=capacite;
              }
          
              public Double getCapacite(){
                  return this.capacite;
              }
              public void setAnnemodel( java.util.Date annemodel){
                  this.annemodel=annemodel;
              }
          
              public java.util.Date getAnnemodel(){
                  return this.annemodel;
              }
              public void setAnneedefabrication( java.util.Date anneedefabrication){
                  this.anneedefabrication=anneedefabrication;
              }
          
              public java.util.Date getAnneedefabrication(){
                  return this.anneedefabrication;
              }
              public void setKilometrage( Double kilometrage){
                  this.kilometrage=kilometrage;
              }
          
              public Double getKilometrage(){
                  return this.kilometrage;
              }
              public void setAutonomie( Double autonomie){
                  this.autonomie=autonomie;
              }
          
              public Double getAutonomie(){
                  return this.autonomie;
              }
              public void setNomlocalisation( String nomlocalisation){
                  this.nomlocalisation=nomlocalisation;
              }
          
              public String getNomlocalisation(){
                  return this.nomlocalisation;
              }
              public void setIdlocalisation( Long idlocalisation){
                  this.idlocalisation=idlocalisation;
              }
          
              public Long getIdlocalisation(){
                  return this.idlocalisation;
              }
              public void setNometat( String nometat){
                  this.nometat=nometat;
              }
          
              public String getNometat(){
                  return this.nometat;
              }
              public void setIdetat( Long idetat){
                  this.idetat=idetat;
              }
          
              public Long getIdetat(){
                  return this.idetat;
              }
              public void setNomboitdereception( String nomboitdereception){
                  this.nomboitdereception=nomboitdereception;
              }
          
              public String getNomboitdereception(){
                  return this.nomboitdereception;
              }
              public void setIdboitedevitesse( Long idboitedevitesse){
                  this.idboitedevitesse=idboitedevitesse;
              }
          
              public Long getIdboitedevitesse(){
                  return this.idboitedevitesse;
              }
              public void setNommarque( String nommarque){
                  this.nommarque=nommarque;
              }
          
              public String getNommarque(){
                  return this.nommarque;
              }
              public void setIdmarque( Long idmarque){
                  this.idmarque=idmarque;
              }
          
              public Long getIdmarque(){
                  return this.idmarque;
              }
              public void setNommodel( String nommodel){
                  this.nommodel=nommodel;
              }
          
              public String getNommodel(){
                  return this.nommodel;
              }
              public void setIdmodel( Long idmodel){
                  this.idmodel=idmodel;
              }
          
              public Long getIdmodel(){
                  return this.idmodel;
              }
              public void setNomenergie( String nomenergie){
                  this.nomenergie=nomenergie;
              }
          
              public String getNomenergie(){
                  return this.nomenergie;
              }
              public void setIdenergie( Long idenergie){
                  this.idenergie=idenergie;
              }
          
              public Long getIdenergie(){
                  return this.idenergie;
              }
              public void setNomtypevehicule( String nomtypevehicule){
                  this.nomtypevehicule=nomtypevehicule;
              }
          
              public String getNomtypevehicule(){
                  return this.nomtypevehicule;
              }
              public void setIdtypevehicule( Long idtypevehicule){
                  this.idtypevehicule=idtypevehicule;
              }
          
              public Long getIdtypevehicule(){
                  return this.idtypevehicule;
              }
              public void setNomcouleur( String nomcouleur){
                  this.nomcouleur=nomcouleur;
              }
          
              public String getNomcouleur(){
                  return this.nomcouleur;
              }
              public void setIdcouleur( Long idcouleur){
                  this.idcouleur=idcouleur;
              }
          
              public Long getIdcouleur(){
                  return this.idcouleur;
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
              public void setTel( String tel){
                  this.tel=tel;
              }
          
              public String getTel(){
                  return this.tel;
              }
              public void setEmail( String email){
                  this.email=email;
              }
          
              public String getEmail(){
                  return this.email;
              }
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
            public Long getIdphotocaracteristique() {
                return idphotocaracteristique;
            }

            public void setIdphotocaracteristique(Long idphotocaracteristique) {
                this.idphotocaracteristique = idphotocaracteristique;
            }
            public Long getIdclient() {
                return idclient;
            }
    
            public void setIdclient(Long idclient) {
                this.idclient = idclient;
            }
            public Double getConsomation() {
                return consomation;
            }
    
            public void setConsomation(Double consomation) {
                this.consomation = consomation;
            }
            Long idfavorie;
            public Long getIdfavorie() {
                return idfavorie;
            }
    
            public void setIdfavorie(Long idfavorie) {
                this.idfavorie = idfavorie;
            }
}
