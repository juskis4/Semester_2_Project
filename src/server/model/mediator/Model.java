package server.model.mediator;

import server.model.domain.ParkingSpace;
import server.model.domain.Vehicle;

public interface Model
{
  void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace);
}
