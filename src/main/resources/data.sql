DROP TABLE IF EXISTS flights;

CREATE TABLE flights (
                              flight_id INTEGER PRIMARY KEY,
                              flight_number INTEGER NOT NULL,
                              departure_airport_IATA_code VARCHAR(3) NOT NULL,
                              arrival_airport_IATA_code VARCHAR(3) NOT NULL,
                              departure_date VARCHAR NOT NULL
);

INSERT INTO flights VALUES
(0,9058,'YYT','MIT','2021-03-10T06:18:37-01:00'),
(1,3479,'YYT','LEW','2020-11-07T10:47:09-01:00'),
(2,6312,'YYT','MIT','2021-01-25T01:48:41-01:00'),
(3,5201,'ANC','KRK','2014-08-17T08:22:13-02:00'),
(4,7236,'YYT','KRK','2017-04-19T02:23:42-02:00');

DROP TABLE IF EXISTS cargo;

CREATE TABLE cargo (
                              list_flightId INT NOT NULL,
                              list_baggage_id INT,
                              list_baggage_weight INT,
                              list_baggage_weightUnit VARCHAR(10),
                              list_baggage_pieces INT,
                              list_cargo_id INT,
                              list_cargo_weight INT,
                              list_cargo_weightUnit VARCHAR(10),
                              list_cargo_pieces INT
);

INSERT INTO cargo VALUES
(0,0,765,'kg',878,NULL,NULL,NULL,NULL),
(0,1,580,'kg',175,NULL,NULL,NULL,NULL),
(0,2,818,'kg',384,NULL,NULL,NULL,NULL),
(0,3,204,'lb',501,NULL,NULL,NULL,NULL),
(0,4,623,'kg',64,NULL,NULL,NULL,NULL),
(0,5,508,'lb',886,NULL,NULL,NULL,NULL),
(0,NULL,NULL,NULL,NULL,0,49,'kg',186),
(0,NULL,NULL,NULL,NULL,1,541,'lb',927),
(0,NULL,NULL,NULL,NULL,2,36,'lb',985),
(1,0,578,'lb',726,NULL,NULL,NULL,NULL),
(1,1,164,'lb',916,NULL,NULL,NULL,NULL),
(1,2,619,'kg',897,NULL,NULL,NULL,NULL),
(1,3,312,'lb',416,NULL,NULL,NULL,NULL),
(1,4,621,'lb',657,NULL,NULL,NULL,NULL),
(1,NULL,NULL,NULL,NULL,0,622,'kg',170),
(1,NULL,NULL,NULL,NULL,1,959,'lb',536),
(1,NULL,NULL,NULL,NULL,2,734,'lb',787),
(1,NULL,NULL,NULL,NULL,3,205,'lb',663),
(1,NULL,NULL,NULL,NULL,4,438,'kg',374),
(2,0,770,'kg',925,NULL,NULL,NULL,NULL),
(2,1,79,'lb',873,NULL,NULL,NULL,NULL),
(2,2,993,'lb',965,NULL,NULL,NULL,NULL),
(2,3,267,'lb',760,NULL,NULL,NULL,NULL),
(2,4,965,'lb',403,NULL,NULL,NULL,NULL),
(2,5,112,'lb',323,NULL,NULL,NULL,NULL),
(2,6,489,'kg',186,NULL,NULL,NULL,NULL),
(2,7,908,'lb',813,NULL,NULL,NULL,NULL),
(2,NULL,NULL,NULL,NULL,0,969,'kg',434),
(2,NULL,NULL,NULL,NULL,1,990,'kg',537),
(2,NULL,NULL,NULL,NULL,2,308,'lb',141),
(2,NULL,NULL,NULL,NULL,3,361,'kg',831),
(3,0,480,'lb',95,NULL,NULL,NULL,NULL),
(3,1,457,'kg',201,NULL,NULL,NULL,NULL),
(3,2,143,'lb',408,NULL,NULL,NULL,NULL),
(3,3,543,'lb',837,NULL,NULL,NULL,NULL),
(3,NULL,NULL,NULL,NULL,0,558,'lb',935),
(3,NULL,NULL,NULL,NULL,1,256,'lb',620),
(3,NULL,NULL,NULL,NULL,2,16,'kg',700),
(3,NULL,NULL,NULL,NULL,3,774,'kg',686),
(4,0,28,'kg',75,NULL,NULL,NULL,NULL),
(4,1,128,'lb',244,NULL,NULL,NULL,NULL),
(4,2,78,'kg',949,NULL,NULL,NULL,NULL),
(4,3,102,'lb',538,NULL,NULL,NULL,NULL),
(4,4,360,'kg',517,NULL,NULL,NULL,NULL),
(4,NULL,NULL,NULL,NULL,0,910,'lb',325),
(4,NULL,NULL,NULL,NULL,1,205,'lb',198),
(4,NULL,NULL,NULL,NULL,2,144,'kg',38);
