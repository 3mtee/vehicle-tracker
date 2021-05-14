package org.painsomnia.vehicletracker.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@javax.persistence.Entity
@Data
public class GeoPoint extends Entity {

    //todo: add validation
    @Column(nullable = false, columnDefinition = "decimal(8,6)")
    private double latitude;

    //todo: add validation
    @Column(nullable = false, columnDefinition = "decimal(9,6)")
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}
