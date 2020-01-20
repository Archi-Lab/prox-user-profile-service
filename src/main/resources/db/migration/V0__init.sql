create table professor
(
    id              uuid not null,
    firstName       varchar(127),
    lastName        varchar(127),
    title           int4,
    description     varchar(3000),
    hasDescription  BOOLEAN,
    raum            varchar(16),
    telefonummer    bigint,
    email           varchar (127),
    sprechzeiten    varchar(64),
    bildSrc         varchar (255),
    hasBild         BOOLEAN,
    fachgebiet      int4,
    primary key (id)
);
