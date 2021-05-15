package org.painsomnia.vehicletracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoPointDto {
    private double lat;
    private double lon;

    @NotNull
    // add more checks if needed (regex or length)
    private String vin;
}
