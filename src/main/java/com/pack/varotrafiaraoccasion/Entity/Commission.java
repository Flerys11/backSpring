
package com.pack.varotrafiaraoccasion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.*;

import com.pack.varotrafiaraoccasion.Work.ConnectionPostgres;

import java.sql.*;

@Entity
public class Commission{

    public Commission(){}
        @Id
        @SequenceGenerator(
            name = "commission_sequence",
            sequenceName = "commission_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "commission_sequence"
        )
          Long idcommission;
          Double bornea;
          Double borneb;
          Double pourcentage;
              public void setIdcommission( Long idcommission){
                  this.idcommission=idcommission;
              }
          
              public Long getIdcommission(){
                  return this.idcommission;
              }
              public void setBornea( Double bornea){
                  this.bornea=bornea;
              }
          
              public Double getBornea(){
                  return this.bornea;
              }
              public void setBorneb( Double borneb){
                  this.borneb=borneb;
              }
          
              public Double getBorneb(){
                  return this.borneb;
              }
              public void setPourcentage( Double pourcentage){
                  this.pourcentage=pourcentage;
              }
          
              public Double getPourcentage(){
                  return this.pourcentage;
              }

    public List<Commission> findAllCommissions() {
        List<Commission> result = new ArrayList<>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM commission";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Commission commission = new Commission();
                commission.setIdcommission(resultSet.getLong("idcommission"));
                commission.setBornea(resultSet.getDouble("bornea"));
                commission.setBorneb(resultSet.getDouble("borneb"));
                commission.setPourcentage(resultSet.getDouble("pourcentage"));

                result.add(commission);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public Double getcommission(Double prixdevente){
        List<Commission> table = findAllCommissions();
        for(int i=0;i<table.size();i++){
            if(prixdevente>= table.get(i).getBornea() && prixdevente < table.get(i).getBorneb()){
                return prixdevente*(table.get(i).getPourcentage()/100);
            }
        }
        return 0.0;

    }
   
}
