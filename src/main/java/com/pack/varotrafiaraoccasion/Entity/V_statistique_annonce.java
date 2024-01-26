
package com.pack.varotrafiaraoccasion.Entity;

import com.pack.varotrafiaraoccasion.Work.ConnectionPostgres;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.*;
import java.sql.*;

@Entity
public class V_statistique_annonce{

    public V_statistique_annonce(){}
        @Id
        @SequenceGenerator(
            name = "v_statistique_annonce_sequence",
            sequenceName = "v_statistique_annonce_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_statistique_annonce_sequence"
        )
          Long idetat;
          Long count;
          Double annee;
          Double mois;
              public void setIdetat( Long idetat){
                  this.idetat=idetat;
              }
          
              public Long getIdetat(){
                  return this.idetat;
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
              public static List<V_statistique_annonce> findAllStatistiqueAnnonce() {
                    List<V_statistique_annonce> result = new ArrayList<>();

                    try {
                        ConnectionPostgres con = new ConnectionPostgres();
                        Connection connection = con.getconnexion();
                        Statement statement = connection.createStatement();
                        String query = "SELECT * FROM v_statistique_annonce";
                        System.out.println(query);
                        ResultSet resultSet = statement.executeQuery(query);

                        while (resultSet.next()) {
                            V_statistique_annonce statistique = new V_statistique_annonce();
                            statistique.setIdetat(resultSet.getLong("idetat"));
                            statistique.setCount(resultSet.getLong("nbr"));
                            statistique.setAnnee(resultSet.getDouble("annee"));
                            statistique.setMois(resultSet.getDouble("mois"));
                            
                            // Ajoutez d'autres attributions selon les colonnes de votre table

                            result.add(statistique);
                        }

                        resultSet.close();
                        statement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return result;
            }

}

