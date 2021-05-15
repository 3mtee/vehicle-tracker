package org.painsomnia.vehicletracker.config;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.modelmapper.ModelMapper;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.po.GeoPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(GeoPoint.class, GeoPointDto.class)
                .setConverter(context -> {
                    final GeoPoint source = context.getSource();
                    if (source == null) {
                        return null;
                    }
                    final Point<G2D> point = source.getPoint();
                    final G2D position = point.getPosition();
                    final String vin = source.getVehicle().getVin();
                    return new GeoPointDto(position.getLat(), position.getLon(), vin);
                });

        return modelMapper;
    }
}
