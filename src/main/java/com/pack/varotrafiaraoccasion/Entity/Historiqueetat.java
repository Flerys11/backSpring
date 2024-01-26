
package com.pack.varotrafiaraoccasion.Entity;

import java.util.Date;

import com.pack.varotrafiaraoccasion.Work.ConnectionPostgres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.*;
import java.sql.*;
import jakarta.persistence.Transient;

@Entity
public class Historiqueetat{

    public Historiqueetat(){}
        @Id
        @SequenceGenerator(
            name = "historiqueetat_sequence",
            sequenceName = "historiqueetat_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "historiqueetat_sequence"
        )
          Long idhistoriqueetat;
          Long idcaracteristique;
          Long idetat;
          @Transient
          Double anne;
          @Transient
          Double mois;
          @Transient
          Long idmaque;
          
        public Double getAnne() {
            return anne;
        }

        public void setAnne(Double anne) {
            this.anne = anne;
        }

        public Double getMois() {
            return mois;
        }

        public void setMois(Double mois) {
            this.mois = mois;
        }
        @Column(columnDefinition = "DATE")
          java.util.Date date;
              public void setIdhistoriqueetat( Long idhistoriqueetat){
                  this.idhistoriqueetat=idhistoriqueetat;
              }
          
              public Long getIdhistoriqueetat(){
                  return this.idhistoriqueetat;
              }
              public void setIdcaracteristique( Long idcaracteristique){
                  this.idcaracteristique=idcaracteristique;
              }
          
              public Long getIdcaracteristique(){
                  return this.idcaracteristique;
              }
              public void setIdetat( Long idetat){
                  this.idetat=idetat;
              }
          
              public Long getIdetat(){
                  return this.idetat;
              }
              public void setDate( java.util.Date date){
                  this.date=date;
              }
          
              public java.util.Date getDate(){
                  return this.date;
              }

            public Historiqueetat(Long idhistoriqueetat, Long idcaracteristique, Long idetat, Date date) {
                this.idhistoriqueetat = idhistoriqueetat;
                this.idcaracteristique = idcaracteristique;
                this.idetat = idetat;
                this.date = date;
            }
            public List<Historiqueetat> findAll() {
                    List<Historiqueetat> resultList = new ArrayList<>();

                     try {
                        ConnectionPostgres con = new ConnectionPostgres();
                        Connection connection = con.getconnexion();
                        Statement statement = connection.createStatement();
                        String query = "select idfmarque,idhistoriqueetat,historiqueetat.idcaracteristique,idetat,date,EXTRACT(YEAR FROM date) AS annee, EXTRACT(MONTH FROM date) AS mois from historiqueetat join caracteristique on historiqueetat.idcaracteristique=caracteristique.idcaracteristique;";
                        ResultSet resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            // System.out.println("finadall");
                            Long idhistoriqueetat = resultSet.getLong("idhistoriqueetat");
                            Long idcaracteristique = resultSet.getLong("idcaracteristique");
                            Long idetat = resultSet.getLong("idetat");
                            Date date = resultSet.getDate("date");

                            Historiqueetat historiqueetat = new Historiqueetat(idhistoriqueetat, idcaracteristique, idetat, date);
                            historiqueetat.setAnne(resultSet.getDouble("annee"));
                            historiqueetat.setMois(resultSet.getDouble("mois"));
                            historiqueetat.setIdmaque(resultSet.getLong("idfmarque"));
                            resultList.add(historiqueetat);
                        }
                        
                    } catch (SQLException e) {
                        e.printStackTrace(); // Gestion des exceptions à améliorer selon votre besoin
                    }

            return resultList;
        }
        public Long getVraiCount(Long idetat,Double mois,Double anne,Long idmarque,  List<Historiqueetat> liste){
            Long resulta =0L;
            for(int i=0;i<liste.size();i++){
                Historiqueetat historiqueetat= liste.get(i);
                if(historiqueetat.getIdmaque()==idmarque && historiqueetat.getAnne().equals(anne) && historiqueetat.getMois().equals(mois) && historiqueetat.getIdetat()==idetat){
                    resulta=resulta+1L;
                }
            }
            return resulta;
        }
        public Long getIdmaque() {
            return idmaque;
        }

        public void setIdmaque(Long idmaque) {
            this.idmaque = idmaque;
        }
}
