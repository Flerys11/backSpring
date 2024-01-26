package com.pack.varotrafiaraoccasion.Entity;

import java.util.List;

public class AnnonceFactorer {
    V_liste_annonce v_liste_annonce;
    java.util.List<Equipement> listeEquipements;
    java.util.List<Photocaracteristique> listePhotocaracteristiques;
    public V_liste_annonce getV_liste_annonce() {
        return v_liste_annonce;
    }
    public void setV_liste_annonce(V_liste_annonce v_liste_annonce) {
        this.v_liste_annonce = v_liste_annonce;
    }
    public java.util.List<Equipement> getListeEquipements() {
        return listeEquipements;
    }
    public void setListeEquipements(java.util.List<Equipement> listeEquipements) {
        this.listeEquipements = listeEquipements;
    }
    public java.util.List<Photocaracteristique> getListePhotocaracteristiques() {
        return listePhotocaracteristiques;
    }
    public void setListePhotocaracteristiques(java.util.List<Photocaracteristique> listePhotocaracteristiques) {
        this.listePhotocaracteristiques = listePhotocaracteristiques;
    }
    public AnnonceFactorer(V_liste_annonce v_liste_annonce, List<Equipement> listeEquipements,
            List<Photocaracteristique> listePhotocaracteristiques) {
        this.v_liste_annonce = v_liste_annonce;
        this.listeEquipements = listeEquipements;
        this.listePhotocaracteristiques = listePhotocaracteristiques;
    }
    public AnnonceFactorer() {
    }
   
    

}
