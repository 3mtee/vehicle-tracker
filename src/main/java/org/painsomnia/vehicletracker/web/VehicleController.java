package org.painsomnia.vehicletracker.web;

import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> list() {
        return vehicleService.findAll();
        /*final VehicleDto vehicle = VehicleDto.builder()
                .withVin("VCAC123123131")
                .withLicensePlate("AA1234VV")
                .withLastLocation(new GeoPointDto())
                .build();
        return Collections.singletonList(vehicle);*/
    }
}
