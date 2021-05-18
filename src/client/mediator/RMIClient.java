package client.mediator;

import client.model.Model;
import server.model.RemoteInterface;
import server.model.domain.Date;
import server.model.domain.ParkingSpace;
import server.model.domain.Time;
import server.model.domain.Vehicle;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient {

    private RemoteInterface server;

    public RMIClient() throws RemoteException
    {
        try
        {
            server = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ParkingLot");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void register(String userName, String password) throws RemoteException
    {
        server.register(userName,password);
    }

    public boolean login(String userName, String password) throws RemoteException
    {
        return server.login(userName,password);
    }

    public void registerFirstAndLastName(String firstName, String lastName, String userName) throws RemoteException
    {
        server.registerFirstAndLastName(firstName,lastName,userName);
    }
    public void registerSpace(String username, Vehicle vehicle,
        ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
    {
        server.registerSpace(username, vehicle, parkingSpace, time, date);
    }
}
