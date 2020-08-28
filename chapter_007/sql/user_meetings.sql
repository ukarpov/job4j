CREATE TABLE meeting (
	id        serial  PRIMARY KEY,
	meet_name varchar NOT NULL
);

CREATE TABLE users (
	id        serial  PRIMARY KEY,
	user_name varchar NOT NULL
);

-- Доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах. 
-- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.
CREATE TABLE user_meeting (
	user_id    int     NOT NULL REFERENCES users (id),
	meeting_id int     NOT NULL REFERENCES meeting (id),
	status     varchar NOT NULL DEFAULT 'NEW' CHECK (status IN ('NEW', 'APPROVED', 'DECLINED')),
	PRIMARY KEY (user_id, meeting_id)
);

-- 2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.
SELECT m.meet_name,
       COUNT(CASE
			   WHEN um.status = 'APPROVED' THEN 1
			   ELSE NULL
			 END) AS approved_count
  FROM meeting m
       LEFT OUTER JOIN user_meeting um
	   ON um.meeting_id = m.id
 GROUP BY m.id, m.meet_name
 ORDER BY approved_count DESC;

-- 3. Нужно получить все совещания, где не было ни одной заявки на посещения
SELECT m.*
  FROM meeting m
 WHERE NOT EXISTS (SELECT 'no requests' FROM user_meeting um WHERE um.meeting_id = m.id);


