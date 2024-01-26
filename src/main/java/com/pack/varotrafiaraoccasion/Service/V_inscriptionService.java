package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_inscription;
import com.pack.varotrafiaraoccasion.Repository.V_inscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_inscriptionService {
    V_inscriptionRepository v_inscriptionRepository;

    @Autowired
    public V_inscriptionService(V_inscriptionRepository v_inscriptionRepository){
        this.v_inscriptionRepository=v_inscriptionRepository;
    }

    public java.util.List<V_inscription> findAll(){
        return v_inscriptionRepository.findAll();
    }

    public V_inscription findOne(Long idV_inscription ){
        return v_inscriptionRepository.findOne(idV_inscription).get();
    }

    public void delete(Long idV_inscription){
        v_inscriptionRepository.deleteById(idV_inscription);
    }

    public void update(V_inscription table){
        v_inscriptionRepository.save(table);
    }
}
