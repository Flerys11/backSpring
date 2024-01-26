package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Historiqueetat;
import com.pack.varotrafiaraoccasion.Entity.V_view_annonce;
import com.pack.varotrafiaraoccasion.Repository.HistoriqueetatRepository;
import com.pack.varotrafiaraoccasion.Service.V_view_annonceService;
import java.text.SimpleDateFormat;

import com.pack.varotrafiaraoccasion.Work.Requete;
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
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import com.pack.varotrafiaraoccasion.Work.UpdateEtat;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor 
public class V_view_annonceController {

    int borneA=0;
    int borneB=0;

    private final V_view_annonceService v_view_annonceService;
    private final HistoriqueetatRepository historiqueetatRepository;
    // @Autowired
    // public V_view_annonceController(V_view_annonceService v_view_annonceService){
    //     this.v_view_annonceService= v_view_annonceService;
    // }
    // modif_statu(Long id,Long idcaractere)
    
    @PostMapping("/varotrafiaraback/updateetatannonce")
    public Returntype updateEtat(@RequestBody UpdateEtat  updateEtat){
        Returntype returntype = new Returntype();
        try {
            Historiqueetat historiqueetat = new Historiqueetat(null, updateEtat.getIdcaracteristique(), updateEtat.getIdetat(), new java.util.Date());
            historiqueetatRepository.save(historiqueetat);
            Requete.modif_statu(updateEtat.getIdetat(), updateEtat.getIdcaracteristique());
            returntype = new Returntype(null,"modifi");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_view_annonceallview")
    public Returntype allView(@RequestBody Long  idclient){
        System.out.println("idclient precedent:"+idclient);
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_view_annonceService.allView(idclient));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_view_annoncesuivant")
    public Returntype suivant(@RequestBody Long idclient){
        System.out.println("idclient suivant:"+idclient);
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_view_annonceService.pagination(borneB,idclient));
            borneA=borneA+5;
            borneB=borneB+5;
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/varotrafiaraback/v_view_annonceprecedent")
    public Returntype precedent(@RequestParam("id") Long  idclient){
         System.out.println("idclient precedent:"+idclient);
        Returntype returntype = new Returntype();

        try {
            if(borneA>5){
                borneA=borneA-5;
                borneB=borneB-5;
            }
            returntype = new Returntype(null,v_view_annonceService.pagination(borneA,idclient));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
  
    @GetMapping("/varotrafiaraback/v_view_annonces")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            // returntype = new Returntype(null,v_view_annonceService.findAll());
            returntype = new Returntype(null,Requete.findAllrequeteAnnonce());
            
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/v_view_annonce")
    public Returntype findOne( @RequestParam("id") Long idV_view_annonce ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,v_view_annonceService.findOne(idV_view_annonce));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/v_view_annonce")
    public Returntype  delete(@RequestParam("id") Long idV_view_annonce){
        Returntype returntype = new Returntype();
        try {
            v_view_annonceService.delete(idV_view_annonce);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/v_view_annonce")
    public Returntype  update(@RequestBody V_view_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_view_annonceService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/v_view_annonce")
    public Returntype  insert(@RequestBody V_view_annonce table){
        Returntype returntype = new Returntype();
        try {
            v_view_annonceService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
