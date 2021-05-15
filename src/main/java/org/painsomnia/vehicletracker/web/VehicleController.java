package org.painsomnia.vehicletracker.web;

import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.dto.VehicleListDto;
import org.painsomnia.vehicletracker.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleListDto> list() {
        return vehicleService.list();
    }

    @GetMapping("by-vin/{vin}")
    public VehicleDto getByVin(@PathVariable String vin) {
        return vehicleService.getByVin(vin);
    }

    @PostMapping("by-geofence")
    public List<VehicleDto> findGeofenceVehicles(@RequestBody List<GeoPointDto> geofence) {
//        todo: implement properly
        return vehicleService.listFull();
    }

    @PostMapping("gps")
    public VehicleDto registerVehiclePosition(@RequestBody GeoPointDto point) {
        return vehicleService.registerVehiclePosition(point);
    }
}
