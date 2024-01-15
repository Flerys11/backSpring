package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Boitdevitesse;
import com.pack.varotrafiaraoccasion.Entity.Couleur;
import com.pack.varotrafiaraoccasion.Service.BoitdevitesseService;
import com.pack.varotrafiaraoccasion.Service.CouleurService;
import com.pack.varotrafiaraoccasion.Service.EnergieService;
import com.pack.varotrafiaraoccasion.Service.EquipementService;
import com.pack.varotrafiaraoccasion.Service.EtatService;
import com.pack.varotrafiaraoccasion.Service.GenreService;
import com.pack.varotrafiaraoccasion.Service.LocalisationService;
import com.pack.varotrafiaraoccasion.Service.MarqueService;
import com.pack.varotrafiaraoccasion.Service.TypevehiculeService;
import com.pack.varotrafiaraoccasion.Service.V_model_marqueService;

import java.text.SimpleDateFormat;
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
public class InitialisationDonneReact {
    private final MarqueService marqueService;
    private final EtatService etatService;
    private final BoitdevitesseService boitdevitesseService;
    private final V_model_marqueService v_model_marqueService;
    private final EnergieService energieService;
    private final TypevehiculeService typevehiculeService;
    private final LocalisationService localisationService;
    private final CouleurService couleurService;
    private final EquipementService equipementService;
    private final GenreService genreService;

    @GetMapping("/varotrafiaraback/initialisation")
    public Returntype init(){
        Returntype returntype = new Returntype();
        try {
            java.util.HashMap<String,Object> hashMap = new java.util.HashMap<String,Object>();
            hashMap.put("marque", marqueService.findAll());
            hashMap.put("etat", etatService.findAll());
            hashMap.put("boitdevitesse", boitdevitesseService.findAll());
            hashMap.put("model", v_model_marqueService.findAll());
            hashMap.put("energie", energieService.findAll());
            hashMap.put("typevehicule", typevehiculeService.findAll());
            hashMap.put("localisation", localisationService.findAll());
            hashMap.put("coleur", couleurService.findAll());
            hashMap.put("equipement", equipementService.findAll());
            hashMap.put("genre", genreService.findAll());
            returntype = new Returntype(null,hashMap);
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
