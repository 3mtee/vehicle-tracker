package org.painsomnia.vehicletracker.service;

import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() {
        // todo: convert to dto
        return vehicleRepository.findAll();
    }
}
