package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Energie;
import com.pack.varotrafiaraoccasion.Repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EnergieService {
    EnergieRepository energieRepository;

    @Autowired
    public EnergieService(EnergieRepository energieRepository){
        this.energieRepository=energieRepository;
    }

    public java.util.List<Energie> findAll(){
        return energieRepository.findAll();
    }

    public Energie findOne(Long idEnergie ){
        return energieRepository.findOne(idEnergie).get();
    }

    public void delete(Long idEnergie){
        energieRepository.deleteById(idEnergie);
    }

    public void update(Energie table){
        energieRepository.save(table);
    }
}
