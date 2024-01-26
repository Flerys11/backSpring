package com.pack.varotrafiaraoccasion.Controlleur;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import com.pack.varotrafiaraoccasion.Entity.Commission;
import com.pack.varotrafiaraoccasion.Entity.Detaillecaequipement;
import com.pack.varotrafiaraoccasion.Entity.Photocaracteristique;
import com.pack.varotrafiaraoccasion.Service.CaracteristiqueService;
import com.pack.varotrafiaraoccasion.Service.DetaillecaequipementService;
import com.pack.varotrafiaraoccasion.Service.PhotocaracteristiqueService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import com.pack.varotrafiaraoccasion.Work.Returntype;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
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
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PhotocaracteristiqueController {

    private final ObjectMapper objectMapper;
    private final PhotocaracteristiqueService photocaracteristiqueService;
    private final CaracteristiqueService caracteristiqueService;
    private final DetaillecaequipementService detaillecaequipementService;
    // @Autowired
    // public PhotocaracteristiqueController(PhotocaracteristiqueService photocaracteristiqueService){
    //     this.photocaracteristiqueService= photocaracteristiqueService;
    // }

    
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
    @Transactional 
    public Returntype  insert(@RequestParam("images[]") MultipartFile[] files,@RequestParam("equipements") String equipements,@RequestParam("caracteristique") String caracteristi){
        Returntype returntype = new Returntype();
        try {
            Caracteristique caracteristique=objectMapper.readValue(caracteristi, Caracteristique.class);
            DataAnnonce table = new DataAnnonce(files, caracteristique, objectMapper.readValue(equipements, Long[].class));
            
            returntype = new Returntype(null,uploadMultipleFiles(table.getImages()));
          
            System.out.println("caracteriswtique: "+caracteristique.getAutonomie());
            caracteristique.setCommission(new Commission().getcommission(caracteristique.getPrixdevente()));
            caracteristiqueService.update(caracteristique);

            Long[] listeequipement = table.getEquipements();
           
            for(int i=0;i<listeequipement.length;i++){
                Detaillecaequipement detaillecaequipement = new Detaillecaequipement(null, caracteristique.getIdcaracteristique(),listeequipement[i]);
                detaillecaequipementService.update(detaillecaequipement);
            }
            for(int i=0;i<files.length;i++){
                Photocaracteristique photo = new Photocaracteristique(null,caracteristique.getIdcaracteristique(), files[i].getOriginalFilename());
                photocaracteristiqueService.update(photo);
            }
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    //enregistrement de l image
    @Transactional 
    public String uploadMultipleFiles(MultipartFile[] files) {
        try {
            String uploadDirectory = "./src/main/resources/static/images"; // Répertoire de stockage des fichiers
            // Créer le répertoire s'il n'existe pas
            Path directoryPath = Paths.get(uploadDirectory);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            // Enregistrer chaque fichier dans le répertoire
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                System.out.println("name file"+fileName);
                Path filePath = Paths.get(uploadDirectory, fileName);
                Files.write(filePath, file.getBytes());
            }
            
            return "Tous les fichiers ont été enregistrés avec succès.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur s'est produite lors de l'enregistrement des fichiers.";
        }
    }

    public String uploadOneMultipleFiles(MultipartFile file) {
        try {
            String uploadDirectory = "./src/main/resources/static/images"; // Répertoire de stockage des fichiers
            // Créer le répertoire s'il n'existe pas
            Path directoryPath = Paths.get(uploadDirectory);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            // Enregistrer chaque fichier dans le répertoire
            String fileName = file.getOriginalFilename();
            System.out.println("name file"+fileName);
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.write(filePath, file.getBytes());
            return "le fichier a été enregistrés avec succès.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur s'est produite lors de l'enregistrement des fichiers.";
        }
    }
    //modification image detaille
    @PostMapping("/varotrafiaraback/photocaracteristiqueupdate")
    @Transactional 
    public Returntype  insert(@RequestParam("images") MultipartFile file,@RequestParam("photocaracteristique") String photocaracteristique){
        Returntype returntype = new Returntype();
        try {
            Photocaracteristique photocaracteristiqueupdate= objectMapper.readValue(photocaracteristique, Photocaracteristique.class);
            returntype = new Returntype(null,uploadOneMultipleFiles(file));
            photocaracteristiqueupdate.setNomimage(file.getOriginalFilename());
            photocaracteristiqueService.update(photocaracteristiqueupdate);
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    //fin modification imagedetaille
}
