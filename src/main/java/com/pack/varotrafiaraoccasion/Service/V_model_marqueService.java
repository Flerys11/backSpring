package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_model_marque;
import com.pack.varotrafiaraoccasion.Repository.V_model_marqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_model_marqueService {
    V_model_marqueRepository v_model_marqueRepository;

    @Autowired
    public V_model_marqueService(V_model_marqueRepository v_model_marqueRepository){
        this.v_model_marqueRepository=v_model_marqueRepository;
    }

    public java.util.List<V_model_marque> findAll(){
        return v_model_marqueRepository.findAll();
    }

    public V_model_marque findOne(Long idV_model_marque ){
        return v_model_marqueRepository.findOne(idV_model_marque).get();
    }

    public void delete(Long idV_model_marque){
        v_model_marqueRepository.deleteById(idV_model_marque);
    }

    public void update(V_model_marque table){
        v_model_marqueRepository.save(table);
    }
}
