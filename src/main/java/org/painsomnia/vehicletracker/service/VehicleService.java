package org.painsomnia.vehicletracker.service;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.Polygon;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.dto.VehicleListDto;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.geolatte.geom.builder.DSL.*;
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

    public void saveAll(Iterable<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
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

    public List<VehicleDto> findVehiclesInRectangle(List<GeoPointDto> geofence) {
        final GeoPointDto geo0 = geofence.get(0);
        final GeoPointDto geo1 = geofence.get(1);

        final double lon1 = geo0.getLon();
        final double lat1 = geo0.getLat();
        final double lat2 = geo1.getLat();
        final double lon2 = geo1.getLon();

        final G2D p0 = g(lon1, lat1);
        final G2D p1 = g(lon1, lat2);
        final G2D p2 = g(lon2, lat2);
        final G2D p3 = g(lon2, lat1);
        final Polygon<G2D> polygon = polygon(WGS84, ring(p0, p1, p2, p3, p0));


        final Page<Vehicle> results = vehicleRepository.findVehiclesInRectangle(polygon, Pageable.unpaged());
        return modelMapper.map(results.getContent(), new TypeToken<List<VehicleDto>>() {
        }.getType());
    }
}
