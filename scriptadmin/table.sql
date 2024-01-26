create database backvarotrafiara;
\c backvarotrafiara;


create or replace view v_nbr_post as
SELECT COUNT(*), EXTRACT(YEAR FROM c.annemodel) AS annee, EXTRACT(MONTH FROM c.annemodel) AS mois
FROM caracteristique AS c
GROUP BY annee, mois
ORDER BY annee DESC, mois DESC;

select  idcaracteristique,annemodel from caracteristique ;


drop table  Utilisateur;

select * from client;

create table Utilisateur (
    id bigint primary key,
    pseudo text,
    password text,
    role text
);
delete Utilisateur;
insert into Utilisateur(id,pseudo,password,role) values (1,'mertinaclaudietoto@gmail.com','$2a$10$GmheAiXgI.d8IPWOTjTvw..1Ew15G4M7Rj09JfTi/vXmnLVjHnztC',null);

create table favorie(
    idfavorie bigint  primary key,
    idfcaracteristique bigint references caracteristique(idcaracteristique),
    idclient bigint references client(idclient)
);

create table typevehicule(
    idtypevehicule bigint primary key,
    nomtypevehicule varchar(50)
);
create table marque (
    idmarque bigint primary key,
    nommarque varchar(100)
);

create table model(
    idmodel bigint primary key,
    nommodel varchar(100),
    idfmarque bigint references marque(idmarque)
);

create table energie(
    idenergie bigint primary key,
    nomenergie varchar(100)
);

create table equipement(
    idequipement  bigint primary key,
    nomequipement varchar(100)
);


create table couleur(
    idcouleur bigint primary key,
    nomcouleur varchar(100)
);
create table localisation(
    idlocalisation bigint primary key,
    nomlocalisation varchar(100)
);
create table boitdevitesse(
    idboitedevitesse bigint primary key,
    nomboitdereception varchar(100)
);
create table genre(
    idgenre bigint primary key,
    nomgenre varchar(20)
);
-- Changer le type de colonne de integer à bigint
ALTER TABLE client
ALTER COLUMN motdepasse TYPE text;
update client set motdepasse='mertina';

update client set motdepasse='$2a$10$GmheAiXgI.d8IPWOTjTvw..1Ew15G4M7Rj09JfTi/vXmnLVjHnztC';
create table client(
    idclient bigint primary key,
    nomclient varchar(100),
    prenomclient varchar(100),
    datenaissance date,
    email text,
    motdepasse varchar(20),
    idfgenre bigint references genre(idgenre),
    tel text,
    idflocalisation bigint references localisation(idlocalisation)
);
ALTER TABLE client
ADD CONSTRAINT emailunique UNIQUE (email);

create table clientdateinscription(
    idclientdateinscription bigint primary key,
    idclient bigint references client(idclient),
    date timestamp
);
insert into clientdateinscription values (1,1,'2024-01-02');
insert into clientdateinscription values (2,2,'2024-02-02');
insert into clientdateinscription values (3,3,'2024-03-03');

CREATE OR REPLACE VIEW v_inscription AS
SELECT COUNT(idclient) AS nbr,
       EXTRACT(YEAR FROM clientdateinscription.date) AS annee,
       EXTRACT(MONTH FROM clientdateinscription.date) AS mois
FROM clientdateinscription;




insert into client values (1,'TOTO','Mertina Claudie','2003-06-28','mertinaclaudietoto@gmail.com','mertina5042',1,'0349359504',1);

create table etat(
    idetat bigint primary key,
    nometat varchar(50)
);

create table caracteristique(
    idcaracteristique bigint primary key,
    idfetat bigint references etat(idetat),
    idclient bigint references client(idclient),
    idfboitedevitesse bigint references boitdevitesse(idboitedevitesse),
    idfmarque bigint references marque(idmarque),
    idfmodel bigint references model(idmodel),
    idfenergie bigint references energie(idenergie),
    idftypevehicule bigint references typevehicule(idtypevehicule),
    idlocalisation bigint references localisation(idlocalisation),
    autonomie double precision,
    kilometrage double precision,
    anneedefabrication date,
    annemodel date,
    capacite double precision,
    consomation double precision,
    prixdevente double precision,
    coleur bigint references couleur(idcouleur),
    nbrporte int,
    nbrplace int,
    longueur double precision,
    largeur double precision,
    hauteur double precision,
    volumeducoffre double precision,
    commission double precision,
);
select prixdevente from caracteristique;

update caracteristique set prixdevente=150000 where idcaracteristique in (12,13,14,15,16,17);
update caracteristique set prixdevente=250000 WHERE idcaracteristique BETWEEN 17 AND 25;
update caracteristique set prixdevente=550000  WHERE idcaracteristique BETWEEN 26 AND 50;
update caracteristique set prixdevente=2150000  WHERE idcaracteristique BETWEEN 51 AND 60;
update caracteristique set prixdevente=3150000  WHERE idcaracteristique BETWEEN 61 AND 85;




-- update caracteristique set  where idcaracteristique=1;

UPDATE caracteristique
SET commission = 0
WHERE commission IS NULL;


update caracteristique set idfmarque=1,idfmodel=1,idfenergie=1,idlocalisation=1,idfboitedevitesse=1,idftypevehicule=4 where idcaracteristique=1;
update caracteristique set idfmarque=2,idfmodel=5,idfenergie=1,idlocalisation=1,idfboitedevitesse=1,idftypevehicule=4 where idcaracteristique=2;
update caracteristique set idfmarque=3,idfmodel=9,idfenergie=1,idlocalisation=1,idfboitedevitesse=1,idftypevehicule=4 where idcaracteristique=3;
update caracteristique set idfmarque=4,idfmodel=13,idfenergie=3,idlocalisation=2,idfboitedevitesse=2,idftypevehicule=5 where idcaracteristique=4;
update caracteristique set idfmarque=5,idfmodel=17,idfenergie=3,idlocalisation=2,idfboitedevitesse=2,idftypevehicule=5 where idcaracteristique=5;
update caracteristique set idfmarque=6,idfmodel=21,idfenergie=3,idlocalisation=3,idfboitedevitesse=2,idftypevehicule=5 where idcaracteristique=6;
update caracteristique set idfmarque=7,idfmodel=25,idfenergie=4,idlocalisation=3,idfboitedevitesse=4,idftypevehicule=6 where idcaracteristique=12;


idcaracteristique/idfetat/idclient/idfboitedevitesse/idfmarque/idfmodel/idfenergie/idftypevehicule/idlocalisation/autonomie/kilometrage/anneedefabrication/annemodel/capacite/consomation/prixdevente/coleur/nbrporte/
delete from photocaracteristique;
delete from detaillecaequipement;
delete from caracteristique;

select nomclient,prenomclient,prixdevente,nommarque,nommodel,nomcouleur,nomlocalisation from v_liste_annonce ;
SELECT nextval('photocaracteristique_sequence') AS prochaine_valeur;
SELECT nextval('detaillecaequipement_sequence') AS prochaine_valeur;


create table detaillecaequipement(
    iddetaillecaequipement bigint primary key,
    idfcaracteristique bigint references caracteristique(idcaracteristique),
    idfequipement bigint references equipement(idequipement)
);

create table photocaracteristique(
    idphotocaracteristique bigint primary key,
    idfcaracteristique bigint references caracteristique(idcaracteristique),
    nomimage text
);

select
        * 
    from
        client 
    where
        email='mertinaclaudietoto@gmail.com'
        and motdepasse='mertina5041';



create table administrateur(
    idadministrateur bigint primary key,
    nom varchar(100),
    prenom varchar(100),
    datenaissance date,
    email text,
    motdepasse varchar(20),
    idfgenre bigint references genre(idgenre),
    tel text,
    idflocalisation bigint references localisation(idlocalisation)
);
INSERT INTO table_administrateurs (idadministrateur, nom, prenom, datenaissance, email, motdepasse, idfgenre, tel, idflocalisation)
VALUES
    (1, 'Doe', 'John', '1990-05-15', 'john.doe@example.com', 'motdepasse123', 1, '123456789', 2),
    (2, 'Smith', 'Jane', '1985-08-22', 'jane.smith@example.com', 'password456', 2, '987654321', 3),
    (3, 'Johnson', 'Bob', '1978-03-10', 'bob.johnson@example.com', 'securepass', 1, '5551112233', 1);

delete from validation ;

create table validation(
    idvalidation bigint primary key,
    datevalidation date,
    idcaracteristique bigint references caracteristique(idcaracteristique),
    idadministrateur bigint references administrateur(idadministrateur),
    commissionvalidation double precision
);

create table historiqueetat(
    idhistoriqueetat bigint primary key,
    idcaracteristique bigint references caracteristique(idcaracteristique),
    idetat bigint  references etat(idetat),
    date date
);
ALTER TABLE historiqueetat
ALTER COLUMN date TYPE timestamp;

select idfmarque,idhistoriqueetat,historiqueetat.idcaracteristique,idetat,date,EXTRACT(YEAR FROM date) AS annee, EXTRACT(MONTH FROM date) AS mois from historiqueetat join caracteristique on historiqueetat.idcaracteristique=caracteristique.idcaracteristique;

drop view v_detail_statistique_annonce;

create or replace view v_detail_statistique_annonce as
select historiqueetat.idetat,nommarque,idmarque,COUNT(historiqueetat.idcaracteristique), EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois
from 
historiqueetat join 
v_liste_annonce on historiqueetat.idcaracteristique=v_liste_annonce.idcaracteristique 
GROUP by nommarque,idmarque ,annee, mois,historiqueetat.idetat
ORDER BY annee ASC, mois ASC;

select * from v_detail_statistique_annonce;

CREATE OR REPLACE VIEW v_detail_statistique_annonce AS
SELECT
    historiqueetat.idetat,
    nommarque,
    idmarque,
    COUNT(historiqueetat.idcaracteristique) AS count,
    EXTRACT(YEAR FROM historiqueetat.date) AS annee,
    EXTRACT(MONTH FROM historiqueetat.date) AS mois
FROM
    historiqueetat
JOIN
    v_liste_annonce ON historiqueetat.idcaracteristique = v_liste_annonce.idcaracteristique
GROUP BY
    nommarque, idmarque, annee, mois, historiqueetat.idetat
ORDER BY
    EXTRACT(YEAR FROM historiqueetat.date) ASC, EXTRACT(MONTH FROM historiqueetat.date) ASC;




create or replace view v_detailnbr_validee as
select nommarque,idmarque,COUNT(historiqueetat.idcaracteristique), EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois
from 
historiqueetat join 
v_liste_annonce on historiqueetat.idcaracteristique=v_liste_annonce.idcaracteristique where idetat=2
GROUP by nommarque,idmarque ,annee, mois
ORDER BY annee DESC, mois DESC;

create or replace view v_detailnbr_vendu as
select nommarque,idmarque,COUNT(historiqueetat.idcaracteristique), EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois
from 
historiqueetat join 
v_liste_annonce on historiqueetat.idcaracteristique=v_liste_annonce.idcaracteristique where idetat=3
GROUP by nommarque,idmarque ,annee, mois
ORDER BY annee DESC, mois DESC;



create or replace view v_nbr_validee as
SELECT COUNT(*), EXTRACT(YEAR FROM c.date) AS annee, EXTRACT(MONTH FROM c.date) AS mois
FROM historiqueetat AS c where idetat=2
GROUP BY annee, mois
ORDER BY annee DESC, mois DESC;


create or replace view v_nbr_vendu as
SELECT COUNT(*), EXTRACT(YEAR FROM c.date) AS annee, EXTRACT(MONTH FROM c.date) AS mois
FROM historiqueetat AS c where idetat=3
GROUP BY annee, mois
ORDER BY annee DESC, mois DESC;


drop view v_statistique_annonce;
create or replace view v_statistique_annonce as
SELECT idetat,COUNT(*) as nbr , EXTRACT(YEAR FROM c.date) AS annee, EXTRACT(MONTH FROM c.date) AS mois
FROM historiqueetat AS c 
GROUP BY annee, mois,idetat
ORDER BY annee ASC, mois ASC;







select * from v_statistique_annonce;
select
        * 
    from
        administrateur 
    where
        email='marieclaudiarasolonjatovo@gmail.com'
        and motdepasse='mertina5041';


create table commission (
    idcommission bigint primary key,
    bornea double precision,
    borneb double precision,
    pourcentage  double precision
);

select * from v_commision_vente;

drop view v_commision_vente;

create or replace view v_commision_vente as
select sum(commission),EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois from caracteristique 
join historiqueetat 
on caracteristique.idcaracteristique=historiqueetat.idcaracteristique where historiqueetat.idetat=3 group by annee,mois;

select * from v_commision_vente;


select historiqueetat.idetat,nommarque,idmarque,COUNT(*), EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois
from 
historiqueetat join 
v_liste_annonce on historiqueetat.idcaracteristique=v_liste_annonce.idcaracteristique 
GROUP by nommarque,idmarque ,annee, mois,historiqueetat.idetat
ORDER BY annee ASC, mois ASC;


select historiqueetat.idetat,nommarque,idmarque,COUNT(idmarque),EXTRACT(YEAR FROM historiqueetat.date) AS annee, EXTRACT(MONTH FROM historiqueetat.date) AS mois
from 
historiqueetat join 
v_liste_annonce on historiqueetat.idcaracteristique=v_liste_annonce.idcaracteristique 
GROUP by nommarque,idmarque ,annee, mois,historiqueetat.idetat
ORDER BY annee ASC, mois ASC;