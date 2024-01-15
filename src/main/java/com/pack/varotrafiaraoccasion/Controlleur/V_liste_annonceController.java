package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import com.pack.varotrafiaraoccasion.Service.V_liste_annonceService;
import java.text.SimpleDateFormat;
import com.pack.varotrafiaraoccasion.Work.Returntype;
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

@RestController
@RequestMapping
public class V_liste_annonceController {

 private final V_liste_annonceService v_liste_annonceService;
    
    @Autowired
    public V_liste_annonceController(V_liste_annonceService v_liste_annonceService){
        this.v_liste_annonceService= v_liste_annonceService;
    }

    @GetMapping("/varotrafiaraback/v_liste_annonces")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype findOne( @RequestParam("id") Long idV_liste_annonce ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findOne(idV_liste_annonce));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  delete(@RequestParam("id") Long idV_liste_annonce){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.delete(idV_liste_annonce);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  update(@RequestBody V_liste_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  insert(@RequestBody V_liste_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
