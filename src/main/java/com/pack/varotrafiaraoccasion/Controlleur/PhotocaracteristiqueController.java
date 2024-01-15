package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Photocaracteristique;
import com.pack.varotrafiaraoccasion.Service.PhotocaracteristiqueService;
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
public class PhotocaracteristiqueController {

 private final PhotocaracteristiqueService photocaracteristiqueService;
    
    @Autowired
    public PhotocaracteristiqueController(PhotocaracteristiqueService photocaracteristiqueService){
        this.photocaracteristiqueService= photocaracteristiqueService;
    }

    @GetMapping("/varotrafiaraback/photocaracteristiques")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,photocaracteristiqueService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/photocaracteristique")
    public Returntype findOne( @RequestParam("id") Long idPhotocaracteristique ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,photocaracteristiqueService.findOne(idPhotocaracteristique));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/photocaracteristique")
    public Returntype  delete(@RequestParam("id") Long idPhotocaracteristique){
        Returntype returntype = new Returntype();
        try {
            photocaracteristiqueService.delete(idPhotocaracteristique);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/photocaracteristique")
    public Returntype  update(@RequestBody Photocaracteristique table){
        Returntype returntype = new Returntype();
        try {
            photocaracteristiqueService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/photocaracteristique")
    public Returntype  insert(@RequestBody Photocaracteristique table){
        Returntype returntype = new Returntype();
        try {
            photocaracteristiqueService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
