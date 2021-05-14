create table vehicle
(
id            uuid         not null
    constraint vehicle_pkey primary key,
license_plate varchar(255) not null
    constraint uk_veh_lic_plat unique,
vin           varchar(255) not null
    constraint uk_veh_vin
        unique
);

alter table vehicle
    owner to postgres;


--
-- create table geo_point
-- (
--     id          uuid
--         constraint geo_point_pk
--             primary key,
--     latitude    float,
--     longitude   float,
--     vehicle_id  uuid
--         constraint vehicle_fk
--             references "Vehicle",
--     create_date date,
--     update_date date
-- );
--
