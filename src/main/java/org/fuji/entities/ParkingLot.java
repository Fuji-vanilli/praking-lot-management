package org.fuji.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        for (int i= 0; i< slots.size(); i++) {
            for (int j= 0; j< slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.getType().equals(type) && Objects.isNull(slot.getVehicle())) {
                    slot.setVehicle(vehicle);
                    slot.setTicketId(generateTicketId(i+1, j+1));
                }
            }
        }

        System.out.println("No slot available for the moment!");
        return "";
    }

    private String generateTicketId(int floorNumber, int slotNumber) {
        return parkingLotId+"_"+floorNumber+"_"+slotNumber;
    }

    public void unPark(String ticketId) {
        String[] extract = ticketId.split("_");
        int floorIndex= Integer.parseInt(extract[1])- 1;
        int slotIndex= Integer.parseInt(extract[2])- 1;

        for (int i= 0; i< slots.size(); i++) {
            for (int j= 0; j< slots.get(i).size(); j++) {
                if (i== floorIndex && j== slotIndex) {
                    Slot slot = slots.get(i).get(j);
                    slot.setVehicle(null);
                    slot.setTicketId(null);
                    System.out.println("Unparked vehicle successfully");
                }
            }
        }
    }
}









