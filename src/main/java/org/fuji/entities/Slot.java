package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Slot {
    private String type;
    private Vehicle vehicle;
    private String ticketId;

    public Slot(String type) {
        this.type= type;
    }

    public Slot(String type, Vehicle vehicle) {
        this.type= type;
        this.vehicle= vehicle;
    }
}
