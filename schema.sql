-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

-- Drop table

-- DROP TABLE public.employer;

CREATE TABLE public.employer (
	id int4 NOT NULL,
	employer_name varchar(255) NULL,
	CONSTRAINT employer_pkey PRIMARY KEY (id),
	CONSTRAINT employer_un UNIQUE (employer_name)
);

-- Drop table

-- DROP TABLE public.employee;

CREATE TABLE public.employee (
	id int4 NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	salary int8 NULL,
	employer_id int4 NOT NULL,
	CONSTRAINT employee_pkey null,
	CONSTRAINT fkrmknjkdeoo3molal1gxkt9dar null
);

-- Drop table

-- DROP TABLE public.dependant;

CREATE TABLE public.dependant (
	id int4 NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	employee_id int4 NOT NULL,
	CONSTRAINT dependant_pkey null,
	CONSTRAINT fk265u0yuv2y6pmap40bftks16r null
);
