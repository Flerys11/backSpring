package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import com.pack.varotrafiaraoccasion.Repository.V_liste_annonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_liste_annonceService {
    V_liste_annonceRepository v_liste_annonceRepository;

    @Autowired
    public V_liste_annonceService(V_liste_annonceRepository v_liste_annonceRepository){
        this.v_liste_annonceRepository=v_liste_annonceRepository;
    }

    public java.util.List<V_liste_annonce> findAll(){
        return v_liste_annonceRepository.findAll();
    }

    public V_liste_annonce findOne(Long idV_liste_annonce ){
        return v_liste_annonceRepository.findOne(idV_liste_annonce).get();
    }

    public void delete(Long idV_liste_annonce){
        v_liste_annonceRepository.deleteById(idV_liste_annonce);
    }

    public void update(V_liste_annonce table){
        v_liste_annonceRepository.save(table);
    }
}
