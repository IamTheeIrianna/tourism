use tourismdb;
INSERT INTO cities (CityName)
VALUES
    ('Copenhagen'),
    ('Herning'),
    ('Aalborg'),
    ('Odense'),
    ('Aarhus'),
    ('Esbjerg'),
    ('Billund'),
    ('Bornholm'),
    ('Helsingør'),
    ('Skagen');
INSERT INTO tags(tagName)
values
    ('FREE'),
    ('MUSEUM'),
    ('THEMEPARK'),
    ('WATERPARK'),
    ('NATURE'),
    ('GARDENS'),
    ('RESTAURANT'),
    ('ENTERTAINMENT'),
    ('DESIGN'),
    ('KIDS');

INSERT INTO touristattractions (attractionName, AttractionDescription, CityID, Adress)
values
    ('Tivoli','','',''),
    ('','','',''),
    ('','','',''),
    ('','','',''),
    ('','','','');

INSERT INTO attractionstags(attractionID, tagID)
values
    ('', ''),
    ('', ''),
    ('', ''),
    ('', ''),
    ('', '');




