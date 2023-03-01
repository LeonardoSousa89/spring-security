CREATE DATABASE fbi;
DROP DATABASE fbi;

\c fbi

CREATE TABLE IF NOT EXISTS agents(
	id SERIAL PRIMARY KEY,
	name VARCHAR(250) NOT NULL,
	phone VARCHAR(50) NOT NULL,
	email VARCHAR(100)NOT NULL UNIQUE,
	corp_office FLOAT(10) NOT NULL,
	corp_state FLOAT(10) NOT NULL,
	corp_city FLOAT(10) NOT NULL,
	status FLOAT(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS top_secret(

);

DROP TABLE agents;
DROP TABLE top_secret;

INSERT INTO agents VALUES(1, 'Fox Mulder', '+1 205 555 0118', 'muldeg@corp.com', 1, 2, 2, 0);
INSERT INTO agents VALUES(2, 'Will Graham', '+1 205 555 0199', 'reddragon@corp.com', 1, 1, 1, 1);

SELECT * FROM agents;