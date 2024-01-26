package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Client;
import com.pack.varotrafiaraoccasion.Entity.Clientdateinscription;
import com.pack.varotrafiaraoccasion.Entity.Utilisateur;
import com.pack.varotrafiaraoccasion.Security.Config.AuthenticationService;
import com.pack.varotrafiaraoccasion.Service.ClientService;
import com.pack.varotrafiaraoccasion.Service.ClientdateinscriptionService;
import com.pack.varotrafiaraoccasion.Service.V_info_clientService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.pack.varotrafiaraoccasion.Work.Returntype;

import ch.qos.logback.classic.pattern.Util;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ClientController {

 private final ClientService clientService;
 private final AuthenticationService jwtToken;
 private final AuthenticationService service;
 private final V_info_clientService info_clientService;
 private final ClientdateinscriptionService clientdateinscriptionService;
    
    // @Autowired
    // public ClientController(ClientService clientService){
    //     this.clientService= clientService;
    // }
    @PostMapping("/varotrafiaraback/loginfront")
    public Returntype connexionfront(@RequestBody Utilisateur utilisateur,HttpSession httpSession){
        Returntype returntype = new Returntype();
        try {
            Client client = clientService.findUser(utilisateur.getPseudo(), utilisateur.getPassword());
            if(client!=null){
                java.util.HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("client", info_clientService.findByIdclient(client.getIdclient()).get());
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


    @CrossOrigin(origins = "http://localhost:8100/")
    @PostMapping("/varotrafiaraback/connexion")
    public Returntype connexion(@RequestBody Utilisateur utilisateur,HttpSession httpSession){
        System.out.println("connexion client");
        Returntype returntype = new Returntype();
        try {
            Client client = clientService.findUser(utilisateur.getPseudo(), utilisateur.getPassword());
            if(client!=null){
                System.out.println("Nom client "+client.getNomclient());
                httpSession.setAttribute("client", client);
                java.util.HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("client", client);
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

    @GetMapping("/varotrafiaraback/clients")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,clientService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/varotrafiaraback/client")
    public Returntype findOne( @RequestParam("id") Long idClient ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,clientService.findOne(idClient));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/client")
    public Returntype  delete(@RequestParam("id") Long idClient){
        Returntype returntype = new Returntype();
        try {
            clientService.delete(idClient);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/client")
    public Returntype  update(@RequestBody Client table){
        Returntype returntype = new Returntype();
        try {
            clientService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/varotrafiaraback/client")
    public Returntype  insert(@RequestBody Client table){
        Returntype returntype = new Returntype();
        try {
            if(table.getIdclient()==null){
                Utilisateur utilisateur = new Utilisateur(null, table.getEmail(), table.getMotdepasse(), null);
                service.register(utilisateur);
            }
            clientService.update(table);
            Clientdateinscription clientdateinscription =   new Clientdateinscription(null, table.getIdclient(), new Date());
            clientdateinscriptionService.update(clientdateinscription);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
