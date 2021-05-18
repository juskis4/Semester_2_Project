package server.model.mediator;

import server.model.domain.*;

public interface Model
{
  void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date);
  void reserveParkingSpace(ParkingSpace parkingSpace, User user);
  void reserveParkingSpace(int index, User user);
  void register(String userName, String password);
  boolean login(String userName, String password);
  void registerFirstAndLastName(String firstName, String lastName, String username);
  User getUserByUserName(String userName);
  void registerVehicle(String username, String licenseNo, String color, String carBrand);
}
