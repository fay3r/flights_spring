DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight
(
    flight_id                   INTEGER PRIMARY KEY,
    flight_number               INTEGER    NOT NULL,
    departure_airport_IATA_code VARCHAR(3) NOT NULL,
    arrival_airport_IATA_code   VARCHAR(3) NOT NULL,
    departure_date              VARCHAR    NOT NULL
);

INSERT INTO Flight
VALUES (1, 9058, 'YYT', 'MIT', '2021-03-10T06:18:37-01:00'),
       (2, 3479, 'YYT', 'LEW', '2020-11-07T10:47:09-01:00'),
       (3, 6312, 'YYT', 'MIT', '2021-01-25T01:48:41-01:00'),
       (4, 5201, 'ANC', 'KRK', '2014-08-17T08:22:13-02:00'),
       (5, 7236, 'YYT', 'KRK', '2017-04-19T02:23:42-02:00');

DROP TABLE IF EXISTS Cargo;
DROP TABLE IF EXISTS Baggage;

CREATE TABLE Cargo
(
    id_flight   Integer NOT NULL,
    id_cargo    Bigint  NOT NULL,
    weight      Bigint,
    weight_unit varchar(5),
    pieces      Bigint
);

INSERT INTO cargo
VALUES (1, 5, 622, 'kg', 170),
       (1, 1, 959, 'lb', 536),
       (1, 2, 734, 'lb', 787),
       (1, 3, 205, 'lb', 663),
       (1, 4, 438, 'kg', 374),
       (2, 4, 969, 'kg', 434),
       (2, 1, 990, 'kg', 537),
       (2, 2, 308, 'lb', 141),
       (2, 3, 361, 'kg', 831),
       (3, 4, 558, 'lb', 935),
       (3, 1, 256, 'lb', 620),
       (3, 2, 16, 'kg', 700),
       (3, 3, 774, 'kg', 686),
       (4, 3, 910, 'lb', 325),
       (4, 1, 205, 'lb', 198),
       (4, 2, 144, 'kg', 38),
       (5, 3, 49, 'kg', 186),
       (5, 1, 541, 'lb', 927),
       (5, 2, 36, 'lb', 985);

CREATE TABLE Baggage
(
    id_flight   Integer NOT NULL,
    id_baggage  Bigint  NOT NULL,
    weight      Bigint,
    weight_unit varchar(5),
    pieces      Bigint
);

INSERT INTO Baggage
VALUES (1, 5, 578, 'lb', 726),
       (1, 1, 164, 'lb', 916),
       (1, 2, 619, 'kg', 897),
       (1, 3, 312, 'lb', 416),
       (1, 4, 621, 'lb', 657),
       (2, 8, 770, 'kg', 925),
       (2, 1, 79, 'lb', 873),
       (2, 2, 993, 'lb', 965),
       (2, 3, 267, 'lb', 760),
       (2, 4, 965, 'lb', 403),
       (2, 5, 112, 'lb', 323),
       (2, 6, 489, 'kg', 186),
       (2, 7, 908, 'lb', 813),
       (3, 4, 480, 'lb', 95),
       (3, 1, 457, 'kg', 201),
       (3, 2, 143, 'lb', 408),
       (3, 3, 543, 'lb', 837),
       (4, 5, 28, 'kg', 75),
       (4, 1, 128, 'lb', 244),
       (4, 2, 78, 'kg', 949),
       (4, 3, 102, 'lb', 538),
       (4, 4, 360, 'kg', 517),
       (5, 6, 765, 'kg', 878),
       (5, 1, 580, 'kg', 175),
       (5, 2, 818, 'kg', 384),
       (5, 3, 204, 'lb', 501),
       (5, 4, 623, 'kg', 64),
       (5, 5, 508, 'lb', 886);





