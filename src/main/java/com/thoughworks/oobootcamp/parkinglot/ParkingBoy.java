package com.thoughworks.oobootcamp.parkinglot;

public class ParkingBoy {

  private ParkingLot parkingLot;

  public ParkingBoy(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  public Ticket parkCar(Car car) {
    return parkingLot.parkCar(car);
  }
}
