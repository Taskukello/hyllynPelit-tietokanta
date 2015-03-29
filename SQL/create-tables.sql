CREATE TABLE Pelialusta (
     Pelialusta varchar(50) PRIMARY KEY
     );

CREATE TABLE Peli (
     PelinNimi varchar(50) PRIMARY KEY ,
     Julkaisuvuosi numeric(4) NOT NULL ,
     Tekijä Varchar(50) NOT NULL,
     MilloinLisätty date NOT NULL ,
     Pelialusta varchar(50) references Pelialusta(Pelialusta) 
     );

CREATE TABLE Arvostelu (
     id SERIAL PRIMARY KEY,
     PelinNimi varchar(50) references Peli(PelinNimi),
     Julkaisuvuosi numeric(4) NOT NULL ,
     arvosana numeric(2) NOT NULL,
     ArvostelunLisaysPaiva timestamp(6) NOT NULL 
   


     );

CREATE TABLE ArvosteluKommentti (
     Arvostelun_ID INTEGER REFERENCES Arvostelu(id),
     kuvailu varchar(300) NOT NULL
     

     );

CREATE TABLE Kommentti (
     PelinNimi varchar(50) references Peli(PelinNimi),
     Kommentti varchar(300) NOT NULL
     
     );


CREATE TABLE Kayttaja (
     id SERIAL PRIMARY KEY,
     tunnus varchar(50),
     salasana Varchar(50)

     );


