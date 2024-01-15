package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import com.pack.varotrafiaraoccasion.Service.CaracteristiqueService;
import java.text.SimpleDateFormat;
import com.pack.varotrafiaraoccasion.Work.Returntype;

import jakarta.servlet.http.HttpSession;

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
public class CaracteristiqueController {

 private final CaracteristiqueService caracteristiqueService;
    
    @Autowired
    public CaracteristiqueController(CaracteristiqueService caracteristiqueService){
        this.caracteristiqueService= caracteristiqueService;
    }

    @GetMapping("/varotrafiaraback/caracteristiques")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,caracteristiqueService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/caracteristique")
    public Returntype findOne( @RequestParam("id") Long idCaracteristique ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,caracteristiqueService.findOne(idCaracteristique));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/caracteristique")
    public Returntype  delete(@RequestParam("id") Long idCaracteristique){
        Returntype returntype = new Returntype();
        try {
            caracteristiqueService.delete(idCaracteristique);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/caracteristique")
    public Returntype  update(@RequestBody Caracteristique table){
        Returntype returntype = new Returntype();
        try {
            caracteristiqueService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/caracteristique")
    public Returntype  insert(@RequestBody Caracteristique table,HttpSession httpSession){
        httpSession.setAttribute("caracteristique", table);
        Returntype returntype = new Returntype();
        try {
            caracteristiqueService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
