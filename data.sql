INSERT INTO users(login,pwd) VALUES
('Toavina',md5('Toavina')),('Clement',md5('Clement')),('Mickael',md5('Mickael')),('Ifaliantsoa',md5('Ifaliantsoa'));

INSERT INTO color(color) VALUES
('rouge'),('noir'),('bleu'),('gris'),('vert'),('jaune'),('blanc'),('violet'),('rose');

INSERT INTO category(category) VALUES 
('SUV'),('berline'),('coupe'),('decapotable'),('break'),('monospace'),('citadine'),('crossover'),('compacte'),('sportive');

INSERT INTO marque(marque) VALUES
('Toyota'),('Ford'),('BMW'),('Mercedes-Benz'),('Honda'),('Volkswagen'),('Tesla'),('Nissan'),('Audi'),('Chevrolet');

INSERT INTO car(matricule,id_category,id_marque,id_color) VALUES
('ADE145',2,1,2),('QCS698',1,2,4),('HGD452',7,6,7),('FGK698',10,8,1),('MLB781',5,4,3);
