CREATE TABLE userapp(
idU BIGINT AUTO_INCREMENT PRIMARY KEY,
name varchar(100) not null,
surname varchar(100),
email varchar(100) not null,
description varchar(100),
password varchar(250) not null,
age INT(3)
)

CREATE TABLE trip(
idT BIGINT AUTO_INCREMENT PRIMARY KEY,
tripName varchar(250) not null,
description varchar(250),
location varchar(250) not null,
startDate date not null,
endDate date not null
)

CREATE TABLE trip_user(
idTripUser BIGINT AUTO_INCREMENT PRIMARY KEY,
idUser BIGINT NOT NULL,
idTrip BIGINT NOT NULL,

FOREIGN KEY (idTrip) REFERENCES trip(idTrip),
FOREIGN KEY (idUser) REFERENCES user(idU)
)

CREATE TABLE comment(
idCom BIGINT AUTO_INCREMENT PRIMARY KEY,
datePosted date not null,
textComment varchar(250) not null,
idTrip BIGINT,
idUser BIGINT,

FOREIGN KEY (idTrip) REFERENCES trip(idT),
FOREIGN KEY (idUser) REFERENCES user(idU)
)

CREATE TABLE task(
idTask BIGINT AUTO_INCREMENT PRIMARY KEY,
taskInfo varchar(250) not null,
finished boolean not null,
idTrip BIGINT,

FOREIGN KEY (idTrip) REFERENCES trip(idT)
)

CREATE TABLE event(
idEvent BIGINT AUTO_INCREMENT PRIMARY KEY,
nameEvent varchar(250) not null,
eventType varchar(250),
description varchar(250),
startTime date not null,
endTime date not null,
ticketsBought boolean,
idTrip BIGINT,

FOREIGN KEY (idTrip) REFERENCES trip(idT)
)

CREATE TABLE expenses(
idExp BIGINT AUTO_INCREMENT PRIMARY KEY,
expenseDetails varchar(25) not null,
sum double not null,
idTrip BIGINT,

FOREIGN KEY (idTrip) REFERENCES trip(idT)
)