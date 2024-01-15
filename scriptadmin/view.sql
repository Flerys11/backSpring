CREATE VIEW v_model_marque AS
SELECT idmodel, idmarque, nommarque,nommodel
FROM model join marque on model.idfmarque=marque.idmarque;

CREATE VIEW v_liste_equipement_voiture AS
SELECT idfcaracteristique,nomequipement,idequipement
FROM detaillecaequipement join equipement on detaillecaequipement.idfequipement=equipement.idequipement;


CREATE VIEW v_liste_annonce AS
SELECT commission,volumeducoffre,hauteur,largeur,longueur,nbrplace
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