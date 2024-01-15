package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Localisation;
import com.pack.varotrafiaraoccasion.Service.LocalisationService;
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
public class LocalisationController {

 private final LocalisationService localisationService;
    
    @Autowired
    public LocalisationController(LocalisationService localisationService){
        this.localisationService= localisationService;
    }

    @GetMapping("/varotrafiaraback/localisations")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,localisationService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/localisation")
    public Returntype findOne( @RequestParam("id") Long idLocalisation ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,localisationService.findOne(idLocalisation));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/localisation")
    public Returntype  delete(@RequestParam("id") Long idLocalisation){
        Returntype returntype = new Returntype();
        try {
            localisationService.delete(idLocalisation);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/localisation")
    public Returntype  update(@RequestBody Localisation table){
        Returntype returntype = new Returntype();
        try {
            localisationService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/localisation")
    public Returntype  insert(@RequestBody Localisation table){
        Returntype returntype = new Returntype();
        try {
            localisationService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
