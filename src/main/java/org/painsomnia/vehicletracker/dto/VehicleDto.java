package org.painsomnia.vehicletracker.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class VehicleDto {
    private String vin;
    private String licensePlate;
    private List<GeoPointDto> geoPoints = new ArrayList<>();
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
