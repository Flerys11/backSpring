package com.pack.varotrafiaraoccasion.Controlleur;

import com.pack.varotrafiaraoccasion.Work.Returntype;
import com.pack.varotrafiaraoccasion.Service.TypevehiculeService;
import java.text.SimpleDateFormat;
import com.pack.varotrafiaraoccasion.Entity.Typevehicule;
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
public class TypevehiculeController {

 private final TypevehiculeService typevehiculeService;
    
    @Autowired
    public TypevehiculeController(TypevehiculeService typevehiculeService){
        this.typevehiculeService= typevehiculeService;
    }

    @GetMapping("/varotrafiaraback/typevehicules")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,typevehiculeService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/typevehicule")
    public Returntype findOne( @RequestParam("id") Long idTypevehicule ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,typevehiculeService.findOne(idTypevehicule));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/typevehicule")
    public Returntype  delete(@RequestParam("id") Long idTypevehicule){
        Returntype  returntype = new Returntype();
        try {
            typevehiculeService.delete(idTypevehicule);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/typevehicule")
    public Returntype  update(@RequestBody Typevehicule table){
        Returntype returntype = new Returntype();
        try {
            typevehiculeService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/typevehicule")
    public Returntype  insert(@RequestBody Typevehicule table){
        Returntype returntype = new Returntype();
        try {
            typevehiculeService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
