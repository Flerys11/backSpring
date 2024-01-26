package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import com.pack.varotrafiaraoccasion.Service.CaracteristiqueService;
import com.pack.varotrafiaraoccasion.Service.V_liste_annonceService;
import java.text.SimpleDateFormat;

import com.pack.varotrafiaraoccasion.Work.Requete;
import com.pack.varotrafiaraoccasion.Work.Returntype;

import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class V_liste_annonceController {

    private final V_liste_annonceService v_liste_annonceService;
    private final CaracteristiqueService caracteristiqueService;
   

    @PostMapping("/varotrafiaraback/v_liste_annonceshistorique")
    public Returntype findAllHistorique(@RequestBody Long id){
        System.out.println("historique");
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllHistorique(id));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_liste_annoncesfront")
    public Returntype findAllFront(@RequestBody Long id){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllByIdclient(id));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/varotrafiaraback/v_liste_annoncesfavorie")
    public Returntype findListeFavorie(@RequestBody Long id){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllListeAnnonceFavorie(id));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_liste_annoncesfactorid")
    public Returntype findAllFactorerid(@RequestBody Long id){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllFactorer(id));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_liste_annoncesfactor")
    public Returntype findAllFactorer(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllFactorer());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_liste_annoncesvalidee")
    public Returntype findAllvalidee(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllListeAnnonce());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_liste_annonces")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllAdmin());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
   
    @GetMapping("/varotrafiaraback/test")
    public Returntype test( ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findAllin());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype findOne( @RequestParam("id") Long idV_liste_annonce ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_liste_annonceService.findOne(idV_liste_annonce));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  delete(@RequestParam("id") Long idV_liste_annonce){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.delete(idV_liste_annonce);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  update(@RequestBody V_liste_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_liste_annonce")
    public Returntype  insert(@RequestBody V_liste_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_liste_annonceService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_liste_annonceupdate")
    public Returntype  updateinsert(@RequestBody V_liste_annonce table){
        Returntype returntype = new Returntype();
        try {
            System.out.println("idcaracteristique :"+table.getIdcaracteristique());
            Caracteristique caracteristique = new Caracteristique(table.getIdcaracteristique(), table.getIdetat(),table.getIdclient(), table.getIdboitedevitesse(), table.getIdmarque(), table.getIdmodel(), table.getIdenergie(), table.getIdtypevehicule(), table.getIdlocalisation(),table.getAutonomie(), table.getKilometrage(), table.getAnneedefabrication(), table.getAnnemodel(), table.getCapacite(),table.getConsomation(), table.getPrixdevente(), table.getIdcouleur(), table.getNbrporte(), table.getNbrplace(), table.getLongueur(), table.getLargeur(), table.getHauteur(), table.getVolumeducoffre(), table.getCommission());
            caracteristiqueService.update(caracteristique);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
