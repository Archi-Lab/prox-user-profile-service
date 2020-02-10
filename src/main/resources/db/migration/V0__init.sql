create table professor
(
    id              uuid not null,
    keycloakId      uuid not null,
    name           varchar(127),
    title           varchar(50),
    adresse         varchar(500),
    strasse         varchar(500),
    plz             varchar(500),
    raum            varchar(16),
    phoneNumber     varchar(50),
    mail            varchar (127),
    tags            varchar(3000),
    sprechzeiten    varchar (3000),
    aboutMe         varchar(3000),
    hasAboutMe      BOOLEAN,
    bildSrc         varchar (255),
    hasBild         BOOLEAN
    primary key (id)
);

create table student
(
    id              uuid not null,
    keycloakId      uuid not null,
    phoneNumber     varchar(50),
    mail            varchar(127),
    tags            varchar(3000),
    aboutMe         varchar(3000),
    hasAboutMe      BOOLEAN,
    studiengang     varchar(100),
    schwerpunkt     varchar(100),
    qualifikation   varchar(3000),
    doneModules     varchar(1000),
    doneJobs        varchar(1000)
    primary key (id)
);