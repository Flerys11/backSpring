package com.pack.varotrafiaraoccasion.Controlleur;
import com.pack.varotrafiaraoccasion.Entity.Client;
import com.pack.varotrafiaraoccasion.Entity.Utilisateur;
import com.pack.varotrafiaraoccasion.Security.Config.AuthenticationService;
import com.pack.varotrafiaraoccasion.Service.ClientService;
import java.text.SimpleDateFormat;
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
    
    // @Autowired
    // public ClientController(ClientService clientService){
    //     this.clientService= clientService;
    // }
    @CrossOrigin(origins = "http://localhost:8100/")
    @PostMapping("/varotrafiaraback/connexion")
    public Returntype connexion(@RequestBody Utilisateur utilisateur,HttpSession httpSession){
        Returntype returntype = new Returntype();
        try {
            System.out.println(utilisateur.getPseudo());
            System.out.println(utilisateur.getPassword());
            Client client = clientService.findUser(utilisateur.getPseudo(), utilisateur.getPassword());
            if(client!=null){
                httpSession.setAttribute("client", client);
                returntype = new Returntype(null,jwtToken.authenticate(new AuthenticationRequest(utilisateur.getPseudo(), utilisateur.getPassword())));
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
            Utilisateur utilisateur = new Utilisateur(null, table.getEmail(), table.getMotdepasse(), null);
            service.register(utilisateur);
            clientService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
