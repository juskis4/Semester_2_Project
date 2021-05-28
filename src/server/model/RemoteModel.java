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

/**
 * A class representing server in this system.
 */
public class RemoteModel extends UnicastRemoteObject implements RemoteInterface
{
  private Model model;
  private PropertyChangeHandler<String, String> property;

  /**
   * Server constructor.
   * @param model server model.
   * @throws RemoteException throwing remote exception.
   * @throws MalformedURLException throwing malformed exception.
   */
  public RemoteModel(Model model) throws RemoteException, MalformedURLException
    {
    this.model = model;
    property = new PropertyChangeHandler<>(this,true);
    startRegistry();
    startServer();
  }

  /**
   * A method that starts the server.
   * @throws RemoteException throwing remote exception.
   * @throws MalformedURLException throwing malformed exception.
   */
  private void startServer() throws RemoteException, MalformedURLException
  {
      Naming.rebind("ParkingLot",this);
      System.out.println("Server started...");

  }

  /**
   * A method that creates and starts the registry.
   * @throws RemoteException throwing remote exception.
   */
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

  /**
   * A method that is called from client in order to validate users login.
   * @param username users username.
   * @param password users password.
   * @return true if user is validated, false if not.
   * @throws RemoteException throwing remote exception.
   * @throws SQLException throwing sql exception.
   */
  @Override public boolean login(String username, String password)
      throws RemoteException, SQLException
  {
    return model.login(username, password);
  }

  /**
   * A method that is called from client to register user.
   * @param username users username.
   * @param password users password.
   * @throws RemoteException throwing remote exception.
   */
  @Override public void register(String username, String password)
      throws RemoteException
  {
    try {
      model.register(username,password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that called from client to register users first and last names.
   * @param firstName users first name.
   * @param lastName users last name.
   * @param userName users username.
   * @throws SQLException throwing sql exception.
   * @throws RemoteException throwing remote exception.
   */
  @Override
  public void registerFirstAndLastName(String firstName, String lastName,String userName) throws SQLException, RemoteException {
    model.registerFirstAndLastName(firstName,lastName,userName);
  }

  /**
   * A method that is called from client o reserve parking space.
   * @param username users username.
   * @param parkingSpace parking space.
   * @param startingTime reservation starting time.
   * @param endingTime reservation ending time.
   * @param date reservation date.
   * @throws RemoteException throwing remote exception.
   */
  @Override public void registerSpace(String username, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date) throws RemoteException
  {
    model.registerSpace(username, parkingSpace, startingTime, endingTime, date);
  }

  /**
   * A method that is called from client to get user by username.
   * @param userName users username.
   * @return user.
   * @throws RemoteException throwing remote exception.
   * @throws SQLException throwing sql exception.
   */
  @Override
  public User getUserByUserName(String userName)
      throws RemoteException, SQLException
  {
    return model.getUserByUserName(userName);
  }

  /**
   * A method that is called from client to register users vehicle.
   * @param username user username.
   * @param licenseNo users vehicle license number.
   * @param color users vehicle color.
   * @param carBrand users vehicle brand.
   * @throws RemoteException throwing remote exception.
   */
  @Override public void registerVehicle(String username, String licenseNo,
      String color, String carBrand) throws RemoteException
  {
    model.registerVehicle(username, licenseNo, carBrand, color);
  }

  /**
   * A method that is being called from client to get the parking lot.
   * @return parking lot.
   * @throws RemoteException throwing remote exception.
   */
  @Override
  public ParkingLot getParkingLot() throws RemoteException {
    return model.getParkingLot();
  }

  /**
   * A method that is being called from client in order to add log.
   * @param username users username.
   * @param parkingSpace parking space.
   * @throws RemoteException throwing remote exception.
   * @throws SQLException throwing sql exception.
   */
  @Override public void addLog(String username, String parkingSpace) throws RemoteException, SQLException
  {
    model.addLog(username, parkingSpace);
  }

  /**
   * A method for other classes to add themselves as listeners.
   * @param listener listener(class)
   * @param propertyNames name of the property.
   * @return true if class was added as a listener, false if not.
   * @throws RemoteException throwing remote exception.
   */
  @Override
  public boolean addListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException {
    return property.addListener(listener,propertyNames);
  }

  /**
   * A method for other classes to remove themselves as listeners.
   * @param listener listener(class)
   * @param propertyNames name of the property.
   * @return true if class was added as a listener, false if not.
   * @throws RemoteException throwing remote exception.
   */
  @Override
  public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException {
    return property.removeListener(listener,propertyNames);
  }
}
