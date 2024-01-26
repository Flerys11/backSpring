package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Clientdateinscription;
import com.pack.varotrafiaraoccasion.Service.ClientdateinscriptionService;
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
public class ClientdateinscriptionController {

 private final ClientdateinscriptionService clientdateinscriptionService;
    
    @Autowired
    public ClientdateinscriptionController(ClientdateinscriptionService clientdateinscriptionService){
        this.clientdateinscriptionService= clientdateinscriptionService;
    }

    @GetMapping("/varotrafiaraback/clientdateinscriptions")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,clientdateinscriptionService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/clientdateinscription")
    public Returntype findOne( @RequestParam("id") Long idClientdateinscription ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,clientdateinscriptionService.findOne(idClientdateinscription));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/clientdateinscription")
    public Returntype  delete(@RequestParam("id") Long idClientdateinscription){
        Returntype returntype = new Returntype();
        try {
            clientdateinscriptionService.delete(idClientdateinscription);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/clientdateinscription")
    public Returntype  update(@RequestBody Clientdateinscription table){
        Returntype returntype = new Returntype();
        try {
            clientdateinscriptionService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/clientdateinscription")
    public Returntype  insert(@RequestBody Clientdateinscription table){
        Returntype returntype = new Returntype();
        try {
            clientdateinscriptionService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
