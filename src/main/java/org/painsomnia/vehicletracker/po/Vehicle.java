package org.painsomnia.vehicletracker.po;

import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vehicle extends MutableAbstractEntity {
    @Column(unique = true, nullable = false)
    private String vin;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<GeoPoint> geoPoints = new ArrayList<>();

    public boolean addGeoPoint(Point<G2D> point) {
        return this.getGeoPoints().add(new GeoPoint(point, this));
    }
}
