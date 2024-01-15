package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Client;
import com.pack.varotrafiaraoccasion.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public java.util.List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findOne(Long idClient ){
        return clientRepository.findOne(idClient).get();
    }
    public Client findUser(String email,String password ){
        return clientRepository.findUser(email, password).get();
    }

    public void delete(Long idClient){
        clientRepository.deleteById(idClient);
    }

    public void update(Client table){
        clientRepository.save(table);
    }
}
