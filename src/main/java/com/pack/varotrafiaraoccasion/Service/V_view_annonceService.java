package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.V_view_annonce;
import com.pack.varotrafiaraoccasion.Repository.V_view_annonceRepository;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.pack.varotrafiaraoccasion.Work.Requete;
@Service
public class V_view_annonceService {
    V_view_annonceRepository v_view_annonceRepository;

    @Autowired
    public V_view_annonceService(V_view_annonceRepository v_view_annonceRepository){
        this.v_view_annonceRepository=v_view_annonceRepository;
    }

    public java.util.List<V_view_annonce> findAll(){
        return v_view_annonceRepository.findAll();
    }

    public V_view_annonce findOne(Long idV_view_annonce ){
        return v_view_annonceRepository.findOne(idV_view_annonce).get();
    }

    public void delete(Long idV_view_annonce){
        v_view_annonceRepository.deleteById(idV_view_annonce);
    }

    public void update(V_view_annonce table){
        v_view_annonceRepository.save(table);
    }

    public java.util.List<V_view_annonce> pagination(int borneb,Long idclient){
        java.util.List<V_view_annonce> data = v_view_annonceRepository.pagination(borneb,idclient);
        java.util.List<V_view_annonce> dataresulte  =  new java.util.ArrayList<V_view_annonce>();
        Long a=0L;
        for(int i=0;i<data.size();i++){
             System.out.println("idcaracteristique liste :"+data.get(i).getIdcaracteristique());
            if(data.get(i).getIdcaracteristique()!=a){
                System.out.println("idcaracteristique "+data.get(i).getIdcaracteristique());
                a=data.get(i).getIdcaracteristique();
                dataresulte.add(data.get(i));
            }
        }
         System.out.println("fin");
        return dataresulte;
    }

    public java.util.List<V_view_annonce> allView(Long idclient){
        java.util.List<V_view_annonce> data = Requete.allValue_viewannonce(idclient);
        java.util.List<V_view_annonce> dataresulte  =  new java.util.ArrayList<V_view_annonce>();
        Long a=0L;
        for(int i=0;i<data.size();i++){
            if(data.get(i).getIdcaracteristique()!=a){ 
                a=data.get(i).getIdcaracteristique();
                dataresulte.add(data.get(i));
            }
        }
        return dataresulte;
    }

}
