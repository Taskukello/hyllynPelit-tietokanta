CREATE TABLE Pelialusta (
     Pelialusta varchar(50) PRIMARY KEY
     );

CREATE TABLE Peli (
     PelinNimi varchar(50) PRIMARY KEY ,
     Julkaisuvuosi numeric(4) NOT NULL ,
     Tekijä Varchar(50) NOT NULL,
     MilloinLisätty timestamp(6) NOT NULL ,
     Pelialusta varchar(50) references Pelialusta(Pelialusta) 
     );

CREATE TABLE Arvostelu (
     id SERIAL PRIMARY KEY,
     PelinNimi varchar(50) NOT NULL ,
     Julkaisuvuosi numeric(4) NOT NULL ,
     arvosana numeric(2) NOT NULL,
     ArvostelunLisaysPaiva timestamp(8) NOT NULL ,
     tunnus varchar(50) NOT NULL,
     CONSTRAINT Arvostelu_PelinNimi_fkey FOREIGN KEY (PelinNimi)
     REFERENCES Peli (PelinNimi) MATCH SIMPLE
     ON UPDATE NO ACTION ON DELETE NO ACTION
     );


CREATE TABLE ArvosteluKommentti (
     Arvostelun_ID INTEGER REFERENCES Arvostelu(id),
     kuvailu varchar(300) NOT NULL
     

     );

CREATE TABLE Kommentti (
     id SERIAL PRIMARY KEY,
     PelinNimi varchar(50) NOT NULL ,
     Kommentti varchar(500) NOT NULL,
     tunnus varchar(50) NOT NULL,
     CONSTRAINT Kommentti_PelinNimi_fkey FOREIGN KEY (PelinNimi)
     REFERENCES Peli (PelinNimi) MATCH SIMPLE
     ON UPDATE NO ACTION ON DELETE NO ACTION
     );



CREATE TABLE Kayttaja (
     id SERIAL PRIMARY KEY,
     tunnus varchar(50),
     salasana Varchar(50)

     );


