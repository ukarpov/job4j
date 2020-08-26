// 1) Retrieve in a single query:
// - names of all persons that are NOT in the company with id = 5
// - company name for each person
WITH company AS (SELECT 1 id, 'Company1' AS name UNION ALL
				 SELECT 2, 'Company2' UNION ALL
				 SELECT 3, 'Company3' UNION ALL
				 SELECT 5, 'Company5'),
     person AS (SELECT 1 id, 'Person1' AS name, 1 company_id UNION ALL
			    SELECT 2 id, 'Person2' AS name, 2 company_id UNION ALL
			    SELECT 3 id, 'Person3' AS name, 2 company_id UNION ALL
			    SELECT 4 id, 'Person4' AS name, 2 company_id UNION ALL
			    SELECT 5 id, 'Person5' AS name, 3 company_id UNION ALL
			    SELECT 6 id, 'Person6' AS name, 3 company_id UNION ALL
				SELECT 8 id, 'Person with no company' AS name, null UNION ALL
			    SELECT 7 id, 'Person in comp 5' AS name, 5 company_id)
SELECT p.name,
       c.name
  FROM person p
       LEFT OUTER JOIN company c ON p.company_id = c.id
 WHERE coalesce(c.id,-1) != 5;

// 2) Select the name of the company with the maximum number of persons + number of persons in this company
WITH company AS (SELECT 1 id, 'Company1' AS name UNION ALL
				 SELECT 2, 'Company2' UNION ALL
				 SELECT 3, 'Company3' UNION ALL
				 SELECT 5, 'Company5'),
     person AS (SELECT 1 id, 'Person1' AS name, 1 company_id UNION ALL
			    SELECT 2 id, 'Person2' AS name, 2 company_id UNION ALL
			    SELECT 3 id, 'Person3' AS name, 2 company_id UNION ALL
			    SELECT 4 id, 'Person4' AS name, 2 company_id UNION ALL
			    SELECT 5 id, 'Person5' AS name, 3 company_id UNION ALL
			    SELECT 6 id, 'Person6' AS name, 3 company_id UNION ALL
				SELECT 8 id, 'Person with no company' AS name, null UNION ALL
			    SELECT 7 id, 'Person in comp 5' AS name, 5 company_id)
SELECT c.name,
       p_cnt.cnt
  FROM (SELECT p.company_id,
			   count(*) cnt,
			   MAX(count(*))OVER() max_cnt
		  FROM person p
		 GROUP BY p.company_id) p_cnt
	   JOIN company c ON p_cnt.company_id = c.id
 WHERE p_cnt.cnt = p_cnt.max_cnt

/*
 SELECT c.name,
       count(p.id) person_count
  FROM company c
       JOIN person p ON p.company_id = c.id
 GROUP BY c.id, c.name
 HAVING count(p.id) = (SELECT MAX(x.cnt) FROM (SELECT count(*) cnt FROM person GROUP BY company_id) x);
*/