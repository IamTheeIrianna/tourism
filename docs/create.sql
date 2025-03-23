Create DATABASE tourismdb;
USE tourismdb;

CREATE TABLE cities (

                        PRIMARY KEY (CityID, CityName),
                        `CityName` varchar(45) NOT NULL unique ,
                        `CityID` int NOT NULL AUTO_INCREMENT PRIMARY KEY
                       );


CREATE TABLE tags (
                        `tagID` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                        `tagName` varchar(45) NOT NULL unique
);


CREATE TABLE touristattractions (
                                      `attractionID` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                                      `attractionName` varchar(100) NOT NULL unique,
                                      `CityName` varchar(45) NOT NULL,
                                      `CityID` int NOT NULL,
                                      `Adress` varchar(100) unique,
                                      FOREIGN KEY (`CityID`) REFERENCES cities(CityID)

);

CREATE TABLE touristtags (
                               `attractionID` int NOT NULL,
                               `tagID` int NOT NULL,
                               PRIMARY KEY (`attractionID`,`tagID`),
                               KEY `TID_idx` (`tagID`),
                               FOREIGN KEY(AttractionID) REFERENCES tourismdb.touristattractions(AttractionID) ON DELETE CASCADE,
                               FOREIGN KEY(TagID) REFERENCES tags(TagID) ON DELETE CASCADE
);

