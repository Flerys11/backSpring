CREATE VIEW v_model_marque AS
SELECT idmodel, idmarque, nommarque,nommodel
FROM model join marque on model.idfmarque=marque.idmarque;

CREATE VIEW v_liste_equipement_voiture AS
SELECT idfcaracteristique,nomequipement,idequipement
FROM detaillecaequipement join equipement on detaillecaequipement.idfequipement=equipement.idequipement;

drop view v_liste_annonce;
select idequipement,idphotocaracteristique from v_liste_annonce;

System.out.println('idequipement :'+liste.get(i).getIdequipement() + liste.get(i).getNomequipement());

drop view v_liste_annonce;

CREATE VIEW v_liste_annonce AS
SELECT consomation,client.idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace
,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,
nomlocalisation,localisation.idlocalisation,nometat,etat.idetat,
nomboitdereception,boitdevitesse.idboitedevitesse,nommarque,marque.idmarque,nommodel,model.idmodel,
nomenergie,energie.idenergie,nomtypevehicule,typevehicule.idtypevehicule,nomcouleur,couleur.idcouleur,
nomclient,prenomclient,tel,email,v_liste_equipement_voiture.idequipement,nomequipement,nomimage
FROM caracteristique    join etat on caracteristique.idfetat=etat.idetat 
                        join client on  caracteristique.idclient=client.idclient
                        join boitdevitesse on caracteristique.idfboitedevitesse=boitdevitesse.idboitedevitesse
                        join marque on caracteristique.idfmarque= marque.idmarque
                        join model on caracteristique.idfmodel=model.idmodel
                        join energie on caracteristique.idfenergie=energie.idenergie
                        join typevehicule on caracteristique.idftypevehicule=typevehicule.idtypevehicule
                        join couleur on caracteristique.coleur=couleur.idcouleur
                        join localisation on caracteristique.idlocalisation=localisation.idlocalisation
                        left join v_liste_equipement_voiture on caracteristique.idcaracteristique=v_liste_equipement_voiture.idfcaracteristique
                        left join photocaracteristique on caracteristique.idcaracteristique=photocaracteristique.idfcaracteristique order by ;



select localisation.idlocalisation,idequipement,nomequipement,idphotocaracteristique,nomimage from v_liste_annonce;

select nomequipement from v_liste_annonce order by idcaracteristique,idequipement
drop view v_view_annonce;
drop view v_view_annonce;

CREATE VIEW v_view_annonce AS
SELECT nommodel, nommarque, annemodel,prixdevente,nomimage,idclient,idcaracteristique,idetat,nometat
FROM caracteristique join model on caracteristique.idfmodel=model.idmodel 
join marque on caracteristique.idfmarque=marque.idmarque
join etat on etat.idetat=caracteristique.idfetat
join photocaracteristique on caracteristique.idcaracteristique=photocaracteristique.idfcaracteristique;

select * from v_view_annonce;
select * from v_liste_equipement_voiture;

select idphotocaracteristique,idequipement,nomequipement,nomimage from v_liste_annonce;


CREATE VIEW v_liste_annonce3 AS
SELECT idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace
,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,
nomlocalisation,localisation.idlocalisation,nometat,etat.idetat,
nomboitdereception,boitdevitesse.idboitedevitesse,nommarque,marque.idmarque,nommodel,model.idmodel,
nomenergie,energie.idenergie,nomtypevehicule,typevehicule.idtypevehicule,nomcouleur,couleur.idcouleur,
nomclient,prenomclient,tel,email,v_liste_equipement_voiture.idequipement,nomequipement,nomimage
FROM caracteristique    join etat on caracteristique.idfetat=etat.idetat 
                        join client on  caracteristique.idclient=client.idclient
                        join boitdevitesse on caracteristique.idfboitedevitesse=boitdevitesse.idboitedevitesse
                        join marque on caracteristique.idfmarque= marque.idmarque
                        join model on caracteristique.idfmodel=model.idmodel
                        join energie on caracteristique.idfenergie=energie.idenergie
                        join typevehicule on caracteristique.idftypevehicule=typevehicule.idtypevehicule
                        join couleur on caracteristique.coleur=couleur.idcouleur
                        join localisation on caracteristique.idlocalisation=localisation.idlocalisation
                        left join v_liste_equipement_voiture on caracteristique.idcaracteristique=v_liste_equipement_voiture.idfcaracteristique
                        left join photocaracteristique on caracteristique.idcaracteristique=photocaracteristique.idfcaracteristique;

update caracteristique set idetat=2 ;

-- liste annonce avec favorie
drop VIEW v_liste_annonce;

CREATE VIEW v_liste_annonce AS
SELECT consomation,client.idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace
,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,
nomlocalisation,localisation.idlocalisation,nometat,etat.idetat,
nomboitdereception,boitdevitesse.idboitedevitesse,nommarque,marque.idmarque,nommodel,model.idmodel,
nomenergie,energie.idenergie,nomtypevehicule,typevehicule.idtypevehicule,nomcouleur,couleur.idcouleur,
nomclient,prenomclient,tel,email,v_liste_equipement_voiture.idequipement,nomequipement,nomimage
FROM caracteristique    join etat on caracteristique.idfetat=etat.idetat 
                        join client on  caracteristique.idclient=client.idclient
                        join boitdevitesse on caracteristique.idfboitedevitesse=boitdevitesse.idboitedevitesse
                        join marque on caracteristique.idfmarque= marque.idmarque
                        join model on caracteristique.idfmodel=model.idmodel
                        join energie on caracteristique.idfenergie=energie.idenergie
                        join typevehicule on caracteristique.idftypevehicule=typevehicule.idtypevehicule
                        join couleur on caracteristique.coleur=couleur.idcouleur
                        join localisation on caracteristique.idlocalisation=localisation.idlocalisation
                        left join v_liste_equipement_voiture on caracteristique.idcaracteristique=v_liste_equipement_voiture.idfcaracteristique
                        left join photocaracteristique on caracteristique.idcaracteristique=photocaracteristique.idfcaracteristique order by annemodel;

select   idfavorie,consomation,idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,nomlocalisation,idlocalisation,nometat,idetat,nomboitdereception,idboitedevitesse,nommarque,idmarque,nommodel,idmodel,nomenergie,idenergie,nomtypevehicule,idtypevehicule,nomcouleur,idcouleur,nomclient,prenomclient,tel,email,idequipement,nomequipement,nomimage from v_liste_annonce   left join (select idfavorie,idfcaracteristique from favorie where idclient=1)  as fa on fa.idfcaracteristique=v_liste_annonce.idcaracteristique;

--visuelle de left et de right joi
create database testrequette;
\c testrequette;

create table personne(
    idpersonne bigint primary key,
    nom text,
    prenom text
);
insert into personne values (1,'TOTO','Mertina claudie');
insert into personne values (2,'TOTO','Marie Alice');

create table age(
    idage bigint primary key,
    nbrage int,
    idpersonne bigint references personne(idpersonne)
);
insert into age values (1,20,1);

select nom,prenom,nbrage from personne left join age on personne.idpersonne=age.idpersonne;

select   idfavorie,consomation,idclient,idphotocaracteristique,idcaracteristique,commission,volumeducoffre,hauteur,largeur,longueur,nbrplace,nbrporte,prixdevente,capacite,annemodel,anneedefabrication,kilometrage,autonomie,nomlocalisation,idlocalisation,nometat,idetat,nomboitdereception,idboitedevitesse,nommarque,idmarque,nommodel,idmodel,nomenergie,idenergie,nomtypevehicule,idtypevehicule,nomcouleur,idcouleur,nomclient,prenomclient,tel,email,idequipement,nomequipement,nomimage from v_liste_annonce   left join (select idfavorie,idfcaracteristique from favorie where idclient=1)  as fa on fa.idfcaracteristique=v_liste_annonce.idcaracteristique where idetat!=1 and idclient=1;
drop view v_info_client;
CREATE VIEW v_info_client AS
SELECT idclient,nomclient,prenomclient,datenaissance,email,nomgenre,tel,nomlocalisation
FROM client join localisation on client.idflocalisation=localisation.idlocalisation
join genre on genre.idgenre=client.idfgenre;

