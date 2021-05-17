package server.model.mediator;

import server.model.domain.*;

public class ModelManager implements Model
{
  private ParkingLot parkingLot;
  private DatabaseManager databaseManager;

  public ModelManager()
  {

  }

  @Override public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date)
  {
    // TO BE IMPLEMENTED
  }
}
