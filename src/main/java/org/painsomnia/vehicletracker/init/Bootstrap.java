package org.painsomnia.vehicletracker.init;

import org.apache.commons.lang3.RandomStringUtils;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.service.VehicleService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap {

    private static final int INITIAL_VEHICLE_COUNT = 50;
    private final VehicleService vehicleService;

    public Bootstrap(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void bootstrap() {
        if (vehicleService.countEntities() == 0) {
            final List<Vehicle> vehicles = new ArrayList<>(INITIAL_VEHICLE_COUNT);
            for (int i = 0; i < INITIAL_VEHICLE_COUNT; i++) {
                final Vehicle vehicle = new Vehicle();
                vehicle.setVin(RandomStringUtils.random(13, true, true));
                vehicle.setLicensePlate(RandomStringUtils.random(5, true, true));
                vehicles.add(vehicle);
            }
            vehicleService.saveAll(vehicles);
        }
    }
}
