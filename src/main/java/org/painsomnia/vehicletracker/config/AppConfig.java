package org.painsomnia.vehicletracker.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.painsomnia.vehicletracker.dto.GeoPointDto;
import org.painsomnia.vehicletracker.po.GeoPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        final TypeMap<GeoPoint, GeoPointDto> geoPointMap = modelMapper.createTypeMap(GeoPoint.class, GeoPointDto.class);
        geoPointMap.addMapping(GeoPoint::getLatitude, GeoPointDto::setLat);
        geoPointMap.addMapping(GeoPoint::getLatitude, GeoPointDto::setLon);

        return modelMapper;
    }
}
