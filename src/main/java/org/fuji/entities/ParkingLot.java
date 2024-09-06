package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ParkingLot {
    private String parkingLotId;
    private List<List<Slot>> slots;
}
