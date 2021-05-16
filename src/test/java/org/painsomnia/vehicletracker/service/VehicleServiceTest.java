package org.painsomnia.vehicletracker.service;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.painsomnia.vehicletracker.config.AppConfig;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.dto.SearchInputDto;
import org.painsomnia.vehicletracker.dto.VehicleDto;
import org.painsomnia.vehicletracker.po.GeoPoint;
import org.painsomnia.vehicletracker.po.Vehicle;
import org.painsomnia.vehicletracker.repository.VehicleRepository;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.List;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    private final ModelMapper mapper = new AppConfig().modelMapper();
    private final VehicleRepository vehicleRepository = mock(VehicleRepository.class);
    private final VehicleService service = new VehicleService(vehicleRepository, mapper);


    @Test
    void testFindVehiclesInRectangle() {
        final SearchInputDto geofence = new SearchInputDto()
                .setPointOne(new GeoPointDto().setLat(-89).setLon(-89))
                .setPointTwo(new GeoPointDto().setLat(89).setLon(89));

        final Vehicle expected = new Vehicle();
        expected.setVin("12345");
        expected.setLicensePlate("12345");
        final Point<G2D> point = point(WGS84, g(1, 2));
        final GeoPoint geoPoint = new GeoPoint(point, expected);
        expected.setGeoPoints(Collections.singletonList(geoPoint));
        when(vehicleRepository.findVehiclesInRectangle(any(), any()))
                .thenReturn(new PageImpl<>(Collections.singletonList(expected)));

        final List<VehicleDto> vehicles = service.findVehiclesInRectangle(geofence);

        assertIterableEquals(
                vehicles,
                Collections.singletonList(
                        new VehicleDto()
                                .setGeoPoints(Collections.singletonList(new GeoPointDto(2, 1, "12345")))
                                .setVin("12345")
                                .setLicensePlate("12345")
                                .setCreateDate(expected.getCreateDate())
                                .setUpdateDate(expected.getUpdateDate())
                )
        );
    }

}
