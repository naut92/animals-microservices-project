--Cities
INSERT INTO cities (name) VALUES
('Boston'),
('New-York'),
('San-Jose'),
('Philadelphia');

--Counties
INSERT INTO counties (city_id, name) VALUES
(1, 'county1'),
(3, 'county2'),
(4, 'county1'),
(1, 'county3'),
(2, 'county4');

--Veterinarians
INSERT INTO veterinarians (city_id, firstname, lastname, email) VALUES
(1, 'veterinarian-1fn', 'veterinarian-1ln', 'veterinarian-1ln@email.com'),
(1, 'veterinarian-2fn', 'veterinarian-2ln', 'veterinarian-2ln@email.com'),
(3, 'veterinarian-3fn', 'veterinarian-3ln', 'veterinarian-3ln@email.com'),
(2, 'veterinarian-4fn', 'veterinarian-4ln', 'veterinarian-4ln@email.com'),
(2, 'veterinarian-5fn', 'veterinarian-5ln', 'veterinarian-5ln@email.com');

--Users
INSERT INTO customers (city_id, county_id, firstname, lastname, email, pass, pass_confirm) VALUES
(3, 2, 'user1-fn', 'user1-ln', 'email1@email.com', '12A34', '12A34'),
(3, 2, 'user2-fn', 'user2-ln', 'email2@email.com', '12A34', '12A34'),
(2, 5, 'user3-fn', 'user3-ln', 'email3@email.com', '$2a$10$SAa58uRBRVZmL/HD6qjALOmmRyxN.1f71XpsjM6LtLnCAeJCyGJ0G', '12A34'),
(4, 3, 'user4-fn', 'user4-ln', 'email4@email.com', '12A34', '12A34'),
(4, 3, 'user5-fn', 'user5-ln', 'email5@email.com', '12A34', '12A34'),
(1, 1, 'user6-fn', 'user6-ln', 'email6@email.com', '12A34', '12A34'),
(2, 5, 'user7-fn', 'user7-ln', 'email7@email.com', '12A34', '12A34');

--Animals
INSERT INTO animals (customer_id, typesanimal, name, sex, dateborn, price) VALUES
(3, 'cat', 'animal1', 'male', '2013-13-06', 1000),
(3, 'dog', 'animal2', 'female', '2015-24-09', 2000),
(1, 'bird', 'animal34', 'female', '2011-15-02', 3500),
(4, 'fish', 'animal4', 'male', '2010-16-03', 300),
(5, 'dog', 'animal5', 'female', '2009-17-04', 2500),
(5, 'bird', 'animal6', 'male', '2008-18-05', 4000),
(6, 'cat', 'animal7', 'male', '2007-19-06', 1350),
(6, 'fish', 'animal8', 'female', '2006-20-07', 450),
(7, 'dog', 'animal9', 'female', '2005-21-08', null),
(7, 'fish', 'animal10', 'male', '2004-23-09', 650),
(7, 'cat', 'animal11', 'female', '2003-22-10', 25000),
(7, 'bird', 'animal12', 'male', '2002-24-11', 7500);

INSERT INTO veterin_county (county_id, veterinarian_id) VALUES
(1, 1),
(2, 1),
(3, 5),
(4, 4),
(5, 2),
(4, 2),
(3, 3);

INSERT INTO veterin_customer (customer_id, veterinarian_id) VALUES
(1, 2),
(2, 3),
(3, 3),
(4, 1),
(5, 5),
(6, 5),
(7, 4);
