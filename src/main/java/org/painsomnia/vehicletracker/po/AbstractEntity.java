package org.painsomnia.vehicletracker.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    protected UUID id;

    protected LocalDateTime createDate = LocalDateTime.now();

}
