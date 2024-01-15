package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Couleur;
import com.pack.varotrafiaraoccasion.Repository.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CouleurService {
    CouleurRepository couleurRepository;

    @Autowired
    public CouleurService(CouleurRepository couleurRepository){
        this.couleurRepository=couleurRepository;
    }

    public java.util.List<Couleur> findAll(){
        return couleurRepository.findAll();
    }

    public Couleur findOne(Long idCouleur ){
        return couleurRepository.findOne(idCouleur).get();
    }

    public void delete(Long idCouleur){
        couleurRepository.deleteById(idCouleur);
    }

    public void update(Couleur table){
        couleurRepository.save(table);
    }
}
