package org.painsomnia.vehicletracker.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@javax.persistence.Entity
@Data
public class Vehicle extends MutableEntity {
    @Column(unique = true, nullable = false)
    private String vin;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    @OneToMany(mappedBy = "vehicle")
    private List<GeoPoint> geoPoints;
}
