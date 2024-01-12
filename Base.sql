CREATE DATABASE wsrojo;
\c wsrojo;

CREATE TABLE users (
id serial PRIMARY KEY,
login   varchar(30) unique  not null,
pwd     varchar(50) not null
);

CREATE TABLE category (
id serial PRIMARY KEY ,
category varchar (30) not null
);

CREATE TABLE color(
id serial PRIMARY KEY,
color varchar(30) not null 
); 

CREATE TABLE marque(
id serial PRIMARY KEY,
marque varchar(30) not null
);

CREATE TABLE car(
id serial PRIMARY KEY,
matricule varchar(30) not null,
id_marque int not null,
id_category int not null,
id_color int not null,
FOREIGN KEY(id_marque) REFERENCES marque(id),
FOREIGN KEY(id_category) REFERENCES category(id),
FOREIGN KEY(id_color) REFERENCES color(id)
);

CREATE TABLE annonce(
id serial PRIMARY KEY,
id_car int not null,
datepub date  not null,
prix  float not null ,
id_user int not null,
FOREIGN KEY(id_car)REFERENCES car(id),
FOREIGN KEY (id_user) REFERENCES users(id)
);


CREATE TABLE magasin(
id serial PRIMARY KEY,
status varchar(20) not null,
id_user int not null,
id_car int not null,
FOREIGN KEY(id_user) REFERENCES users(id),
FOREIGN KEY (id_car) REFERENCES car(id)
);


CREATE TABLE commission(
id serial PRIMARY KEY,
id_category int not null,
prixpourcentage int not null,
FOREIGN KEY(id_category) REFERENCES category(id)
);


CREATE TABLE vendu(
id serial PRIMARY KEY,
id_annonce int not null,
id_commission int not null,
datevente date not null,
FOREIGN KEY(id_annonce) REFERENCES annonce(id),
FOREIGN KEY(id_commission) REFERENCES commission(id)
);

CREATE TABLE achat(
id serial PRIMARY KEY,
dateachat date not null,
id_car int not null,
id_user int not null,
FOREIGN KEY(id_car) REFERENCES car(id),
FOREIGN KEY(id_user) REFERENCES users(id)
);





