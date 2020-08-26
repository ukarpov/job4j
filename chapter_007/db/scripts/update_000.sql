CREATE TABLE post (
	id      serial    PRIMARY KEY,
	name    text      NOT NULL,
    body    text,
	link    text      NOT NULL UNIQUE,
	created timestamp NOT NULL
);