package server.model.domain;

import client.mediator.RemoteInterface;
import client.model.RMIClient;
import server.model.mediator.Model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RemoteInterface
{
  private Login login;
  private Model model;

  public RMIServer(Model model)
  {
    this.model = model;
  }

  public void start() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this, 0);
    Naming.rebind("ParkingLot", this);
    login = new Login();
  }

  @Override public void login(String username, String password)
      throws RemoteException
  {

  }

  @Override public void register(String username, String password)
      throws RemoteException
  {
      login.register(username, password);
  }

  @Override public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
  {
    model.registerSpace(username, vehicle, parkingSpace, time, date);
  }
}
