package com.pack.varotrafiaraoccasion.Controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import com.pack.varotrafiaraoccasion.Security.Config.LogoutService;
import com.pack.varotrafiaraoccasion.Entity.Utilisateur;
import com.pack.varotrafiaraoccasion.Security.Config.AuthenticationService;
import com.pack.varotrafiaraoccasion.Work.Returntype;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

   private final AuthenticationService service;
   

  @PostMapping("/varotrafiaraback/register")
  public ResponseEntity<AuthenticationResponse> register( @RequestBody Utilisateur request) {
    System.out.println("hello");
    return ResponseEntity.ok(service.register(request));
  }

  // @PostMapping("/authenticate")
  // public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
  //   return ResponseEntity.ok(service.authenticate(request));
  // }

  
  

  // @PostMapping("/refresh-token")
  // public void refreshToken(HttpServletRequest request,HttpServletResponse response) throws IOException {
  //   service.refreshToken(request, response);
  // }
  // conecte
    
}
