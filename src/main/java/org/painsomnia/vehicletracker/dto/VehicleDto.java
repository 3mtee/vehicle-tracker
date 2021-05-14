package org.painsomnia.vehicletracker.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class VehicleDto {
    private String vin;
    private String licensePlate;
    private List<GeoPointDto> geoPoints = new ArrayList<>();
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
