package org.fuji;

import org.fuji.entities.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot= new ParkingLot(3, 50);

        parkingLot.displayOpenSlots("car");
    }
}