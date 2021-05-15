package org.painsomnia.vehicletracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoPointDto {
    private double lat;
    private double lon;
    private String vin;
}
