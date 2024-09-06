package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ParkingLot {
    private String parkingLotId;
    private List<List<Slot>> slots;

    public ParkingLot(int numberFloors, int numberOfSlotPerFloor) {
        this.parkingLotId= UUID.randomUUID().toString();
        this.slots= new ArrayList<>();

        for (int i= 0; i< numberFloors; i++) {
            List<Slot> floorSlots= List.of(new Slot("bike"), new Slot("moto"), new Slot("truck"));

            slots.add(floorSlots);
            for (int j= 3; j< numberOfSlotPerFloor; j++) {
                slots.get(i).add(new Slot("car"));
            }
        }
    }

    public String parkVehicle(String type, String regNo, String color) {
        Vehicle vehicle= new Vehicle(type, regNo, color);
        return "";
    }
}









