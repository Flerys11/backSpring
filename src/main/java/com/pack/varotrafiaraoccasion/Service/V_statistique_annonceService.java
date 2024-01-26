package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_statistique_annonce;
import com.pack.varotrafiaraoccasion.Repository.V_statistique_annonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_statistique_annonceService {
    V_statistique_annonceRepository v_statistique_annonceRepository;

    @Autowired
    public V_statistique_annonceService(V_statistique_annonceRepository v_statistique_annonceRepository){
        this.v_statistique_annonceRepository=v_statistique_annonceRepository;
    }

    public java.util.List<V_statistique_annonce> findAll(){
        return v_statistique_annonceRepository.findAll();
    }

    public V_statistique_annonce findOne(Long idV_statistique_annonce ){
        return v_statistique_annonceRepository.findOne(idV_statistique_annonce).get();
    }

    public void delete(Long idV_statistique_annonce){
        v_statistique_annonceRepository.deleteById(idV_statistique_annonce);
    }

    public void update(V_statistique_annonce table){
        v_statistique_annonceRepository.save(table);
    }
}
