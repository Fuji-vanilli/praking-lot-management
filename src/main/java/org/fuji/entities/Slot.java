package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Slot {
    private String type;
    private Vehicle vehicle;
    private String ticketId;
}
