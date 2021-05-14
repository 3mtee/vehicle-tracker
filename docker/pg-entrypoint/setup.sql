create table "Vehicle"
(
    id            uuid
        constraint vehicle_pk
            primary key,
    vin           varchar,
    license_plate varchar
);

create unique index vehicle_vin_uindex on "Vehicle" (vin);

create table geo_point
(
    id          uuid
        constraint geo_point_pk
            primary key,
    latitude    float,
    longitude   float,
    vehicle_id  uuid
        constraint vehicle_fk
            references "Vehicle",
    create_date date,
    update_date date
);

