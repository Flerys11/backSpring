package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Couleur;
import com.pack.varotrafiaraoccasion.Service.CouleurService;
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
public class CouleurController {

 private final CouleurService couleurService;
    
    @Autowired
    public CouleurController(CouleurService couleurService){
        this.couleurService= couleurService;
    }

    @GetMapping("/varotrafiaraback/couleurs")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,couleurService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/couleur")
    public Returntype findOne( @RequestParam("id") Long idCouleur ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,couleurService.findOne(idCouleur));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/couleur")
    public Returntype  delete(@RequestParam("id") Long idCouleur){
        Returntype returntype = new Returntype();
        try {
            couleurService.delete(idCouleur);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/couleur")
    public Returntype  update(@RequestBody Couleur table){
        Returntype returntype = new Returntype();
        try {
            couleurService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/couleur")
    public Returntype  insert(@RequestBody Couleur table){
        Returntype returntype = new Returntype();
        try {
            couleurService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
