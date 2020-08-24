

CREATE TABLE rules (
	rule_id   serial PRIMARY KEY,
	rule_code varchar,
	rule_name varchar
);

CREATE TABLE roles (
	role_id   serial PRIMARY KEY,
	role_code varchar,
	role_name varchar
);

CREATE TABLE role_rules (
	role_id int REFERENCES roles ON DELETE RESTRICT,
	rule_id int REFERENCES rules ON DELETE RESTRICT,
	UNIQUE(role_id, rule_id)
);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	login   varchar UNIQUE,
	pswrd   varchar,
	role_id int REFERENCES roles ON DELETE RESTRICT
);

CREATE TABLE status (
	status_code varchar PRIMARY KEY,
	name        varchar
);

CREATE TABLE category (
	category_code varchar PRIMARY KEY,
	name          varchar
);

CREATE TABLE items (
	item_id       serial PRIMARY KEY,
	item_name     varchar NOT NULL, 
	description   varchar,
	creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	user_id       int     REFERENCES users ON DELETE SET NULL, 
	status_code   varchar REFERENCES status,
	category_code varchar REFERENCES category
);

CREATE TABLE item_comments (
	comment_id    serial PRIMARY KEY,
	item_id       int    REFERENCES items ON DELETE CASCADE,
	comment_text  varchar,
	user_id       int    REFERENCES users ON DELETE SET NULL, 
	creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE item_attaches (
	attach_id     serial PRIMARY KEY,
	item_id       int    REFERENCES items ON DELETE CASCADE,
	user_id       int    REFERENCES users ON DELETE SET NULL, 
	file_attached bytea,
	file_name     varchar,
	creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO status(status_code, name)
VALUES ('NEW', 'Новая'),
       ('WORK', 'В работе'),
       ('TEST', 'В тестирвоании'),
       ('DONE', 'Завершена');

INSERT INTO category(category_code, name)
VALUES ('DEV', 'Разработка'),
       ('SUP', 'Поддержка'),
       ('RES', 'Исследование');

INSERT INTO rules(rule_code, rule_name)
VALUES ('CREATE', 'Создание'),
       ('UPDATE', 'Изменение'),
       ('DELETE', 'Удаление'),
       ('READ', 'Чтение'),
       ('UPDATE_ALL', 'Изменение всех'),
       ('DELETE_ALL', 'Удаление всех'),
       ('READ_ALL', 'Чтение всех');

INSERT INTO roles(role_code, role_name)
VALUES ('ADMIN', 'Администратор'),
       ('USER', 'Пользователь'),
       ('SUPERVISOR', 'Руководитель');

INSERT INTO role_rules(role_id, rule_id)
SELECT ro.role_id,
       ru.rule_id
  FROM roles ro,
       rules ru
 WHERE ro.role_code = 'ADMIN'
   AND (ru.rule_code LIKE '%ALL' OR ru.rule_code = 'CREATE')
UNION ALL
SELECT ro.role_id,
       ru.rule_id
  FROM roles ro,
       rules ru
 WHERE ro.role_code = 'USER'
   AND ru.rule_code NOT LIKE '%ALL'
UNION ALL
SELECT ro.role_id,
       ru.rule_id
  FROM roles ro,
       rules ru
 WHERE ro.role_code = 'SUPERVISOR'
   AND (ru.rule_code NOT LIKE '%ALL' OR ru.rule_code = 'READ_ALL');

INSERT INTO users(login,pswrd,role_id)
SELECT 'Admin', 'Admin', (SELECT role_id FROM roles WHERE role_code = 'ADMIN') UNION ALL
SELECT 'User1', 'qwer', (SELECT role_id FROM roles WHERE role_code = 'USER') UNION ALL
SELECT 'Supervisor1', 'asdf', (SELECT role_id FROM roles WHERE role_code = 'SUPERVISOR');

COMMIT;

CREATE ROLE tracker_app WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'md5ea6398b5d4377c1bde31e8b8b2fc910e';

GRANT ALL ON SEQUENCE public.item_attaches_attach_id_seq TO tracker_app;

GRANT ALL ON SEQUENCE public.item_comments_comment_id_seq TO tracker_app;

GRANT ALL ON SEQUENCE public.items_item_id_seq TO tracker_app;

GRANT ALL ON SEQUENCE public.roles_role_id_seq TO tracker_app;

GRANT ALL ON SEQUENCE public.rules_rule_id_seq TO tracker_app;

GRANT ALL ON SEQUENCE public.users_user_id_seq TO tracker_app;

GRANT ALL ON TABLE public.category TO tracker_app;

GRANT ALL ON TABLE public.databasechangelog TO tracker_app;

GRANT ALL ON TABLE public.databasechangeloglock TO tracker_app;

GRANT ALL ON TABLE public.item_attaches TO tracker_app;

GRANT ALL ON TABLE public.item_comments TO tracker_app;

GRANT ALL ON TABLE public.items TO tracker_app;

GRANT ALL ON TABLE public.role_rules TO tracker_app;

GRANT ALL ON TABLE public.roles TO tracker_app;

GRANT ALL ON TABLE public.rules TO tracker_app;

GRANT ALL ON TABLE public.status TO tracker_app;

GRANT ALL ON TABLE public.users TO tracker_app;

