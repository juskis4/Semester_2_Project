package client.model;

import server.model.domain.*;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.rmi.RemoteException;

public interface Model extends UnnamedPropertyChangeSubject
{
    void register(String userName, String password);
    boolean login(String userName, String password);
    void registerFirstAndLastName(String firstName, String lastName, String userName);
    void registerSpace(String username, Vehicle vehicle, ParkingSpace parkingSpace, Time time, Date date)
        throws RemoteException;
    String getUserName() throws RemoteException;
}
