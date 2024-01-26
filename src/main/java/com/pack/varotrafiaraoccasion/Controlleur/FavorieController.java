package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Favorie;
import com.pack.varotrafiaraoccasion.Service.FavorieService;
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
public class FavorieController {

 private final FavorieService favorieService;
    
    @Autowired
    public FavorieController(FavorieService favorieService){
        this.favorieService= favorieService;
    }

    @GetMapping("/varotrafiaraback/favories")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,favorieService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/favorie")
    public Returntype findOne( @RequestParam("id") Long idFavorie ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,favorieService.findOne(idFavorie));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/favorie")
    public Returntype  delete(@RequestParam("id") Long idFavorie){
        Returntype returntype = new Returntype();
        try {
            favorieService.delete(idFavorie);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/favorie")
    public Returntype  update(@RequestBody Favorie table){
        Returntype returntype = new Returntype();
        try {
            favorieService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/favorie")
    public Returntype  insert(@RequestBody Favorie table){ 
        Returntype returntype = new Returntype();
        try {
            java.util.Optional<Favorie> fav = favorieService.findfavorie(table.getIdclient(), table.getIdfcaracteristique());
            fav.ifPresentOrElse(
                existingFavorie -> {
                    favorieService.delete(existingFavorie.getIdfavorie());
                },
                () -> {
                    System.out.println("insert value");
                    favorieService.update(table);
                }
            );

            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            System.out.println("exeption :"+e);
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
