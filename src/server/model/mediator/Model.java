package server.model.mediator;

import server.model.domain.Date;
import server.model.domain.ParkingSpace;
import server.model.domain.Time;
import server.model.domain.Vehicle;

public interface Model
{
  void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date);
}
