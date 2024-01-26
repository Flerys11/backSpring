package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Administrateur;
import com.pack.varotrafiaraoccasion.Entity.Client;
import com.pack.varotrafiaraoccasion.Entity.Commission;
import com.pack.varotrafiaraoccasion.Entity.Utilisateur;
import com.pack.varotrafiaraoccasion.Security.Config.AuthenticationService;
import com.pack.varotrafiaraoccasion.Service.AdministrateurService;
import com.pack.varotrafiaraoccasion.Service.ClientService;
import com.pack.varotrafiaraoccasion.Service.V_info_clientService;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.pack.varotrafiaraoccasion.Work.Returntype;

import jakarta.servlet.http.HttpSession;
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
public class AdministrateurController {
        private final ClientService clientService;
        private final AuthenticationService jwtToken;
        private final AuthenticationService service;
        private final AdministrateurService adminService;  
        private final AdministrateurService administrateurService;
    
    

    @PostMapping("/varotrafiaraback/loginback")
    public Returntype connexionfront(@RequestBody Utilisateur utilisateur,HttpSession httpSession){
        Returntype returntype = new Returntype();
        try {
            Administrateur client = adminService.findUser(utilisateur.getPseudo(), utilisateur.getPassword());
            if(client!=null){
                java.util.HashMap<String,Object> hashMap = new HashMap<String,Object>();
                // client.setMotdepasse(null);
                hashMap.put("admin", client);
                hashMap.put("token", jwtToken.authenticate(new AuthenticationRequest(utilisateur.getPseudo(), utilisateur.getPassword())));
                returntype = new Returntype(null,hashMap);
            }else{
                returntype = new Returntype("compte non reconu",null);
            }  
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/administrateurs")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,administrateurService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/administrateur")
    public Returntype findOne( @RequestParam("id") Long idAdministrateur ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,administrateurService.findOne(idAdministrateur));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/administrateur")
    public Returntype  delete(@RequestParam("id") Long idAdministrateur){
        Returntype returntype = new Returntype();
        try {
            administrateurService.delete(idAdministrateur);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/administrateur")
    public Returntype  update(@RequestBody Administrateur table){
        Returntype returntype = new Returntype();
        try {
            administrateurService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/administrateur")
    public Returntype  insert(@RequestBody Administrateur table){
        Returntype returntype = new Returntype();
        try {
            if(table.getIdadministrateur()==null){
                Utilisateur utilisateur = new Utilisateur(null, table.getEmail(), table.getMotdepasse(), null);
                service.registeradmin(utilisateur);
            }
            administrateurService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
