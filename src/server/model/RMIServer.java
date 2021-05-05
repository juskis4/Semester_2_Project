package server.model;

import client.mediator.RemoteInterface;
import server.model.domain.Login;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RemoteInterface
{
  private Login login;
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
}
