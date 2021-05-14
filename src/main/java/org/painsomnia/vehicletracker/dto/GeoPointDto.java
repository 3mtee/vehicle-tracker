package org.painsomnia.vehicletracker.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GeoPointDto {
    private double latitude;
    private double longitude;
    private Date createDate;

}
