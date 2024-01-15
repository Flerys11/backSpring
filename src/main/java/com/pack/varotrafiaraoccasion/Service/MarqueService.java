package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Marque;
import com.pack.varotrafiaraoccasion.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MarqueService {
    MarqueRepository marqueRepository;

    @Autowired
    public MarqueService(MarqueRepository marqueRepository){
        this.marqueRepository=marqueRepository;
    }

    public java.util.List<Marque> findAll(){
        return marqueRepository.findAll();
    }

    public Marque findOne(Long idMarque ){
        return marqueRepository.findOne(idMarque).get();
    }

    public void delete(Long idMarque){
        marqueRepository.deleteById(idMarque);
    }

    public void update(Marque table){
        marqueRepository.save(table);
    }
}
