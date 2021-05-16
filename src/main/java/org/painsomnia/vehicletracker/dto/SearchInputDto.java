package org.painsomnia.vehicletracker.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class SearchInputDto {
    @NotNull
    private GeoPointDto pointOne;
    @NotNull
    private GeoPointDto pointTwo;
}
