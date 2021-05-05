package client.model;

import client.mediator.RemoteInterface;

import java.rmi.Naming;

public class RMIClient
{

  private RemoteInterface server;

  public RMIClient()
  {
    try
    {
      server = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ParkingLot");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
