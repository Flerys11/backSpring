package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Clientdateinscription;
import com.pack.varotrafiaraoccasion.Repository.ClientdateinscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientdateinscriptionService {
    ClientdateinscriptionRepository clientdateinscriptionRepository;

    @Autowired
    public ClientdateinscriptionService(ClientdateinscriptionRepository clientdateinscriptionRepository){
        this.clientdateinscriptionRepository=clientdateinscriptionRepository;
    }

    public java.util.List<Clientdateinscription> findAll(){
        return clientdateinscriptionRepository.findAll();
    }

    public Clientdateinscription findOne(Long idClientdateinscription ){
        return clientdateinscriptionRepository.findOne(idClientdateinscription).get();
    }

    public void delete(Long idClientdateinscription){
        clientdateinscriptionRepository.deleteById(idClientdateinscription);
    }

    public void update(Clientdateinscription table){
        clientdateinscriptionRepository.save(table);
    }
}
