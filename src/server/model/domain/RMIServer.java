package server.model.domain;

import client.mediator.RemoteInterface;
import server.model.mediator.Model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RemoteInterface
{
  private Model model;

  public RMIServer(Model model)
  {
    this.model = model;
  }

  public void start() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this, 0);
    Naming.rebind("ParkingLot", this);
  }

  @Override public boolean login(String username, String password)
      throws RemoteException
  {
    return model.login(username, password);
  }

  @Override public void register(String username, String password)
      throws RemoteException
  {
      model.register(username,password);
  }

  @Override
  public void registerFirstAndLastName(String firstName, String lastName,String userName) throws RemoteException {
    model.registerFirstAndLastName(firstName,lastName,userName);
  }

  @Override public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
  {
    model.registerSpace(username, vehicle, parkingSpace, time, date);
  }
}
