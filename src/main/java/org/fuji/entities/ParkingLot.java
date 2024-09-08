package org.fuji.entities;

import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class ParkingLot {
    private String parkingLotId;
    private List<List<Slot>> slots;

    public ParkingLot(String parkingLotId, int numberFloors, int numberOfSlotPerFloor) {
        this.parkingLotId= parkingLotId;
        this.slots= new ArrayList<>();

        for (int i= 0; i< numberFloors; i++) {
            List<Slot> floorSlots= new ArrayList<>();
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("moto"));
            floorSlots.add(new Slot("truck"));

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

                    return slot.getTicketId();
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
                    System.out.println("Unpark vehicle successfully");
                }
            }
        }
    }

    public int getNumberOfOpenSlots(String type) {
        AtomicInteger count= new AtomicInteger();
        slots.forEach(floors-> {
            floors.forEach(slot -> {
                if (Objects.isNull(slot.getVehicle()) && slot.getType().equals(type)) {
                    count.getAndIncrement();
                }
            });
        });

        return count.get();
    }

    public void displayOpenSlots(String type) {
        for (int i= 0; i< slots.size(); i++)
            for (int j= 0; j< slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (Objects.isNull(slot.getVehicle()) && slot.getType().equals(type)) {
                    System.out.println("Floor: "+i+1+" - Slot: "+j+1);
                }
            }
    }

    public void displayOccupiedSlots(String type) {
        for (int i= 0; i< slots.size(); i++)
            for (int j= 0; j< slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (!Objects.isNull(slot.getVehicle())) {
                    System.out.println("Occupied: Floor: "+i+1+" - Slot: "+j+1);
                }
            }

        System.out.println("All slot is free for the moment");
    }
}









