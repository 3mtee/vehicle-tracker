package org.painsomnia.vehicletracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class GeoPointDto {
    private double lat;
    private double lon;

    @NotNull
    // add more checks if needed (regex or length)
    private String vin;
}
