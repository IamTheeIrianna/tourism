USE tourismdb;

CREATE TABLE cities (
                        CityID int NOT NULL AUTO_INCREMENT,
                        CityName varchar(45) NOT NULL,
                        Municipality varchar(100) NOT NULL,
                        RegionName varchar(45) NOT NULL,
                        RegionID int NOT NULL,
                        PRIMARY KEY (CityID, CityName),
                        UNIQUE KEY `Municipality_UNIQUE` (`Municipality`),
                        KEY RID_idx (RegionID),
                        KEY RN_idx (RegionName),
                        CONSTRAINT RID FOREIGN KEY (RegionID) REFERENCES regions (RegionID),
                        CONSTRAINT RN FOREIGN KEY (RegionName) REFERENCES regions (RegionName)
);


CREATE TABLE regions (
                         `RegionID` int NOT NULL AUTO_INCREMENT,
                         `RegionName` varchar(45) NOT NULL,
                         `Province` varchar(100) NOT NULL,
                         PRIMARY KEY (`RegionID`),
                         UNIQUE KEY `RegionName_UNIQUE` (`RegionName`),
                         UNIQUE KEY `Province_UNIQUE` (`Province`)
);

CREATE TABLE tags (
                      `tag_ID` int NOT NULL AUTO_INCREMENT,
                      `tag_name` varchar(45) NOT NULL,
                      PRIMARY KEY (`tag_ID`),
                      UNIQUE KEY `tag_name_UNIQUE` (`tag_name`)
);


CREATE TABLE touristattractions (
                                    `attractionID` int NOT NULL AUTO_INCREMENT,
                                    `attraction_name` varchar(100) NOT NULL,
                                    `CityName` varchar(45) NOT NULL,
                                    `CityID` int NOT NULL,
                                    `Municipality` varchar(45) NOT NULL,
                                    `Adress` varchar(100) NOT NULL,
                                    PRIMARY KEY (`attractionID`),
                                    KEY `CID_idx` (`CityID`),
                                    CONSTRAINT `CID` FOREIGN KEY (`CityID`) REFERENCES `cities` (`CityID`)
);

CREATE TABLE touristtags (
                             `attractionID` int NOT NULL,
                             `tagID` int NOT NULL,
                             PRIMARY KEY (`attractionID`,`tagID`),
                             KEY `TID_idx` (`tagID`),
                             CONSTRAINT `AID` FOREIGN KEY (`attractionID`) REFERENCES `touristattractions` (`attractionID`),
                             CONSTRAINT `TID` FOREIGN KEY (`tagID`) REFERENCES `tags` (`tag_ID`)
);


