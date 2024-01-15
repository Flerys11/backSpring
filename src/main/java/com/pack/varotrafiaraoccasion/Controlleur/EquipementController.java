package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Equipement;
import com.pack.varotrafiaraoccasion.Service.EquipementService;
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
public class EquipementController {

 private final EquipementService equipementService;
    
    @Autowired
    public EquipementController(EquipementService equipementService){
        this.equipementService= equipementService;
    }

    @GetMapping("/varotrafiaraback/equipements")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,equipementService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/equipement")
    public Returntype findOne( @RequestParam("id") Long idEquipement ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,equipementService.findOne(idEquipement));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/equipement")
    public Returntype  delete(@RequestParam("id") Long idEquipement){
        Returntype returntype = new Returntype();
        try {
            equipementService.delete(idEquipement);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/equipement")
    public Returntype  update(@RequestBody Equipement table){
        Returntype returntype = new Returntype();
        try {
            equipementService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/equipement")
    public Returntype  insert(@RequestBody Equipement table){
        Returntype returntype = new Returntype();
        try {
            equipementService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
