package com.pack.varotrafiaraoccasion.Controlleur;

import org.springframework.web.multipart.MultipartFile;

import com.pack.varotrafiaraoccasion.Entity.Caracteristique;

public class DataAnnonce {
    
    private MultipartFile[] images;
    private Caracteristique caracteristique;
    private Long[] equipements;
    public MultipartFile[] getImages() {
        return images;
    }
    public void setImages(MultipartFile[] images) {
        this.images = images;
    }
    public Caracteristique getCaracteristique() {
        return caracteristique;
    }
    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }
    public Long[] getEquipements() {
        return equipements;
    }
    public void setEquipements(Long[] equipements) {
        this.equipements = equipements;
    }
    public DataAnnonce(MultipartFile[] images, Caracteristique caracteristique, Long[] equipements) {
        this.images = images;
        this.caracteristique = caracteristique;
        this.equipements = equipements;
    }

    

}
