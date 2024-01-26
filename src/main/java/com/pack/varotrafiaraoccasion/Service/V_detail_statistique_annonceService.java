package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_detail_statistique_annonce;
import com.pack.varotrafiaraoccasion.Repository.V_detail_statistique_annonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_detail_statistique_annonceService {
    V_detail_statistique_annonceRepository v_detail_statistique_annonceRepository;

    @Autowired
    public V_detail_statistique_annonceService(V_detail_statistique_annonceRepository v_detail_statistique_annonceRepository){
        this.v_detail_statistique_annonceRepository=v_detail_statistique_annonceRepository;
    }

    public java.util.List<V_detail_statistique_annonce> findAll(){
        return v_detail_statistique_annonceRepository.findAll();
    }

    public V_detail_statistique_annonce findOne(Long idV_detail_statistique_annonce ){
        return v_detail_statistique_annonceRepository.findOne(idV_detail_statistique_annonce).get();
    }

    public void delete(Long idV_detail_statistique_annonce){
        v_detail_statistique_annonceRepository.deleteById(idV_detail_statistique_annonce);
    }

    public void update(V_detail_statistique_annonce table){
        v_detail_statistique_annonceRepository.save(table);
    }
}
