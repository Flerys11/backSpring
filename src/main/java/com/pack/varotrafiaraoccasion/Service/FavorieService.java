package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Favorie;
import com.pack.varotrafiaraoccasion.Repository.FavorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FavorieService {
    FavorieRepository favorieRepository;

    @Autowired
    public FavorieService(FavorieRepository favorieRepository){
        this.favorieRepository=favorieRepository;
    }

    public java.util.List<Favorie> findAll(){
        return favorieRepository.findAll();
    }

    public Favorie findOne(Long idFavorie ){
        return favorieRepository.findOne(idFavorie).get();
    }

    public void delete(Long idFavorie){
        favorieRepository.deleteById(idFavorie);
    }

    public void update(Favorie table){
        favorieRepository.save(table);
    }
    public java.util.Optional<Favorie> findfavorie(Long idclient,Long idcaracteristique){
       return favorieRepository.findfavorie(idclient,idcaracteristique);
    }
}
