create table car
(
  id           uuid not null
    constraint "Car_pkey"
    primary key,
  model        varchar(128),
  manufacturer varchar(128)
);

alter table car
  owner to postgres;

create table showroom
(
  id      uuid not null
    constraint showroom_pkey
    primary key,
  name    varchar(256),
  address varchar(256)
);

alter table showroom
  owner to postgres;

create unique index showroom_id_uindex
  on showroom (id);