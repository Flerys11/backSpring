
package com.pack.varotrafiaraoccasion.Entity;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.varotrafiaraoccasion.Work.ConnectionPostgres;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.*;
import java.sql.*;

@Entity
public class V_detail_statistique_annonce{

    public V_detail_statistique_annonce(){}
        @Id
        @SequenceGenerator(
            name = "v_detail_statistique_annonce_sequence",
            sequenceName = "v_detail_statistique_annonce_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_detail_statistique_annonce_sequence"
        )
          Long idetat;
          String nommarque;
          Long idmarque;
          Long count;
          Double annee;
          Double mois;
              public void setIdetat( Long idetat){
                  this.idetat=idetat;
              }
          
              public Long getIdetat(){
                  return this.idetat;
              }
              public void setNommarque( String nommarque){
                  this.nommarque=nommarque;
              }
          
              public String getNommarque(){
                  return this.nommarque;
              }
              public void setIdmarque( Long idmarque){
                  this.idmarque=idmarque;
              }
          
              public Long getIdmarque(){
                  return this.idmarque;
              }
              public void setCount( Long count){
                  this.count=count;
              }
          
              public Long getCount(){
                  return this.count;
              }
              public void setAnnee( Double annee){
                  this.annee=annee;
              }
          
              public Double getAnnee(){
                  return this.annee;
              }
              public void setMois( Double mois){
                  this.mois=mois;
              }
          
              public Double getMois(){
                  return this.mois;
              }
              public List<V_detail_statistique_annonce> findAll() {
                    List<V_detail_statistique_annonce> resultList = new ArrayList<>();
                    Historiqueetat historiqueetat = new Historiqueetat();
                    List<Historiqueetat> liste = historiqueetat.findAll();
                     try {
                        ConnectionPostgres con = new ConnectionPostgres();
                        Connection connection = con.getconnexion();
                        Statement statement = connection.createStatement();
                        String query = "SELECT * FROM v_detail_statistique_annonce";
                        ResultSet resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            V_detail_statistique_annonce vDetailStatistiqueAnnonce = new V_detail_statistique_annonce();
                            vDetailStatistiqueAnnonce.setIdetat(resultSet.getLong("idetat"));
                            vDetailStatistiqueAnnonce.setNommarque(resultSet.getString("nommarque"));
                            vDetailStatistiqueAnnonce.setIdmarque(resultSet.getLong("idmarque"));
                            vDetailStatistiqueAnnonce.setCount(historiqueetat.getVraiCount(resultSet.getLong("idetat"), resultSet.getDouble("mois"), resultSet.getDouble("annee"), resultSet.getLong("idmarque"), liste));
                            vDetailStatistiqueAnnonce.setAnnee(resultSet.getDouble("annee"));
                            vDetailStatistiqueAnnonce.setMois(resultSet.getDouble("mois"));

                            resultList.add(vDetailStatistiqueAnnonce);
                        }
                        
                    } catch (SQLException e) {
                        e.printStackTrace(); // Gestion des exceptions à améliorer selon votre besoin
                    }

            return resultList;
        }
}
