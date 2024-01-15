package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Photocaracteristique;
import com.pack.varotrafiaraoccasion.Repository.PhotocaracteristiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PhotocaracteristiqueService {
    PhotocaracteristiqueRepository photocaracteristiqueRepository;

    @Autowired
    public PhotocaracteristiqueService(PhotocaracteristiqueRepository photocaracteristiqueRepository){
        this.photocaracteristiqueRepository=photocaracteristiqueRepository;
    }

    public java.util.List<Photocaracteristique> findAll(){
        return photocaracteristiqueRepository.findAll();
    }

    public Photocaracteristique findOne(Long idPhotocaracteristique ){
        return photocaracteristiqueRepository.findOne(idPhotocaracteristique).get();
    }

    public void delete(Long idPhotocaracteristique){
        photocaracteristiqueRepository.deleteById(idPhotocaracteristique);
    }

    public void update(Photocaracteristique table){
        photocaracteristiqueRepository.save(table);
    }
}
