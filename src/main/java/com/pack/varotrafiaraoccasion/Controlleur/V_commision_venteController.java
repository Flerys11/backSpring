package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.V_commision_vente;
import com.pack.varotrafiaraoccasion.Service.V_commision_venteService;
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
import java.sql.*;
import com.pack.varotrafiaraoccasion.Work.*;
import com.pack.varotrafiaraoccasion.Entity.*;

@RestController
@RequestMapping
public class V_commision_venteController {

 private final V_commision_venteService v_commision_venteService;
    
    @Autowired
    public V_commision_venteController(V_commision_venteService v_commision_venteService){
        this.v_commision_venteService= v_commision_venteService;
    }

    @GetMapping("/varotrafiaraback/v_commision_ventes")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
             Statistic statistic = new Statistic();
            java.util.HashMap<String,Object> hashMap = new java.util.HashMap<String,Object>();
            List<V_commision_vente> commission = v_commision_venteService.findAll();
            hashMap.put("label", statistic.getLibelcommission(commission) );
            hashMap.put("value",  statistic.getDatacommission(commission));
            returntype = new Returntype(null,hashMap);
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_commision_vente")
    public Returntype findOne( @RequestParam("id") Long idV_commision_vente ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_commision_venteService.findOne(idV_commision_vente));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_commision_vente")
    public Returntype  delete(@RequestParam("id") Long idV_commision_vente){
        Returntype returntype = new Returntype();
        try {
            v_commision_venteService.delete(idV_commision_vente);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_commision_vente")
    public Returntype  update(@RequestBody V_commision_vente table){
        Returntype returntype = new Returntype();
        try {
            v_commision_venteService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_commision_vente")
    public Returntype  insert(@RequestBody V_commision_vente table){
        Returntype returntype = new Returntype();
        try {
            v_commision_venteService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
