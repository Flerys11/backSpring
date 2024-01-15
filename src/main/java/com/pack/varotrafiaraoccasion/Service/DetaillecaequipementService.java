package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Detaillecaequipement;
import com.pack.varotrafiaraoccasion.Repository.DetaillecaequipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DetaillecaequipementService {
    DetaillecaequipementRepository detaillecaequipementRepository;

    @Autowired
    public DetaillecaequipementService(DetaillecaequipementRepository detaillecaequipementRepository){
        this.detaillecaequipementRepository=detaillecaequipementRepository;
    }

    public java.util.List<Detaillecaequipement> findAll(){
        return detaillecaequipementRepository.findAll();
    }

    public Detaillecaequipement findOne(Long idDetaillecaequipement ){
        return detaillecaequipementRepository.findOne(idDetaillecaequipement).get();
    }

    public void delete(Long idDetaillecaequipement){
        detaillecaequipementRepository.deleteById(idDetaillecaequipement);
    }

    public void update(Detaillecaequipement table){
        detaillecaequipementRepository.save(table);
    }
}
