
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.sql.*;
import java.util.*;

import com.pack.varotrafiaraoccasion.Work.ConnectionPostgres;

@Entity
public class V_inscription{

    public V_inscription(){}
        @Id
        @SequenceGenerator(
            name = "v_inscription_sequence",
            sequenceName = "v_inscription_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_inscription_sequence"
        )
          Long nbr;
          Double annee;
          Double mois;
              public void setNbr( Long nbr){
                  this.nbr=nbr;
              }
          
              public Long getNbr(){
                  return this.nbr;
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
            public List<V_inscription> findAll() throws SQLException {
                List<V_inscription> vInscriptions = new ArrayList<>();

                    ConnectionPostgres con = new ConnectionPostgres();
                    Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM v_inscription";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_inscription vInscription = new V_inscription();
                        vInscription.setNbr(resultSet.getLong("nbr"));
                        vInscription.setAnnee(resultSet.getDouble("annee"));
                        vInscription.setMois(resultSet.getDouble("mois"));
                        vInscriptions.add(vInscription);
                    }
    

                return vInscriptions;
            }
}
