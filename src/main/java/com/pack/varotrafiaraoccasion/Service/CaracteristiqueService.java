package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import com.pack.varotrafiaraoccasion.Repository.CaracteristiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CaracteristiqueService {
    CaracteristiqueRepository caracteristiqueRepository;

    @Autowired
    public CaracteristiqueService(CaracteristiqueRepository caracteristiqueRepository){
        this.caracteristiqueRepository=caracteristiqueRepository;
    }

    public java.util.List<Caracteristique> findAll(){
        return caracteristiqueRepository.findAll();
    }

    public Caracteristique findOne(Long idCaracteristique ){
        return caracteristiqueRepository.findOne(idCaracteristique).get();
    }

    public void delete(Long idCaracteristique){
        caracteristiqueRepository.deleteById(idCaracteristique);
    }

    public void update(Caracteristique table){
        caracteristiqueRepository.save(table);
    }
}
