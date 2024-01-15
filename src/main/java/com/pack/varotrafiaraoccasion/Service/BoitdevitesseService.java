package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Boitdevitesse;
import com.pack.varotrafiaraoccasion.Repository.BoitdevitesseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BoitdevitesseService {
    BoitdevitesseRepository boitdevitesseRepository;

    @Autowired
    public BoitdevitesseService(BoitdevitesseRepository boitdevitesseRepository){
        this.boitdevitesseRepository=boitdevitesseRepository;
    }

    public java.util.List<Boitdevitesse> findAll(){
        return boitdevitesseRepository.findAll();
    }

    public Boitdevitesse findOne(Long idBoitdevitesse ){
        return boitdevitesseRepository.findOne(idBoitdevitesse).get();
    }

    public void delete(Long idBoitdevitesse){
        boitdevitesseRepository.deleteById(idBoitdevitesse);
    }

    public void update(Boitdevitesse table){
        boitdevitesseRepository.save(table);
    }
}
