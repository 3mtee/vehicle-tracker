package org.painsomnia.vehicletracker.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class GeoPoint extends AbstractEntity {

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
