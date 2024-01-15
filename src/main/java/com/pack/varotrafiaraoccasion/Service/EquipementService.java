package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Equipement;
import com.pack.varotrafiaraoccasion.Repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EquipementService {
    EquipementRepository equipementRepository;

    @Autowired
    public EquipementService(EquipementRepository equipementRepository){
        this.equipementRepository=equipementRepository;
    }

    public java.util.List<Equipement> findAll(){
        return equipementRepository.findAll();
    }

    public Equipement findOne(Long idEquipement ){
        return equipementRepository.findOne(idEquipement).get();
    }

    public void delete(Long idEquipement){
        equipementRepository.deleteById(idEquipement);
    }

    public void update(Equipement table){
        equipementRepository.save(table);
    }
}
