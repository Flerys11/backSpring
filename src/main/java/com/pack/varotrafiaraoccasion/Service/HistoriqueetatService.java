package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Historiqueetat;
import com.pack.varotrafiaraoccasion.Repository.HistoriqueetatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HistoriqueetatService {
    HistoriqueetatRepository historiqueetatRepository;

    @Autowired
    public HistoriqueetatService(HistoriqueetatRepository historiqueetatRepository){
        this.historiqueetatRepository=historiqueetatRepository;
    }

    public java.util.List<Historiqueetat> findAll(){
        return historiqueetatRepository.findAll();
    }

    public Historiqueetat findOne(Long idHistoriqueetat ){
        return historiqueetatRepository.findOne(idHistoriqueetat).get();
    }

    public void delete(Long idHistoriqueetat){
        historiqueetatRepository.deleteById(idHistoriqueetat);
    }

    public void update(Historiqueetat table){
        historiqueetatRepository.save(table);
    }
}
