package server.model;


import server.model.domain.*;
import server.model.mediator.Model;
import server.model.mediator.ModelManager;
import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeHandler;

import javax.swing.plaf.basic.BasicListUI;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class RemoteModel extends UnicastRemoteObject implements RemoteInterface
{
  private Model model;
  private PropertyChangeHandler<String, String> property;

  public RemoteModel(Model model) throws RemoteException, MalformedURLException
    {
    this.model = model;
    property = new PropertyChangeHandler<>(this,true);
    startRegistry();
    startServer();
  }

  private void startServer() throws RemoteException, MalformedURLException
  {
      Naming.rebind("ParkingLot",this);
      System.out.println("Server started...");

  }

  private void startRegistry() throws RemoteException
  {
    try {
      Registry reg = LocateRegistry.createRegistry(1099);
      System.out.println("Registry started...");
    }
    catch (java.rmi.server.ExportException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean login(String username, String password)
      throws RemoteException, SQLException
  {
    return model.login(username, password);
  }

  @Override public void register(String username, String password)
      throws RemoteException
  {
    try {
      model.register(username,password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void registerFirstAndLastName(String firstName, String lastName,String userName) throws SQLException, RemoteException {
    model.registerFirstAndLastName(firstName,lastName,userName);
  }

  @Override public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
  {
    model.registerSpace(username, parkingSpace, time, date);
  }

  @Override
  public User getUserByUserName(String userName)
      throws RemoteException, SQLException
  {
    return model.getUserByUserName(userName);
  }

  @Override public void registerVehicle(String username, String licenseNo,
      String color, String carBrand) throws RemoteException
  {
    model.registerVehicle(username, licenseNo, carBrand, color);
  }

  @Override
  public ParkingLot getParkingLot() throws RemoteException {
    return model.getParkingLot();
  }

  @Override
  public boolean addListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException {
    return property.addListener(listener,propertyNames);
  }

  @Override
  public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException {
    return property.removeListener(listener,propertyNames);
  }
}
