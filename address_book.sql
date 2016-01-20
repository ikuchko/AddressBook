--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: addresses; Type: TABLE; Schema: public; Owner: iliak; Tablespace:
--

CREATE TABLE addresses (
    id integer NOT NULL,
    street character varying(30),
    city character varying(15),
    state character varying(25),
    zip_code integer,
    type character varying(10),
    contact_id integer,
    apartment character varying(10)
);


ALTER TABLE addresses OWNER TO iliak;

--
-- Name: addresses_id_seq; Type: SEQUENCE; Schema: public; Owner: iliak
--

CREATE SEQUENCE addresses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE addresses_id_seq OWNER TO iliak;

--
-- Name: addresses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: iliak
--

ALTER SEQUENCE addresses_id_seq OWNED BY addresses.id;


--
-- Name: contacts; Type: TABLE; Schema: public; Owner: iliak; Tablespace:
--

CREATE TABLE contacts (
    id integer NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    birth_date date
);


ALTER TABLE contacts OWNER TO iliak;

--
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: public; Owner: iliak
--

CREATE SEQUENCE contacts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contacts_id_seq OWNER TO iliak;

--
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: iliak
--

ALTER SEQUENCE contacts_id_seq OWNED BY contacts.id;


--
-- Name: emails; Type: TABLE; Schema: public; Owner: iliak; Tablespace:
--

CREATE TABLE emails (
    id integer NOT NULL,
    email character varying(30),
    type character varying(10),
    contact_id integer
);


ALTER TABLE emails OWNER TO iliak;

--
-- Name: emails_id_seq; Type: SEQUENCE; Schema: public; Owner: iliak
--

CREATE SEQUENCE emails_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE emails_id_seq OWNER TO iliak;

--
-- Name: emails_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: iliak
--

ALTER SEQUENCE emails_id_seq OWNED BY emails.id;


--
-- Name: phones; Type: TABLE; Schema: public; Owner: iliak; Tablespace:
--

CREATE TABLE phones (
    id integer NOT NULL,
    area_code integer,
    phone integer,
    type character varying(10),
    contact_id integer
);


ALTER TABLE phones OWNER TO iliak;

--
-- Name: phones_id_seq; Type: SEQUENCE; Schema: public; Owner: iliak
--

CREATE SEQUENCE phones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE phones_id_seq OWNER TO iliak;

--
-- Name: phones_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: iliak
--

ALTER SEQUENCE phones_id_seq OWNED BY phones.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: iliak
--

ALTER TABLE ONLY addresses ALTER COLUMN id SET DEFAULT nextval('addresses_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: iliak
--

ALTER TABLE ONLY contacts ALTER COLUMN id SET DEFAULT nextval('contacts_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: iliak
--

ALTER TABLE ONLY emails ALTER COLUMN id SET DEFAULT nextval('emails_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: iliak
--

ALTER TABLE ONLY phones ALTER COLUMN id SET DEFAULT nextval('phones_id_seq'::regclass);


--
-- Data for Name: addresses; Type: TABLE DATA; Schema: public; Owner: iliak
--

COPY addresses (id, street, city, state, zip_code, type, contact_id, apartment) FROM stdin;
\.


--
-- Name: addresses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: iliak
--

SELECT pg_catalog.setval('addresses_id_seq', 1, false);


--
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: iliak
--

COPY contacts (id, first_name, last_name, birth_date) FROM stdin;
\.


--
-- Name: contacts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: iliak
--

SELECT pg_catalog.setval('contacts_id_seq', 3, true);


--
-- Data for Name: emails; Type: TABLE DATA; Schema: public; Owner: iliak
--

COPY emails (id, email, type, contact_id) FROM stdin;
\.


--
-- Name: emails_id_seq; Type: SEQUENCE SET; Schema: public; Owner: iliak
--

SELECT pg_catalog.setval('emails_id_seq', 1, false);


--
-- Data for Name: phones; Type: TABLE DATA; Schema: public; Owner: iliak
--

COPY phones (id, area_code, phone, type, contact_id) FROM stdin;
\.


--
-- Name: phones_id_seq; Type: SEQUENCE SET; Schema: public; Owner: iliak
--

SELECT pg_catalog.setval('phones_id_seq', 2, true);


--
-- Name: addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: iliak; Tablespace:
--

ALTER TABLE ONLY addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (id);


--
-- Name: contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: iliak; Tablespace:
--

ALTER TABLE ONLY contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


--
-- Name: emails_pkey; Type: CONSTRAINT; Schema: public; Owner: iliak; Tablespace:
--

ALTER TABLE ONLY emails
    ADD CONSTRAINT emails_pkey PRIMARY KEY (id);


--
-- Name: phones_pkey; Type: CONSTRAINT; Schema: public; Owner: iliak; Tablespace:
--

ALTER TABLE ONLY phones
    ADD CONSTRAINT phones_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
