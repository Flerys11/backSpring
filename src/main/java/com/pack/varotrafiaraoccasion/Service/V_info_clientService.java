package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_info_client;
import com.pack.varotrafiaraoccasion.Repository.V_info_clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_info_clientService {
    V_info_clientRepository v_info_clientRepository;

    @Autowired
    public V_info_clientService(V_info_clientRepository v_info_clientRepository){
        this.v_info_clientRepository=v_info_clientRepository;
    }

    public java.util.List<V_info_client> findAll(){
        return v_info_clientRepository.findAll();
    }

    public V_info_client findOne(Long idV_info_client ){
        return v_info_clientRepository.findOne(idV_info_client).get();
    }

    public void delete(Long idV_info_client){
        v_info_clientRepository.deleteById(idV_info_client);
    }

    public void update(V_info_client table){
        v_info_clientRepository.save(table);
    }
    public java.util.Optional<V_info_client> findByIdclient(Long idclient){
        return v_info_clientRepository.findByIdclient(idclient);
    }
}
