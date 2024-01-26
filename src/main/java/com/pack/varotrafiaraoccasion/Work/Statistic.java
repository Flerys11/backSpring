package com.pack.varotrafiaraoccasion.Work;

import java.util.*;

import com.pack.varotrafiaraoccasion.Entity.Clientdateinscription;
import com.pack.varotrafiaraoccasion.Entity.Etat;
import com.pack.varotrafiaraoccasion.Entity.V_commision_vente;
import com.pack.varotrafiaraoccasion.Entity.V_detail_statistique_annonce;
import com.pack.varotrafiaraoccasion.Entity.V_inscription;
import com.pack.varotrafiaraoccasion.Entity.V_statistique_annonce;

public class Statistic {
    String[] couleursRGBA = {
        "rgba(255, 99, 132, 1)",
        "rgba(200, 50, 100, 1)",
        "rgba(150, 75, 125, 1)",
        "rgba(100, 120, 80, 1)",
        "rgba(220, 20, 60, 1)",
        "rgba(255, 165, 0, 1)",
        "rgba(0, 128, 128, 1)",
        "rgba(128, 0, 128, 1)",
        "rgba(0, 0, 255, 1)",
        "rgba(255, 0, 0, 1)",
        "rgba(0, 255, 0, 1)",
        "rgba(128, 128, 0, 1)",
        "rgba(0, 0, 128, 1)",
        "rgba(255, 255, 0, 1)",
        "rgba(0, 255, 255, 1)",
        "rgba(255, 0, 255, 1)",
        "rgba(75, 0, 130, 1)",
        "rgba(173, 216, 230, 1)",
        "rgba(255, 215, 0, 1)",
        "rgba(70, 130, 180, 1)"
    };
    //statistique inscription 
    public List<Long> getDataInscripion(List<V_inscription> v_statistique_annonce){
        List<Long> resulta = new ArrayList<Long>();
        for(int i=0;i<v_statistique_annonce.size();i++){
           resulta.add(v_statistique_annonce.get(i).getNbr());
            
        }
        return resulta;
    }
    public List<String> getLibelInscripion(List<V_inscription> v_statistique_annonce){
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            String libel = v_statistique_annonce.get(i).getMois()+"-"+v_statistique_annonce.get(i).getAnnee();
            System.out.println("libel :"+libel);
            if(In(resulta,libel )==false){
                resulta.add(libel);
            }
        }
        return resulta;
    }

    //fin stat inscription
    //statistique par marque de voiture
    public List<Long> modifvalue(List<String> date,List<String> dateetat,List<Long> listelong){
        List<Long> resulta = new ArrayList<Long>();
        int a=0;
        System.out.println("size date etat "+dateetat.size());
        if(dateetat.size()<=0){
            System.out.println("value null");
            for(int i=0;i<date.size();i++){
                resulta.add(0L);
            }
        }else{
            for(int i=0;i<date.size();i++){
                if(a<dateetat.size()){
                    if(date.get(i).compareTo(dateetat.get(a))==0){
                        resulta.add(listelong.get(a));
                        a++;
                    }
                    else{
                        resulta.add(0L);
                    }
                }
                else{
                    resulta.add(0L);
                }
            }
        }
        return resulta;
    }
    public List<String> getDateEtat(List<V_detail_statistique_annonce> v_statistique_annonce,Long etat,String nommarque){
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            if(v_statistique_annonce.get(i).getIdetat()==etat && v_statistique_annonce.get(i).getNommarque().compareTo(nommarque)==0){
                String libel = v_statistique_annonce.get(i).getMois()+"-"+v_statistique_annonce.get(i).getAnnee();
                if(In(resulta,libel )==false){
                    resulta.add(libel);
                }
            }
        }
        return resulta;
    }
    public HashMap<String,HashMap<String,List<Long>>>  buildDatastateMarque(List<V_detail_statistique_annonce> v_statistique_annonces,List<Etat> listEtat){ //retourne les donne par etat d une marque
        HashMap<String,HashMap<String,List<Long>>> resulta = new  HashMap<String,HashMap<String,List<Long>>>();
        List<String> marque =  getMarque(v_statistique_annonces);
        for(int i=0;i<marque.size();i++){   
            resulta.put(marque.get(i),getdatavalueparEtat(v_statistique_annonces,listEtat,marque.get(i)));
        }
        return resulta;
    }

    public HashMap<String,List<Long>> getdatavalueparEtat(List<V_detail_statistique_annonce> v_statistique_annonces,List<Etat> listEtat,String nommarque){ //retourne les donne par etat d une marque
        HashMap<String,List<Long>> resulta = new HashMap<String,List<Long>>();
        List<String> datelibel= getLibelDetailleAnnonce(v_statistique_annonces);
        for(int i=0;i<listEtat.size();i++){
            List<Long> data =  modifvalue(datelibel, getDateEtat(v_statistique_annonces,listEtat.get(i).getIdetat(),nommarque),getDataetat(v_statistique_annonces,listEtat.get(i).getIdetat(),nommarque));
            resulta.put(listEtat.get(i).getNometat(), data);
        }
        return resulta;
    }
    public List<Long> getDataetat(List<V_detail_statistique_annonce> v_statistique_annonces,Long idetat,String nommarque){
        List<Long> resulta = new ArrayList<Long>();
        for(int i=0 ; i<v_statistique_annonces.size();i++){
            if(v_statistique_annonces.get(i).getIdetat()==idetat && v_statistique_annonces.get(i).getNommarque().compareTo(nommarque)==0){
                Long value = v_statistique_annonces.get(i).getCount();
                resulta.add(value);
            }
        }
        return resulta;
    }

    public List<String> getMarque(List<V_detail_statistique_annonce> v_statistique_annonce){ //les marques present dans l'historique 
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            String libel = v_statistique_annonce.get(i).getNommarque();
            if(In(resulta,libel )==false){
                resulta.add(libel);
            }
        }
        return resulta;
    }

    public List<String> getLibelDetailleAnnonce(List<V_detail_statistique_annonce> v_statistique_annonce){ //retourne les liste annee dans le data
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            String libel = v_statistique_annonce.get(i).getMois()+"-"+v_statistique_annonce.get(i).getAnnee();
            // System.out.println("libel :"+libel);
            if(In(resulta,libel )==false){
                resulta.add(libel);
            }
        }
        return resulta;
    }

    //fin statistique par marque

    public List<String> getLibelcommission(List<V_commision_vente> v_statistique_annonce){
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            String libel = v_statistique_annonce.get(i).getMois()+"-"+v_statistique_annonce.get(i).getAnnee();
            // System.out.println("libel :"+libel);
            if(In(resulta,libel )==false){
                resulta.add(libel);
            }
        }
        return resulta;
    }
    public List<Double> getDatacommission(List<V_commision_vente> v_statistique_annonce){
        List<Double> resulta = new ArrayList<Double>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            resulta.add(v_statistique_annonce.get(i).getSum());
        }
        return resulta;
    }


    public Statistic(){}
    public Boolean In(List<String> table ,String value){
        for(int i=0;i<table.size();i++){
            if(table.get(i).compareTo(value)==0){
                return true;
            }
        }
        return false;

    }
    public List<String> getLibel(List<V_statistique_annonce> v_statistique_annonce){
        List<String> resulta = new ArrayList<String>();
        for(int i=0;i<v_statistique_annonce.size();i++){
            String libel = v_statistique_annonce.get(i).getMois()+"-"+v_statistique_annonce.get(i).getAnnee();
            // System.out.println("libel :"+libel);
            if(In(resulta,libel )==false){
                resulta.add(libel);
            }
        }
        return resulta;
    }
    public List<Long> getDatevalue(List<V_statistique_annonce> v_statistique_annonces,Long idetat){
        List<Long> resulta = new ArrayList<Long>();
        for(int i=0 ; i<v_statistique_annonces.size();i++){
            if(v_statistique_annonces.get(i).getIdetat()==idetat){
                Long value = v_statistique_annonces.get(i).getCount();
                resulta.add(value);
            }
        }
        return resulta;
    }
    public List<List<Long>> getdata(List<V_statistique_annonce> v_statistique_annonces,List<Etat> listEtat){
        List<List<Long>> resulta = new ArrayList<List<Long>>();
        for(int i=0;i<listEtat.size();i++){
            resulta.add(getDatevalue(v_statistique_annonces,listEtat.get(i).getIdetat()));
        }
        return resulta;
    }
    public HashMap<String,List<Long>> getdatavalue(List<V_statistique_annonce> v_statistique_annonces,List<Etat> listEtat){
        HashMap<String,List<Long>> resulta = new HashMap<String,List<Long>>();
        for(int i=0;i<listEtat.size();i++){
            resulta.put(listEtat.get(i).getNometat(), getDatevalue(v_statistique_annonces,listEtat.get(i).getIdetat()));
        }
        return resulta;
    }
    public List<Datasets> datasets(List<V_statistique_annonce> v_statistique_annonces,List<Etat> listEtat){
        List<Datasets> resulta =  new ArrayList<Datasets>();
        for(int i=0;i<listEtat.size();i++){
            Datasets datasets = new Datasets(listEtat.get(i).getNometat(), getDatevalue(v_statistique_annonces, listEtat.get(i).getIdetat()).toArray(new Long[0]), couleursRGBA[i]);
           resulta.add(datasets);

        }
        return resulta;
    }
    public HashMap<String,Object> data(List<V_statistique_annonce> v_statistique_annonces,List<Etat> listEtat){
        HashMap<String,Object> resulta =  new HashMap<String,Object>();
        resulta.put("labels", getLibel(v_statistique_annonces));
        resulta.put("datasets", getdatavalue( v_statistique_annonces,listEtat));
        return resulta;
    }

}
