package com.pack.varotrafiaraoccasion.Controlleur;

import com.pack.varotrafiaraoccasion.Entity.Marque;
import com.pack.varotrafiaraoccasion.Service.MarqueService;
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
public class MarqueController {

 private final MarqueService marqueService;
    
    @Autowired
    public MarqueController(MarqueService marqueService){
        this.marqueService= marqueService;
    }

    @GetMapping("/varotrafiaraback/marques")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,marqueService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/marque")
    public Returntype findOne( @RequestParam("id") Long idMarque ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,marqueService.findOne(idMarque));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/marque")
    public Returntype  delete(@RequestParam("id") Long idMarque){
        Returntype returntype = new Returntype();
        try {
            marqueService.delete(idMarque);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/marque")
    public Returntype  update(@RequestBody Marque table){
        Returntype returntype = new Returntype();
        try {
            marqueService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/marque")
    public Returntype  insert(@RequestBody Marque table){
        Returntype returntype = new Returntype();
        try {
            marqueService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
