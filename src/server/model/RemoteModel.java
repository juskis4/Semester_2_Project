package server.model;


import server.model.domain.*;
import server.model.mediator.Model;
import server.model.mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteModel extends UnicastRemoteObject implements RemoteInterface
{
  private Model model;

  public RemoteModel(Model model) throws RemoteException
  {
    this.model = model;
  }

  @Override
  public void startRegistry() throws RemoteException
  {
    try {
      Registry reg = LocateRegistry.createRegistry(1099);
      System.out.println("Registry started...");
    }
    catch (java.rmi.server.ExportException e)
    {
      System.out.println("Registry already started? Message: " + e.getMessage());
    }
  }

  @Override
  public void startServer() throws RemoteException, MalformedURLException
  {
        UnicastRemoteObject.exportObject(this, 0);
        Naming.rebind("ParkingLotSystem", this);
        System.out.println("Server started...");
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

  @Override public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
  {
    model.registerSpace(username, parkingSpace, time, date);
  }

  @Override
  public User getUserByUserName(String userName) throws RemoteException {
    return model.getUserByUserName(userName);
  }

  @Override public void registerVehicle(String username, String licenseNo,
      String color, String carBrand) throws RemoteException
  {
    model.registerVehicle(username, licenseNo, color, carBrand);
  }

  @Override
  public ParkingLot getParkingLot() throws RemoteException {
    return model.getParkingLot();
  }
}
