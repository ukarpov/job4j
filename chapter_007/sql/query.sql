/*
В системе заданы таблицы 
product(id, name, type_id, expired_date, price)
type(id, name)
Задание.
*/

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.name,
       t.name
  FROM product p
       JOIN type t ON p.type_id = t.id
 WHERE t.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT p.name,
       t.name
  FROM product p
       JOIN type t ON p.type_id = t.id
 WHERE lower(t.name) LIKE '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT p.*
  FROM product p
 WHERE p.expire_date BETWEEN date_trunc('month', CURRENT_DATE + interval '1 month') 
                         AND date_trunc('month', CURRENT_DATE + interval '1 month') + interval '1 month - 1 second';
 

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT p.*
  FROM product p
 WHERE p.price = (SELECT MAX(price) FROM product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name,
       count(p.id)
  FROM product p
       JOIN type t ON p.type_id = t.id
 GROUP BY t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.name,
       t.name
  FROM product p
       JOIN type t ON p.type_id = t.id
 WHERE t.name IN ('СЫР', 'МОЛОКО');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
SELECT t.name
  FROM product p
       JOIN type t ON p.type_id = t.id
 GROUP BY t.name
HAVING count(p.id) < 10;

-- 8. Вывести все продукты и их тип.
SELECT t.name as product_type,
       p.*
  FROM product p
       JOIN type t ON p.type_id = t.id;

-- test data
/*
WITH product AS (SELECT 1 id, 'рокфор' as name, 1 type_id, TO_DATE('01092020','ddmmyyyy') expire_date, 10 price union all
				SELECT 2, 'чеддер', 1, TO_DATE('25092020','ddmmyyyy'), 2 union all
				SELECT 3, 'бри', 1, TO_DATE('01102020','ddmmyyyy'), 15 union all
				SELECT 4, 'домик в деревне', 2, TO_DATE('01092019','ddmmyyyy'), 9 union all
				SELECT 5, 'простоквашино', 2, NULL, 3),
type AS (select 'СЫР' as name, 1 id union all
		 select 'МОЛОКО', 2 )
*/
