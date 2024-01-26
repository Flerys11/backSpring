package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Administrateur;
import com.pack.varotrafiaraoccasion.Entity.Client;
import com.pack.varotrafiaraoccasion.Repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdministrateurService {
    AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository){
        this.administrateurRepository=administrateurRepository;
    }

    public java.util.List<Administrateur> findAll(){
        return administrateurRepository.findAll();
    }

    public Administrateur findOne(Long idAdministrateur ){
        return administrateurRepository.findOne(idAdministrateur).get();
    }
    public Administrateur findUser(String email,String password ){
        return administrateurRepository.findUser(email, password).get();
    }


    public void delete(Long idAdministrateur){
        administrateurRepository.deleteById(idAdministrateur);
    }

    public void update(Administrateur table){
        administrateurRepository.save(table);
    }
}
