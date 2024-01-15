package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Etat;
import com.pack.varotrafiaraoccasion.Repository.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EtatService {
    EtatRepository etatRepository;

    @Autowired
    public EtatService(EtatRepository etatRepository){
        this.etatRepository=etatRepository;
    }

    public java.util.List<Etat> findAll(){
        return etatRepository.findAll();
    }

    public Etat findOne(Long idEtat ){
        return etatRepository.findOne(idEtat).get();
    }

    public void delete(Long idEtat){
        etatRepository.deleteById(idEtat);
    }

    public void update(Etat table){
        etatRepository.save(table);
    }
}
