  CREATE TABLE information (
	ifm_id SERIAL PRIMARY KEY NOT NULL,
	ifm_lname VARCHAR(64) NOT NULL,
	ifm_fname VARCHAR(64) NOT NULL,
	ifm_birthday DATE NOT NULL,
	ifm_address TEXT NOT NULL,
	ifm_zip CHAR(5) NOT NULL,
	ifm_city VARCHAR(128) NOT NULL,
	ifm_phone VARCHAR(14) NOT  NULL
 );
 
INSERT INTO information (ifm_lname, ifm_fname, ifm_birthday, ifm_address,
    ifm_zip, ifm_city, ifm_phone) VALUES ('House', 'Gregory', '15-05-1959', 'Appartement B, 221 Baker Street',
    '08541', 'Princeton, New Jersey', '416-322-3303');
INSERT INTO information (ifm_lname, ifm_fname, ifm_birthday, ifm_address,
    ifm_zip, ifm_city, ifm_phone) VALUES ('PELDI', 'William', '15-08-1964', '12, Rue de la Paix',
    '75018', 'Paris', '06.37.38.37.83');

 CREATE TABLE role (
	rl_id SERIAL PRIMARY KEY NOT NULL,
	rl_name VARCHAR(128)
 );

INSERT INTO role (rl_name) VALUES ('medecin');
 
 CREATE TABLE staff (
	stf_id SERIAL PRIMARY KEY NOT NULL,
	stf_username VARCHAR(24) NOT NULL,
	stf_password VARCHAR(64) NOT NULL,
	ifm_id INT NOT NULL REFERENCES information(ifm_id),
	rl_id INT NOT NULL REFERENCES role(rl_id)
	
 );

INSERT INTO staff (stf_username, stf_password, ifm_id, rl_id) VALUES ('dr.house@gmail.com', 'azerty', 1, 1);

 CREATE TABLE doctor (
	dtr_id SERIAL PRIMARY KEY NOT NULL,
	dtr_status INT NOT NULL,
	ifm_id INT NOT NULL REFERENCES information(ifm_id)
 );
 
 CREATE TABLE disease (
	dss_id SERIAL PRIMARY KEY NOT NULL,
	dss_name VARCHAR(255) NOT NULL
 );
 
 CREATE TABLE medical_record (
	mdr_id SERIAL PRIMARY KEY NOT NULL,
	mdr_created TIMESTAMP NOT NULL,
	mdr_last_modification TIMESTAMP,
	mdr_last_consultation TIMESTAMP,
	mdr_last_backup TIMESTAMP,
	ifm_id INT NOT NULL REFERENCES information(ifm_id),
	dtr_id INT REFERENCES doctor(dtr_id),
	rl_id INT REFERENCES role(rl_id)
 );

INSERT INTO medical_record (mdr_created, ifm_id, rl_id) VALUES (current_timestamp, 2, 1);
 
 CREATE TABLE dss_mdr (
	dss_id INT NOT NULL REFERENCES disease(dss_id),
	mdr_id INT NOT NULL REFERENCES medical_record(mdr_id)
 );

 CREATE TABLE report (
	rpt_id SERIAL PRIMARY KEY NOT NULL,
	rpt_content TEXT NOT NULL,
	rpt_created TIMESTAMP NOT NULL
 );
 
 CREATE TABLE attachement (
	atc_id SERIAL PRIMARY KEY NOT NULL,
	atc_type INT NOT NULL,
	atc_link VARCHAR(128) NOT NULL
 );
 
 CREATE TABLE rpt_atc (
	rpt_id INT NOT NULL REFERENCES report(rpt_id) NOT NULL,
	atc_id INT NOT NULL REFERENCES attachement(atc_id) NOT NULL
 );

 CREATE TABLE rpt_mdr (
	rpt_id INT NOT NULL REFERENCES report(rpt_id),
	mdr_id INT NOT NULL REFERENCES medical_record(mdr_id)
 );

CREATE TABLE hospital (
    hpt_id SERIAL PRIMARY KEY NOT NULL,
    hpt_name VARCHAR(255) NOT NULL,
    hpt_address TEXT NOT NULL,
    hpt_zip INT NOT NULL,
    hpt_city VARCHAR(128)
);

CREATE TABLE division (
    dvs_id SERIAL PRIMARY KEY NOT NULL,
    dvs_name VARCHAR(255) NOT NULL,
    hpt_id INT NOT NULL REFERENCES hospital(hpt_id)
);

CREATE TABLE service (
    svc_id SERIAL PRIMARY KEY NOT NULL,
    svc_name VARCHAR(255) NOT NULL,
    dvs_id INT NOT NULL REFERENCES division(dvs_id)
);

CREATE TABLE functional_unit (
    fu_id SERIAL PRIMARY KEY NOT NULL,
    fu_name VARCHAR(255) NOT NULL,
    svc_id INT NOT NULL REFERENCES service(svc_id)
);

CREATE TABLE care_unit (
    cu_id SERIAL PRIMARY KEY NOT NULL,
    cu_name VARCHAR(255) NOT NULL,
    fu_id INT NOT NULL REFERENCES functional_unit(fu_id)
);
 
 CREATE TABLE rl_org (
	rl_id INT NOT NULL REFERENCES role(rl_id),
	hpt_id INT REFERENCES hospital(hpt_id),
	dvs_id INT REFERENCES division(dvs_id),
	svc_id INT REFERENCES service(svc_id),
	fu_id INT REFERENCES functional_unit(fu_id),
	cu_id INT REFERENCES care_unit(cu_id)
 );