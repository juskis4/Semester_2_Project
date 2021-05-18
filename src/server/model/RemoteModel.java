package server.model;


import server.model.domain.*;
import server.model.mediator.Model;
import server.model.mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteModel extends UnicastRemoteObject implements RemoteInterface
{
  private Model model;

  public RemoteModel(Model model) throws RemoteException
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

  @Override
  public User getUserByUserName(String userName) throws RemoteException {
    return model.getUserByUserName(userName);
  }
}
