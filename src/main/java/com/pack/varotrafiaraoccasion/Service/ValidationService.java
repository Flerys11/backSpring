package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Validation;
import com.pack.varotrafiaraoccasion.Repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ValidationService {
    ValidationRepository validationRepository;

    @Autowired
    public ValidationService(ValidationRepository validationRepository){
        this.validationRepository=validationRepository;
    }

    public java.util.List<Validation> findAll(){
        return validationRepository.findAll();
    }

    public Validation findOne(Long idValidation ){
        return validationRepository.findOne(idValidation).get();
    }

    public void delete(Long idValidation){
        validationRepository.deleteById(idValidation);
    }

    public void update(Validation table){
        validationRepository.save(table);
    }
}
