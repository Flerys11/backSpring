package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.V_detail_statistique_annonce;
import com.pack.varotrafiaraoccasion.Entity.V_inscription;
import com.pack.varotrafiaraoccasion.Service.V_inscriptionService;
import java.text.SimpleDateFormat;
import com.pack.varotrafiaraoccasion.Work.Returntype;
import com.pack.varotrafiaraoccasion.Work.Statistic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@RestController
@RequestMapping
public class V_inscriptionController {

 private final V_inscriptionService v_inscriptionService;
    
    @Autowired
    public V_inscriptionController(V_inscriptionService v_inscriptionService){
        this.v_inscriptionService= v_inscriptionService;
    }

    @GetMapping("/varotrafiaraback/v_inscriptions")
    public Returntype findAll(){
        Returntype returntype = new Returntype();

        try {
            Statistic statistic = new Statistic();
            java.util.HashMap<String,Object> hashMap = new java.util.HashMap<String,Object>();
            List<V_inscription> liste = new V_inscription().findAll();
            hashMap.put("label", statistic.getLibelInscripion(liste) );
            hashMap.put("value", statistic.getDataInscripion(liste) );
            returntype = new Returntype(null,hashMap);
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_inscription")
    public Returntype findOne( @RequestParam("id") Long idV_inscription ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_inscriptionService.findOne(idV_inscription));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_inscription")
    public Returntype  delete(@RequestParam("id") Long idV_inscription){
        Returntype returntype = new Returntype();
        try {
            v_inscriptionService.delete(idV_inscription);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_inscription")
    public Returntype  update(@RequestBody V_inscription table){
        Returntype returntype = new Returntype();
        try {
            v_inscriptionService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_inscription")
    public Returntype  insert(@RequestBody V_inscription table){
        Returntype returntype = new Returntype();
        try {
            v_inscriptionService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
