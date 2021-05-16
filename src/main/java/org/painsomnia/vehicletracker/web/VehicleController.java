package org.painsomnia.vehicletracker.web;

import io.swagger.annotations.ApiOperation;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.SearchInputDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.dto.VehicleListDto;
import org.painsomnia.vehicletracker.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @ApiOperation("List all vehicles (limited fields)")
    public List<VehicleListDto> list() {
        return vehicleService.list();
    }

    @GetMapping("by-vin/{vin}")
    @ApiOperation("Get vehicle by VIN")
    public VehicleDto getByVin(@PathVariable String vin) {
        return vehicleService.getByVin(vin);
    }

    @PostMapping("by-geofence")
    @ApiOperation("Find all vehicles using rectangle geofence")
    public List<VehicleDto> findGeofenceVehicles(@Valid @RequestBody SearchInputDto input) {
        return vehicleService.findVehiclesInRectangle(input);
    }

    @GetMapping("fail")
    @ApiOperation("A test endpoint with a sole purpose of failing")
    public String fail() {
        throw new RuntimeException("oopsie-doopsie");
    }

    @PostMapping("gps")
    @ApiOperation("Register vehicle location")
    public VehicleDto registerVehiclePosition(@Valid @RequestBody GeoPointDto point) {
        return vehicleService.registerVehiclePosition(point);
    }
}
