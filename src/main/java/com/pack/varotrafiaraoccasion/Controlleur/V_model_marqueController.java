package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.V_model_marque;
import com.pack.varotrafiaraoccasion.Service.V_model_marqueService;
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
public class V_model_marqueController {

 private final V_model_marqueService v_model_marqueService;
    
    @Autowired
    public V_model_marqueController(V_model_marqueService v_model_marqueService){
        this.v_model_marqueService= v_model_marqueService;
    }

    @GetMapping("/varotrafiaraback/v_model_marques")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_model_marqueService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_model_marque")
    public Returntype findOne( @RequestParam("id") Long idV_model_marque ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_model_marqueService.findOne(idV_model_marque));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_model_marque")
    public Returntype  delete(@RequestParam("id") Long idV_model_marque){
        Returntype returntype = new Returntype();
        try {
            v_model_marqueService.delete(idV_model_marque);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_model_marque")
    public Returntype  update(@RequestBody V_model_marque table){
        Returntype returntype = new Returntype();
        try {
            v_model_marqueService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_model_marque")
    public Returntype  insert(@RequestBody V_model_marque table){
        Returntype returntype = new Returntype();
        try {
            v_model_marqueService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
