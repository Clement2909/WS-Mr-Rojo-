INSERT INTO users(login,pwd) VALUES
('Toavina',md5('Toavina')),('Clement',md5('Clement')),('Mickael',md5('Mickael')),('Ifaliantsoa',md5('Ifaliantsoa'));

INSERT INTO color(color) VALUES
('rouge'),('noir'),('bleu'),('gris'),('vert'),('jaune'),('blanc'),('violet'),('rose'),('orange'),('Marron');

INSERT INTO category(category) VALUES 
('SUV'),('berline'),('coupe'),('decapotable'),('break'),('monospace'),('citadine'),('crossover'),('compacte'),('sportive');

INSERT INTO brand(brand) VALUES
('Toyota'),('Ford'),('BMW'),('Mercedes-Benz'),('Honda'),('Volkswagen'),('Tesla'),('Nissan'),('Audi'),('Chevrolet');

INSERT INTO car(matricule,anneefabrication,etat,moteur,transmission,kilometrage,infos,id_category,id_brand,id_color) VALUES
('ADE145',2005,5,'a plat','manuelle',9200,'Voiture familiale spacieuse,faible consommation ,entretien a jour.',2,1,2),('QCS698',2010,7,'en etoile','automatique',12000,'Elegant,faible kilometrage',1,2,4),
('HGD452',2004,8,'en V','integrale',6500,'Petit prix,economique en carburant et ideal pour les deplacements urbains',7,6,7),('FGK698',1999,6,'a injection directe','par propulsion',25600,'robuste,equipement moderne,historique en entretien complet ',10,8,1),
('MLB781',2005,6,'a turbocompresseur','electrique',210300,'Compact et agile, cette voiture offre confort et efficacite',5,4,3);

INSERT INTO annonce(id_car,datepub,prix,id_user) VALUES
(1,'2023-11-27',1750000,2) , (3,'2024-01-05',2600000,4);

INSERT INTO magasin(id_user,id_car) VALUES
(2,1),(4,3);

INSERT INTO commission (id_category,prixpourcentage) VALUES
(1,10),(2,12.5),(3,15.25),(4,20),(5,22.5),(6,11),(7,14.25),(8,22.75),(9,20.5),(10,13);

INSERT INTO vendu (id_annonce,id_commission,datevente)VALUES (2,7,'2024-01-10');

INSERT INTO achat(dateachat,id_car,id_user)VALUES('2024-01-10',3,1);
UPDATE magasin SET status='vendu' where id= 2;