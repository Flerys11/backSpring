package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Commission;
import com.pack.varotrafiaraoccasion.Repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CommissionService {
    CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commissionRepository){
        this.commissionRepository=commissionRepository;
    }

    public java.util.List<Commission> findAll(){
        return commissionRepository.findAll();
    }

    public Commission findOne(Long idCommission ){
        return commissionRepository.findOne(idCommission).get();
    }

    public void delete(Long idCommission){
        commissionRepository.deleteById(idCommission);
    }

    public void update(Commission table){
        commissionRepository.save(table);
    }
}
