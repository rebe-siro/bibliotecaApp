-- Table: public.recurso

 DROP TABLE IF EXISTS public.recurso;

CREATE TABLE IF NOT EXISTS public.recurso
(
    code integer NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    author character varying(255) COLLATE pg_catalog."default" NOT NULL,
    type integer NOT NULL,
    status bool NOT NULL,
    CONSTRAINT recurso_pkey PRIMARY KEY (code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.recurso
    OWNER to postgres;