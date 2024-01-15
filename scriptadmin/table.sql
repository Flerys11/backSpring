create database backvarotrafiara;
\c backvarotrafiara;

drop table  Utilisateur;
create table Utilisateur (
    id bigint primary key,
    pseudo text,
    password text,
    role text
);
delete Utilisateur;
insert into Utilisateur(id,pseudo,password,role) values (1,'mertinaclaudietoto@gmail.com','$2a$10$GmheAiXgI.d8IPWOTjTvw..1Ew15G4M7Rj09JfTi/vXmnLVjHnztC',null);

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

select nomclient,prenomclient,prixdevente,nommarque,nommodel,nomcouleur,nomlocalisation from v_liste_annonce ;





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
