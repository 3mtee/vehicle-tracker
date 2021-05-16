package org.painsomnia.vehicletracker.repository;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    Vehicle getByVin(String vin);

    @Query(value = "select distinct v from Vehicle v, GeoPoint p where p.vehicle = v and intersects(p.point, :geometry) = true")
    Page<Vehicle> findVehiclesInRectangle(Geometry<G2D> geometry, Pageable pageable);
}
