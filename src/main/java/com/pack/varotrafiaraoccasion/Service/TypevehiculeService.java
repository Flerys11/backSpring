package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Typevehicule;
import com.pack.varotrafiaraoccasion.Repository.TypevehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TypevehiculeService {
    TypevehiculeRepository typevehiculeRepository;

    @Autowired
    public TypevehiculeService(TypevehiculeRepository typevehiculeRepository){
        this.typevehiculeRepository=typevehiculeRepository;
    }

    public java.util.List<Typevehicule> findAll(){
        return  typevehiculeRepository.findAll();
    }

    public Typevehicule findOne(Long idTypevehicule ){
        return typevehiculeRepository.findOne(idTypevehicule).get();
    }

    public void delete(Long idTypevehicule){
        typevehiculeRepository.deleteById(idTypevehicule);
    }

    public void update(Typevehicule table){
        typevehiculeRepository.save(table);
    }
}
