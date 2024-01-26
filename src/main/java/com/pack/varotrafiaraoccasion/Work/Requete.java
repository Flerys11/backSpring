package com.pack.varotrafiaraoccasion.Work;
import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import com.pack.varotrafiaraoccasion.Entity.V_view_annonce;

import java.sql.*;
public class Requete {
    public Requete() { 
    }
    public static java.util.List< V_liste_annonce> findAllAnnonceWithFavorie(Long id){
        java.util.List< V_liste_annonce> resulta = new java.util.ArrayList< V_liste_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select   idfavorie,consomation,idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,nomlocalisation,idlocalisation,nometat,idetat,nomboitdereception,idboitedevitesse,nommarque,idmarque,nommodel,idmodel,nomenergie,idenergie,nomtypevehicule,idtypevehicule,nomcouleur,idcouleur,nomclient,prenomclient,tel,email,idequipement,nomequipement,nomimage from v_liste_annonce   left join (select idfavorie,idfcaracteristique from favorie where idclient="+id+")  as fa on fa.idfcaracteristique=v_liste_annonce.idcaracteristique where idetat!=1";
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_liste_annonce annonce = new V_liste_annonce();
            // Attribution des valeurs aux propriétés de l'objet annonce
            annonce.setIdphotocaracteristique(resultSet.getLong("idphotocaracteristique"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setCommission(resultSet.getDouble("commission"));
            annonce.setVolumeducoffre(resultSet.getDouble("volumeducoffre"));
            annonce.setHauteur(resultSet.getDouble("hauteur"));
            annonce.setLargeur(resultSet.getDouble("largeur"));
            annonce.setLongueur(resultSet.getDouble("longueur"));
            annonce.setNbrplace(resultSet.getInt("nbrplace"));
            annonce.setNbrporte(resultSet.getInt("nbrporte"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setCapacite(resultSet.getDouble("capacite"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setAnneedefabrication(resultSet.getDate("anneedefabrication"));
            annonce.setKilometrage(resultSet.getDouble("kilometrage"));
            annonce.setAutonomie(resultSet.getDouble("autonomie"));
            annonce.setNomlocalisation(resultSet.getString("nomlocalisation"));
            annonce.setIdlocalisation(resultSet.getLong("idlocalisation"));
            annonce.setNometat(resultSet.getString("nometat"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNomboitdereception(resultSet.getString("nomboitdereception"));
            annonce.setIdboitedevitesse(resultSet.getLong("idboitedevitesse"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setIdmarque(resultSet.getLong("idmarque"));
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setIdmodel(resultSet.getLong("idmodel"));
            annonce.setNomenergie(resultSet.getString("nomenergie"));
            annonce.setIdenergie(resultSet.getLong("idenergie"));
            annonce.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
            annonce.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
            annonce.setNomcouleur(resultSet.getString("nomcouleur"));
            annonce.setIdcouleur(resultSet.getLong("idcouleur"));
            annonce.setNomclient(resultSet.getString("nomclient"));
            annonce.setPrenomclient(resultSet.getString("prenomclient"));
            annonce.setTel(resultSet.getString("tel"));
            annonce.setEmail(resultSet.getString("email"));
            annonce.setIdequipement(resultSet.getLong("idequipement"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setNomequipement(resultSet.getString("nomequipement"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setConsomation(resultSet.getDouble("consomation"));
            annonce.setIdfavorie(resultSet.getLong("idfavorie"));
            
            // Ajout de l'objet annonce à la liste resulta
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }

    public static java.util.List< V_liste_annonce> findAllrequeteAnnonceIdclient(Long id){
        java.util.List< V_liste_annonce> resulta = new java.util.ArrayList< V_liste_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select   idfavorie,consomation,idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,nomlocalisation,idlocalisation,nometat,idetat,nomboitdereception,idboitedevitesse,nommarque,idmarque,nommodel,idmodel,nomenergie,idenergie,nomtypevehicule,idtypevehicule,nomcouleur,idcouleur,nomclient,prenomclient,tel,email,idequipement,nomequipement,nomimage from v_liste_annonce   left join (select idfavorie,idfcaracteristique from favorie where idclient="+id+")  as fa on fa.idfcaracteristique=v_liste_annonce.idcaracteristique where idetat!=1 and idclient="+id;
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_liste_annonce annonce = new V_liste_annonce();
            // Attribution des valeurs aux propriétés de l'objet annonce
            annonce.setIdphotocaracteristique(resultSet.getLong("idphotocaracteristique"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setCommission(resultSet.getDouble("commission"));
            annonce.setVolumeducoffre(resultSet.getDouble("volumeducoffre"));
            annonce.setHauteur(resultSet.getDouble("hauteur"));
            annonce.setLargeur(resultSet.getDouble("largeur"));
            annonce.setLongueur(resultSet.getDouble("longueur"));
            annonce.setNbrplace(resultSet.getInt("nbrplace"));
            annonce.setNbrporte(resultSet.getInt("nbrporte"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setCapacite(resultSet.getDouble("capacite"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setAnneedefabrication(resultSet.getDate("anneedefabrication"));
            annonce.setKilometrage(resultSet.getDouble("kilometrage"));
            annonce.setAutonomie(resultSet.getDouble("autonomie"));
            annonce.setNomlocalisation(resultSet.getString("nomlocalisation"));
            annonce.setIdlocalisation(resultSet.getLong("idlocalisation"));
            annonce.setNometat(resultSet.getString("nometat"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNomboitdereception(resultSet.getString("nomboitdereception"));
            annonce.setIdboitedevitesse(resultSet.getLong("idboitedevitesse"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setIdmarque(resultSet.getLong("idmarque"));
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setIdmodel(resultSet.getLong("idmodel"));
            annonce.setNomenergie(resultSet.getString("nomenergie"));
            annonce.setIdenergie(resultSet.getLong("idenergie"));
            annonce.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
            annonce.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
            annonce.setNomcouleur(resultSet.getString("nomcouleur"));
            annonce.setIdcouleur(resultSet.getLong("idcouleur"));
            annonce.setNomclient(resultSet.getString("nomclient"));
            annonce.setPrenomclient(resultSet.getString("prenomclient"));
            annonce.setTel(resultSet.getString("tel"));
            annonce.setEmail(resultSet.getString("email"));
            annonce.setIdequipement(resultSet.getLong("idequipement"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setNomequipement(resultSet.getString("nomequipement"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setConsomation(resultSet.getDouble("consomation"));
            annonce.setIdfavorie(resultSet.getLong("idfavorie"));
            
            // Ajout de l'objet annonce à la liste resulta
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }

    public static java.util.List< V_liste_annonce> findAllrequeteAnnonce(){
        java.util.List< V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select * from v_liste_annonce";
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_liste_annonce annonce = new V_liste_annonce();
            // Attribution des valeurs aux propriétés de l'objet annonce
            annonce.setIdphotocaracteristique(resultSet.getLong("idphotocaracteristique"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setCommission(resultSet.getDouble("commission"));
            annonce.setVolumeducoffre(resultSet.getDouble("volumeducoffre"));
            annonce.setHauteur(resultSet.getDouble("hauteur"));
            annonce.setLargeur(resultSet.getDouble("largeur"));
            annonce.setLongueur(resultSet.getDouble("longueur"));
            annonce.setNbrplace(resultSet.getInt("nbrplace"));
            annonce.setNbrporte(resultSet.getInt("nbrporte"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setCapacite(resultSet.getDouble("capacite"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setAnneedefabrication(resultSet.getDate("anneedefabrication"));
            annonce.setKilometrage(resultSet.getDouble("kilometrage"));
            annonce.setAutonomie(resultSet.getDouble("autonomie"));
            annonce.setNomlocalisation(resultSet.getString("nomlocalisation"));
            annonce.setIdlocalisation(resultSet.getLong("idlocalisation"));
            annonce.setNometat(resultSet.getString("nometat"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNomboitdereception(resultSet.getString("nomboitdereception"));
            annonce.setIdboitedevitesse(resultSet.getLong("idboitedevitesse"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setIdmarque(resultSet.getLong("idmarque"));
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setIdmodel(resultSet.getLong("idmodel"));
            annonce.setNomenergie(resultSet.getString("nomenergie"));
            annonce.setIdenergie(resultSet.getLong("idenergie"));
            annonce.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
            annonce.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
            annonce.setNomcouleur(resultSet.getString("nomcouleur"));
            annonce.setIdcouleur(resultSet.getLong("idcouleur"));
            annonce.setNomclient(resultSet.getString("nomclient"));
            annonce.setPrenomclient(resultSet.getString("prenomclient"));
            annonce.setTel(resultSet.getString("tel"));
            annonce.setEmail(resultSet.getString("email"));
            annonce.setIdequipement(resultSet.getLong("idequipement"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setNomequipement(resultSet.getString("nomequipement"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setConsomation(resultSet.getDouble("consomation"));
            // annonce.setIdfavorie(resultSet.getLong("idfavorie"));
            // Ajout de l'objet annonce à la liste resulta
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }
    public static java.util.List< V_liste_annonce> findAllrequeteAnnonceId(Long id){
        java.util.List< V_liste_annonce> resulta = new java.util.ArrayList< V_liste_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select * from v_liste_annonce where idcaracteristique="+id;
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_liste_annonce annonce = new V_liste_annonce();
            // Attribution des valeurs aux propriétés de l'objet annonce
            annonce.setIdphotocaracteristique(resultSet.getLong("idphotocaracteristique"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setCommission(resultSet.getDouble("commission"));
            annonce.setVolumeducoffre(resultSet.getDouble("volumeducoffre"));
            annonce.setHauteur(resultSet.getDouble("hauteur"));
            annonce.setLargeur(resultSet.getDouble("largeur"));
            annonce.setLongueur(resultSet.getDouble("longueur"));
            annonce.setNbrplace(resultSet.getInt("nbrplace"));
            annonce.setNbrporte(resultSet.getInt("nbrporte"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setCapacite(resultSet.getDouble("capacite"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setAnneedefabrication(resultSet.getDate("anneedefabrication"));
            annonce.setKilometrage(resultSet.getDouble("kilometrage"));
            annonce.setAutonomie(resultSet.getDouble("autonomie"));
            annonce.setNomlocalisation(resultSet.getString("nomlocalisation"));
            annonce.setIdlocalisation(resultSet.getLong("idlocalisation"));
            annonce.setNometat(resultSet.getString("nometat"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNomboitdereception(resultSet.getString("nomboitdereception"));
            annonce.setIdboitedevitesse(resultSet.getLong("idboitedevitesse"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setIdmarque(resultSet.getLong("idmarque"));
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setIdmodel(resultSet.getLong("idmodel"));
            annonce.setNomenergie(resultSet.getString("nomenergie"));
            annonce.setIdenergie(resultSet.getLong("idenergie"));
            annonce.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
            annonce.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
            annonce.setNomcouleur(resultSet.getString("nomcouleur"));
            annonce.setIdcouleur(resultSet.getLong("idcouleur"));
            annonce.setNomclient(resultSet.getString("nomclient"));
            annonce.setPrenomclient(resultSet.getString("prenomclient"));
            annonce.setTel(resultSet.getString("tel"));
            annonce.setEmail(resultSet.getString("email"));
            annonce.setIdequipement(resultSet.getLong("idequipement"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setNomequipement(resultSet.getString("nomequipement"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setConsomation(resultSet.getDouble("consomation"));
          //  annonce.setIdfavorie(resultSet.getLong("idfavorie"));
            
            // Ajout de l'objet annonce à la liste resulta
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }


    public static java.util.List<V_view_annonce> allValue_viewannonce(Long id){
        java.util.List<V_view_annonce> resulta = new java.util.ArrayList<V_view_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select * from v_view_annonce where idclient="+id;
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_view_annonce annonce = new V_view_annonce();
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNometat(resultSet.getString("nometat"));
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }


    public static void  modif_statu(Long id,Long idcaractere){
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "update caracteristique set idfetat="+id+" where idcaracteristique="+idcaractere;
                statement.executeUpdate(query);
                statement.close();
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static java.util.List< V_liste_annonce> findAllrequeteAnnonceValidee(){
        java.util.List< V_liste_annonce> resulta = new java.util.ArrayList<V_liste_annonce>();
        try {
            ConnectionPostgres con = new ConnectionPostgres();
            Connection connection = con.getconnexion();
                Statement statement = connection.createStatement();
                String query = "select * from v_liste_annonce where idetat=2";
                System.out.println(query);
                ResultSet resultSet = statement.executeQuery(query);
                // Traitement des résultats
        while (resultSet.next()) {
            // Instanciation de la classe V_liste_annonce
            V_liste_annonce annonce = new V_liste_annonce();
            // Attribution des valeurs aux propriétés de l'objet annonce
            annonce.setIdphotocaracteristique(resultSet.getLong("idphotocaracteristique"));
            annonce.setIdcaracteristique(resultSet.getLong("idcaracteristique"));
            annonce.setCommission(resultSet.getDouble("commission"));
            annonce.setVolumeducoffre(resultSet.getDouble("volumeducoffre"));
            annonce.setHauteur(resultSet.getDouble("hauteur"));
            annonce.setLargeur(resultSet.getDouble("largeur"));
            annonce.setLongueur(resultSet.getDouble("longueur"));
            annonce.setNbrplace(resultSet.getInt("nbrplace"));
            annonce.setNbrporte(resultSet.getInt("nbrporte"));
            annonce.setPrixdevente(resultSet.getDouble("prixdevente"));
            annonce.setCapacite(resultSet.getDouble("capacite"));
            annonce.setAnnemodel(resultSet.getDate("annemodel"));
            annonce.setAnneedefabrication(resultSet.getDate("anneedefabrication"));
            annonce.setKilometrage(resultSet.getDouble("kilometrage"));
            annonce.setAutonomie(resultSet.getDouble("autonomie"));
            annonce.setNomlocalisation(resultSet.getString("nomlocalisation"));
            annonce.setIdlocalisation(resultSet.getLong("idlocalisation"));
            annonce.setNometat(resultSet.getString("nometat"));
            annonce.setIdetat(resultSet.getLong("idetat"));
            annonce.setNomboitdereception(resultSet.getString("nomboitdereception"));
            annonce.setIdboitedevitesse(resultSet.getLong("idboitedevitesse"));
            annonce.setNommarque(resultSet.getString("nommarque"));
            annonce.setIdmarque(resultSet.getLong("idmarque"));
            annonce.setNommodel(resultSet.getString("nommodel"));
            annonce.setIdmodel(resultSet.getLong("idmodel"));
            annonce.setNomenergie(resultSet.getString("nomenergie"));
            annonce.setIdenergie(resultSet.getLong("idenergie"));
            annonce.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
            annonce.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
            annonce.setNomcouleur(resultSet.getString("nomcouleur"));
            annonce.setIdcouleur(resultSet.getLong("idcouleur"));
            annonce.setNomclient(resultSet.getString("nomclient"));
            annonce.setPrenomclient(resultSet.getString("prenomclient"));
            annonce.setTel(resultSet.getString("tel"));
            annonce.setEmail(resultSet.getString("email"));
            annonce.setIdequipement(resultSet.getLong("idequipement"));
            annonce.setNomimage(resultSet.getString("nomimage"));
            annonce.setNomequipement(resultSet.getString("nomequipement"));
            annonce.setIdclient(resultSet.getLong("idclient"));
            annonce.setConsomation(resultSet.getDouble("consomation"));
            // annonce.setIdfavorie(resultSet.getLong("idfavorie"));
            // Ajout de l'objet annonce à la liste resulta
            resulta.add(annonce);
        }

                resultSet.close();
                statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulta;
    }

}
