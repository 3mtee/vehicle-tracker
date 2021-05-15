package org.painsomnia.vehicletracker.service;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.dto.VehicleListDto;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    public List<VehicleListDto> list() {
        final List<Vehicle> vehicles = vehicleRepository.findAll();
        return modelMapper.map(vehicles, new TypeToken<List<VehicleListDto>>() {
        }.getType());
    }

    public List<VehicleDto> listFull() {
        final List<Vehicle> vehicles = vehicleRepository.findAll();
        return modelMapper.map(vehicles, new TypeToken<List<VehicleListDto>>() {
        }.getType());
    }

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

    public VehicleDto registerVehiclePosition(GeoPointDto pointDto) {
        final Vehicle vehicle = vehicleRepository.getByVin(pointDto.getVin());
        final Point<G2D> point = point(WGS84, g(pointDto.getLon(), pointDto.getLat()));
        vehicle.addGeoPoint(point);
        vehicleRepository.save(vehicle);
        return modelMapper.map(vehicle, VehicleDto.class);
    }
}
