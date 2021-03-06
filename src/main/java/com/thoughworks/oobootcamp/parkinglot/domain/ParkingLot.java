package com.thoughworks.oobootcamp.parkinglot.domain;

import com.thoughworks.oobootcamp.parkinglot.excpetion.InvalidTicketException;
import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkAndPickable {

  private final int space;

  private Map<Ticket, Car> cars = new HashMap<>();

  public ParkingLot(int space) {
    this.space = space;
  }

  public Ticket parkCar(Car car) {
    if (cars.size() >= space) {
      throw new NoSpaceException();
    }
    Ticket ticket = new Ticket();
    cars.put(ticket, car);
    return ticket;
  }

  public Car pickCar(Ticket ticket) {
    Car car = cars.remove(ticket);
    if (car == null) {
      throw new InvalidTicketException();
    }
    return car;
  }

  public boolean hasSpace() {
    return space > cars.size();
  }

  public boolean isTicketAvailable(Ticket ticket) {
    return cars.containsKey(ticket);
  }

  public int getRemainingSpace() {
    return space - cars.size();
  }
}
