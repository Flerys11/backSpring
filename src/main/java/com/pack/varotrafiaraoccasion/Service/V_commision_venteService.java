package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_commision_vente;
import com.pack.varotrafiaraoccasion.Repository.V_commision_venteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_commision_venteService {
    V_commision_venteRepository v_commision_venteRepository;

    @Autowired
    public V_commision_venteService(V_commision_venteRepository v_commision_venteRepository){
        this.v_commision_venteRepository=v_commision_venteRepository;
    }

    public java.util.List<V_commision_vente> findAll(){
        return v_commision_venteRepository.findAll();
    }

    public V_commision_vente findOne(Long idV_commision_vente ){
        return v_commision_venteRepository.findOne(idV_commision_vente).get();
    }

    public void delete(Long idV_commision_vente){
        v_commision_venteRepository.deleteById(idV_commision_vente);
    }

    public void update(V_commision_vente table){
        v_commision_venteRepository.save(table);
    }
}
