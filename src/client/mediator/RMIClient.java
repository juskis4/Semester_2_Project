package client.mediator;

import client.model.Model;
import server.model.RemoteInterface;
import server.model.domain.*;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 * A class that represent the client
 */
public class RMIClient extends UnicastRemoteObject implements RemoteListener<String, String> {

    private RemoteInterface server;

    /**
     * A constructor for client that looks up for e server in the registry.
     * @throws RemoteException
     */
    public RMIClient() throws RemoteException{
        try {
            server = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ParkingLot");
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Calling register method in server.
     * @param userName users username.
     * @param password users password.
     * @throws RemoteException throwing remote exception.
     */
    public void register(String userName, String password) throws RemoteException {

        server.register(userName, password);
    }

    /**
     * Calling login method in server.
     * @param userName users username.
     * @param password users password.
     * @return true if login is validated false, if otherwise.
     * @throws RemoteException throwing remote exception.
     * @throws SQLException throwing sql exception.
     */
    public boolean login(String userName, String password)
        throws RemoteException, SQLException
    {
        return server.login(userName, password);
    }

    /**
     * Calling register first and last name in server.
     * @param firstName users first name.
     * @param lastName users last name.
     * @param userName users username.
     * @throws RemoteException throwing remote exception.
     * @throws SQLException throwing sql exception.
     */
    public void registerFirstAndLastName(String firstName, String lastName, String userName)
        throws RemoteException, SQLException
    {
        server.registerFirstAndLastName(firstName, lastName, userName);
    }

    public void registerSpace(String username, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date) throws RemoteException {
        server.registerSpace(username, parkingSpace, startingTime, endingTime, date);
    }

    public User getUserByUserName(String userName)
        throws RemoteException, SQLException
    {
        return server.getUserByUserName(userName);
    }

    public void registerVehicle(String username, String licenseNo, String color, String carBrand)
            throws RemoteException {
        server.registerVehicle(username, licenseNo, carBrand, color);
    }

    public ParkingLot getParkingLot() throws RemoteException{
        return server.getParkingLot();
    }
    public void addLog(String username, String parkingSpace)
        throws RemoteException, SQLException
    {
        server.addLog(username, parkingSpace);
    }

    @Override
    public void propertyChange(ObserverEvent<String, String> event) throws RemoteException {

    }
}
