package server.model;

import server.model.domain.*;
import utility.observer.subject.RemoteSubject;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.sql.SQLException;

public interface RemoteInterface extends RemoteSubject<String, String>
{
  boolean login(String username, String password)
      throws RemoteException, SQLException;
  void register(String username, String password) throws RemoteException;
  void registerFirstAndLastName(String firstName, String lastName, String userName) throws SQLException,
      RemoteException;
  void registerSpace(String username, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date) throws RemoteException;
  User getUserByUserName(String userName) throws RemoteException, SQLException;
  void registerVehicle(String username, String licenseNo, String color, String carBrand) throws RemoteException;
  ParkingLot getParkingLot() throws RemoteException;
  void addLog(String username, String parkingSpace)
      throws RemoteException, SQLException;
}
