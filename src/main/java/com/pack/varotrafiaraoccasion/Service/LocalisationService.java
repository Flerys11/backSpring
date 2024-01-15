package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Localisation;
import com.pack.varotrafiaraoccasion.Repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LocalisationService {
    LocalisationRepository localisationRepository;

    @Autowired
    public LocalisationService(LocalisationRepository localisationRepository){
        this.localisationRepository=localisationRepository;
    }

    public java.util.List<Localisation> findAll(){
        return localisationRepository.findAll();
    }

    public Localisation findOne(Long idLocalisation ){
        return localisationRepository.findOne(idLocalisation).get();
    }

    public void delete(Long idLocalisation){
        localisationRepository.deleteById(idLocalisation);
    }

    public void update(Localisation table){
        localisationRepository.save(table);
    }
}
