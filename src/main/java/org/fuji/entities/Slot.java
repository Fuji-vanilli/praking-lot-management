package org.fuji.entities;

import lombok.Data;

@Data
public class Slot {
    private String type;
    private Vehicle vehicle;
    private String ticketId;
}
