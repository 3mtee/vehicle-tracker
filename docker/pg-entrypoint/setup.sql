CREATE EXTENSION postgis;

create table vehicle
(
id            uuid         not null
    constraint vehicle_pkey
        primary key,
create_date   timestamp,
update_date   timestamp,
license_plate varchar(255) not null
    constraint uk_j5v3su3bdx4bvsk1t9dga4bsq
        unique,
vin           varchar(255) not null
    constraint uk_3vyjrop7rn1kcnfdhvlfthoc3
        unique
);

alter table vehicle
    owner to postgres;

create table geo_point
(
id          uuid not null
    constraint geo_point_pkey
        primary key,
create_date timestamp,
point       geometry,
vehicle_id  uuid not null
    constraint fk1ld421fed680m8cmby80y79r9
        references vehicle
);

alter table geo_point
    owner to postgres;
