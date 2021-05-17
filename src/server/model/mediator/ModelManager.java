package server.model.mediator;

import server.model.domain.ParkingLot;
import server.model.domain.ParkingSpace;
import server.model.domain.Vehicle;

public class ModelManager implements Model
{
  private ParkingLot parkingLot;
  private DatabaseManager databaseManager;

  public ModelManager()
  {

  }

  @Override public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace)
  {
    // TO BE IMPLEMENTED
  }
}
