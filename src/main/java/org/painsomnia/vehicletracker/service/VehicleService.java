package org.painsomnia.vehicletracker.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.dto.VehicleListDto;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    public List<VehicleListDto> findAll() {
        final List<Vehicle> vehicles = vehicleRepository.findAll();
        return modelMapper.map(vehicles, new TypeToken<List<VehicleListDto>>() {
        }.getType());
    }

    // todo: consider pulling up
    public List<Vehicle> saveAll(Iterable<Vehicle> vehicles) {
        return vehicleRepository.saveAll(vehicles);
    }

    public long countEntities() {
        return vehicleRepository.count();
    }

    public VehicleDto getByVin(String vin) {
        final Vehicle vehicle = vehicleRepository.getByVin(vin);
        return modelMapper.map(vehicle, VehicleDto.class);
    }
}
