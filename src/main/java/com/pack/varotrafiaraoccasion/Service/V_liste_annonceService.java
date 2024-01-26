package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.AnnonceFactorer;
import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import com.pack.varotrafiaraoccasion.Entity.Equipement;
import com.pack.varotrafiaraoccasion.Entity.Photocaracteristique;
import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import com.pack.varotrafiaraoccasion.Repository.V_liste_annonceRepository;
import com.pack.varotrafiaraoccasion.Work.Requete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_liste_annonceService {
    V_liste_annonceRepository v_liste_annonceRepository;

    public java.util.List<V_liste_annonce> findAllAdmin(){ //liste de tout les annonce avec la dmin
        java.util.List<V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllrequeteAnnonce();
        Long a= 0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                a=an.getIdcaracteristique();
                resulta.add(an);
            }
            
        }
        return resulta;
    }

    public java.util.List<V_liste_annonce> findAllHistorique(Long id){
        java.util.List<V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllrequeteAnnonceIdclient(id);
        Long a= 0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                a=an.getIdcaracteristique();
                resulta.add(an);
            }
            
        }
        return resulta;
    }

    public java.util.List<V_liste_annonce> findAllByIdclient(Long id){
        java.util.List<V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllAnnonceWithFavorie(id);
        Long a= 0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                // System.out.println("idcaracteristique :"+an.getIdcaracteristique());
                a=an.getIdcaracteristique();
                resulta.add(an);
            }
            
        }
        return resulta;
    }

    public java.util.List<V_liste_annonce> findAllListeAnnonceFavorie(Long id){
        java.util.List<V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllAnnonceWithFavorie(id);
        Long a= 0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a && an.getIdfavorie()!=0){
                // System.out.println("idcaracteristique :"+an.getIdcaracteristique());
                a=an.getIdcaracteristique();
                resulta.add(an);
            }
            
        }
        return resulta;
    }

    public java.util.List<V_liste_annonce> findAllListeAnnonce(){
        java.util.List<V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllrequeteAnnonceValidee();
        Long a= 0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                // System.out.println("idcaracteristique :"+an.getIdcaracteristique());
                a=an.getIdcaracteristique();
                resulta.add(an);
            }
            
        }
        return resulta;
    }

    public Boolean notInPhoto(java.util.List<Photocaracteristique> liste ,Long id){
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getIdphotocaracteristique()==id){
                return false;
            }
        }
        return true;
    }


     public Boolean notInEquipement(java.util.List<Equipement> liste ,Long id){
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).getIdequipement()==id){
                return false;
            }
        }
        return true;
    }
    @Autowired
    public V_liste_annonceService(V_liste_annonceRepository v_liste_annonceRepository){
        this.v_liste_annonceRepository=v_liste_annonceRepository;
    }

    public java.util.List<V_liste_annonce>   findAllin(){
        return v_liste_annonceRepository.findAllin();
    }

    // public java.util.List<String>  test(){
    //     return v_liste_annonceRepository.test();
    // }
    public java.util.List<V_liste_annonce> findAll(){
        return v_liste_annonceRepository.findAll();
    }
    public java.util.List<AnnonceFactorer> findAllFactorer(){
        java.util.List<AnnonceFactorer> listeAnnonceFactorers = new java.util.ArrayList<AnnonceFactorer>();
        // java.util.List<V_liste_annonce>liste = v_liste_annonceRepository.findAll();
        java.util.List<V_liste_annonce>liste = Requete.findAllrequeteAnnonce();
        Long a= 0L;

        // System.out.println("idequipement :"+liste.size()); 


        for(int i =0;i <liste.size() ;i++ ){
            AnnonceFactorer annonceFactorer = new AnnonceFactorer(null, null, null);
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                // System.out.println("idcaracteristique :"+an.getIdcaracteristique());
                a=an.getIdcaracteristique();
                annonceFactorer.setV_liste_annonce(an);
            }
            Long idequipement =0L;
            java.util.List<Equipement> listeEquipements = new java.util.ArrayList<Equipement>();
            java.util.List<Photocaracteristique>  listePhotocaracteristiques= new java.util.ArrayList<Photocaracteristique>();
            for(int c=i;c<liste.size();c++){
                V_liste_annonce an_s = liste.get(c);
                // System.out.println("num equipement :"+an_s.getNomequipement()+" "+an_s.getIdphotocaracteristique());
                if(an_s.getIdcaracteristique()==a){
                    if(notInEquipement(listeEquipements,an_s.getIdequipement())==true){
                        // System.out.println("idequipement :"+an_s.getIdequipement());
                        Equipement equipement = new Equipement(an_s.getIdequipement(),an_s.getNomequipement());
                        listeEquipements.add(equipement);
                    }
                    if( notInPhoto(listePhotocaracteristiques,an_s.getIdphotocaracteristique())==true ){
                        // System.out.println("idphoto :"+an.getIdphotocaracteristique());
                        Photocaracteristique equipement = new Photocaracteristique(an_s.getIdphotocaracteristique(),an_s.getIdcaracteristique(),an_s.getNomimage());
                        listePhotocaracteristiques.add(equipement);
                    }
                }else{
                    break;
                }
                i++;
            }
            // System.out.println(" value i :"+i);
            annonceFactorer.setListeEquipements(listeEquipements);
            annonceFactorer.setListePhotocaracteristiques(listePhotocaracteristiques);
            listeAnnonceFactorers.add(annonceFactorer);
        }
        // System.out.println("fin");
        return listeAnnonceFactorers;
    }

    public V_liste_annonce findOne(Long idV_liste_annonce ){
        return v_liste_annonceRepository.findOne(idV_liste_annonce).get();
    }

    public void delete(Long idV_liste_annonce){
        v_liste_annonceRepository.deleteById(idV_liste_annonce);
    }

    public void update(V_liste_annonce table){
        v_liste_annonceRepository.save(table);
    }

    public java.util.List<AnnonceFactorer> findAllFactorer(Long id){
        java.util.List<AnnonceFactorer> listeAnnonceFactorers = new java.util.ArrayList<AnnonceFactorer>();
        java.util.List<V_liste_annonce>liste = Requete.findAllrequeteAnnonceId(id);
        Long a=0L;
        for(int i =0;i <liste.size() ;i++ ){
            V_liste_annonce an_s = liste.get(i);
             System.out.println("idequipement :"+an_s.getIdequipement());
        }
        for(int i =0;i <liste.size() ;i++ ){
            AnnonceFactorer annonceFactorer = new AnnonceFactorer(null, null, null);
            V_liste_annonce an = liste.get(i);
            if(an.getIdcaracteristique()!=a){
                System.out.println("idcaracteristique :"+an.getIdcaracteristique());
                a=an.getIdcaracteristique();
                annonceFactorer.setV_liste_annonce(an);
            }
            Long idequipement =0L;
            java.util.List<Equipement> listeEquipements = new java.util.ArrayList<Equipement>();
            java.util.List<Photocaracteristique>  listePhotocaracteristiques= new java.util.ArrayList<Photocaracteristique>();
            for(int c=i;c<liste.size();c++){
                V_liste_annonce an_s = liste.get(c);
                System.out.println("num equipement :"+an_s.getNomequipement()+" "+an_s.getIdphotocaracteristique());
                if(an_s.getIdcaracteristique()==a){
                    if(notInEquipement(listeEquipements,an_s.getIdequipement())==true){
                        System.out.println("idequipement :"+an_s.getIdequipement());
                        Equipement equipement = new Equipement(an_s.getIdequipement(),an_s.getNomequipement());
                        listeEquipements.add(equipement);
                    }
                    if( notInPhoto(listePhotocaracteristiques,an_s.getIdphotocaracteristique())==true ){
                        System.out.println("idphoto :"+an.getIdphotocaracteristique());
                        Photocaracteristique equipement = new Photocaracteristique(an_s.getIdphotocaracteristique(),an_s.getIdcaracteristique(),an_s.getNomimage());
                        listePhotocaracteristiques.add(equipement);
                    }
                }else{
                    break;
                }
                i++;
            }
            System.out.println(" value i :"+i);
            annonceFactorer.setListeEquipements(listeEquipements);
            annonceFactorer.setListePhotocaracteristiques(listePhotocaracteristiques);
            listeAnnonceFactorers.add(annonceFactorer);
        }
        System.out.println("fin");
        return listeAnnonceFactorers;
    }

}
