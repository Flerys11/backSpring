package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Historiqueetat;
import com.pack.varotrafiaraoccasion.Service.HistoriqueetatService;
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
public class HistoriqueetatController {

 private final HistoriqueetatService historiqueetatService;
    
    @Autowired
    public HistoriqueetatController(HistoriqueetatService historiqueetatService){
        this.historiqueetatService= historiqueetatService;
    }

    @GetMapping("/varotrafiaraback/historiqueetats")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,historiqueetatService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/historiqueetat")
    public Returntype findOne( @RequestParam("id") Long idHistoriqueetat ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,historiqueetatService.findOne(idHistoriqueetat));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/historiqueetat")
    public Returntype  delete(@RequestParam("id") Long idHistoriqueetat){
        Returntype returntype = new Returntype();
        try {
            historiqueetatService.delete(idHistoriqueetat);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/historiqueetat")
    public Returntype  update(@RequestBody Historiqueetat table){
        Returntype returntype = new Returntype();
        try {
            historiqueetatService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/historiqueetat")
    public Returntype  insert(@RequestBody Historiqueetat table){
        Returntype returntype = new Returntype();
        try {
            historiqueetatService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
