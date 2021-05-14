package org.painsomnia.vehicletracker.web;

import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @GetMapping
    public List<VehicleDto> list() {
        final VehicleDto vehicle = VehicleDto.builder()
                .withVin("VCAC123123131")
                .withLicensePlate("AA1234VV")
                .withLastLocation(new GeoPointDto())
                .build();
        return Collections.singletonList(vehicle);
    }
}
