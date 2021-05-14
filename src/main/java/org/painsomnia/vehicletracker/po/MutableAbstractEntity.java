package org.painsomnia.vehicletracker.po;

import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class MutableAbstractEntity extends AbstractEntity {

    protected LocalDateTime updateDate = LocalDateTime.now();

    @PreUpdate
    public void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
