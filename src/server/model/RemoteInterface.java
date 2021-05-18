package server.model;

import server.model.domain.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote
{
  boolean login(String username, String password) throws RemoteException;
  void register(String username, String password) throws RemoteException;
  void registerFirstAndLastName(String firstName, String lastName, String userName) throws RemoteException;
  void registerSpace(String username, Vehicle vehicle, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException;
  User getUserByUserName(String userName) throws RemoteException;
}
