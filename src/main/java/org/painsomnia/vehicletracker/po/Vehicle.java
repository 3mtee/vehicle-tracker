package org.painsomnia.vehicletracker.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String vin;

    @Column(unique = true, nullable = false)
    private String licensePlate;

}
