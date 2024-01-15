package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Model;
import com.pack.varotrafiaraoccasion.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ModelService {
    ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository){
        this.modelRepository=modelRepository;
    }

    public java.util.List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model findOne(Long idModel ){
        return modelRepository.findOne(idModel).get();
    }

    public void delete(Long idModel){
        modelRepository.deleteById(idModel);
    }

    public void update(Model table){
        modelRepository.save(table);
    }
}
