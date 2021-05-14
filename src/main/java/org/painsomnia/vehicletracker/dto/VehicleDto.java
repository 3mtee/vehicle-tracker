package org.painsomnia.vehicletracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class VehicleDto {
    private String vin;
    private String licensePlate;
    private GeoPointDto lastLocation;
}
