package org.fuji;

import org.fuji.entities.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot= new ParkingLot("PR", 3, 50);

        parkingLot.displayOpenSlots("car");
        String ticketId = parkingLot.parkVehicle("car", "125", "red");

        System.out.println(ticketId);

        parkingLot.displayOccupiedSlots("car");

        parkingLot.unPark("PR_1_4");

        parkingLot.displayOccupiedSlots("car");
    }
}