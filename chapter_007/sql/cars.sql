-- DB Structure
CREATE TABLE car_body(
	id serial PRIMARY KEY,
	model_name varchar
);

CREATE TABLE car_engine(
	id serial PRIMARY KEY,
	model_name varchar
);

CREATE TABLE car_transmission(
	id serial PRIMARY KEY,
	model_name varchar
);

CREATE TABLE cars (
	id              serial PRIMARY KEY,
	model_name      varchar NOT NULL,
	body_id         int NOT NULL REFERENCES car_body(id) ON DELETE RESTRICT,
	engine_id       int NOT NULL REFERENCES car_engine(id) ON DELETE RESTRICT,
	transmission_id int NOT NULL REFERENCES car_transmission(id)  ON DELETE RESTRICT
);

-- DB test data
INSERT INTO car_body(model_name)
VALUES ('Body Mk1'),
       ('Body Mk2'),
       ('Body Mk3');

INSERT INTO car_engine(model_name)
VALUES ('Engine Mk1'),
       ('Engine Mk2'),
       ('Engine Mk3');
	   
INSERT INTO car_transmission(model_name)
VALUES ('Gears Mk1'),
       ('Gears Mk2'),
       ('Gears Mk3');

INSERT INTO cars (model_name, body_id, engine_id, transmission_id)
SELECT 'Car Mk1', 
       (SELECT id FROM car_body WHERE model_name LIKE '%Mk1') as body_id,
	   (SELECT id FROM car_engine WHERE model_name LIKE '%Mk1') as engine_id,
	   (SELECT id FROM car_transmission WHERE model_name LIKE '%Mk1') as transmission_id
UNION ALL
SELECT 'Car Mk3', 
       (SELECT id FROM car_body WHERE model_name LIKE '%Mk3') as body_id,
	   (SELECT id FROM car_engine WHERE model_name LIKE '%Mk3') as engine_id,
	   (SELECT id FROM car_transmission WHERE model_name LIKE '%Mk3') as transmission_id;

COMMIT;

-- 1. Вывести список всех машин и все привязанные к ним детали.
SELECT c.model_name AS car,
       b.model_name AS body,
	   e.model_name AS engine,
	   t.model_name AS transmission
  FROM cars c
       JOIN car_body b ON b.id = c.body_id
	   JOIN car_engine e ON e.id = c.engine_id
	   JOIN car_transmission t ON t.id = c.transmission_id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT b.*
  FROM car_body b
       LEFT OUTER JOIN cars c ON b.id = c.body_id
 WHERE c.id IS NULL;

SELECT e.*
  FROM car_engine e
       LEFT OUTER JOIN cars c ON e.id = c.engine_id
 WHERE c.id IS NULL;
 
SELECT t.*
  FROM car_transmission t
       LEFT OUTER JOIN cars c ON t.id = c.transmission_id
 WHERE c.id IS NULL;
