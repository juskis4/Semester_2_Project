package client.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote
{
  void login(String username, String password) throws RemoteException;
  void register(String username, String password) throws RemoteException;
}
