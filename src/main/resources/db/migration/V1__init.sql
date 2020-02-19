create table module
(
    id          uuid not null,
    description varchar(9000),
    name        varchar(255),
    module_id   uuid,
    primary key (id)
);

create table professor
(
    id           uuid not null,
    about_me     varchar(255),
    has_about_me boolean not null,
    adresse      varchar(255),
    bild_src     varchar(255),
    has_bild     boolean not null,
    keycloak_id  uuid,
    mail         varchar(255),
    name         varchar(255),
    phonenumber  varchar(255),
    plz          varchar(255),
    raum         varchar(255),
    sprechzeiten varchar(255),
    strasse      varchar(255),
    tags         bytea,
    title        varchar(255),
    primary key (id)
);

create table student_table
(
    id            uuid not null,
    about_me      varchar(255),
    has_about_me  boolean not null,
    done_jobs     varchar(255),
    done_modules  bytea,
    keycloak_id   uuid,
    mail          varchar(255),
    name          varchar(255),
    phonenumber   varchar(255),
    qualifikation varchar(255),
    schwerpunkt   varchar(255),
    status        varchar(255),
    studiengang   varchar(255),
    tags          bytea,
    primary key (id)
);

create table study_course
(
    id                     uuid not null,
    academic_degree        int4,
    name                   varchar(255),
    primary key (id)
);

alter table module
  add constraint FK_module_study_course
    foreign key (module_id) references study_course;
