package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Detaillecaequipement;
import com.pack.varotrafiaraoccasion.Service.DetaillecaequipementService;
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
public class DetaillecaequipementController {

 private final DetaillecaequipementService detaillecaequipementService;
    
    @PostMapping("/varotrafiaraback/detaillecaequipementstring")
    public Returntype  insertstring(@RequestParam("equipement") String equipement,HttpSession httpSession){
        Returntype returntype = new Returntype();
        try {
            httpSession.setAttribute("equipement", equipement);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }


    @Autowired
    public DetaillecaequipementController(DetaillecaequipementService detaillecaequipementService){
        this.detaillecaequipementService= detaillecaequipementService;
    }

    @GetMapping("/varotrafiaraback/detaillecaequipements")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,detaillecaequipementService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/detaillecaequipement")
    public Returntype findOne( @RequestParam("id") Long idDetaillecaequipement ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,detaillecaequipementService.findOne(idDetaillecaequipement));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/detaillecaequipement")
    public Returntype  delete(@RequestParam("id") Long idDetaillecaequipement){
        Returntype returntype = new Returntype();
        try {
            detaillecaequipementService.delete(idDetaillecaequipement);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/detaillecaequipement")
    public Returntype  update(@RequestBody Detaillecaequipement table){
        Returntype returntype = new Returntype();
        try {
            detaillecaequipementService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/detaillecaequipement")
    public Returntype  insert(@RequestBody Detaillecaequipement table){
        Returntype returntype = new Returntype();
        try {
            detaillecaequipementService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
