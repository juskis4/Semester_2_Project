package client.mediator;

import client.model.Model;
import server.model.RemoteInterface;
import server.model.domain.*;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient {

    private RemoteInterface server;

    public RMIClient() throws RemoteException {
        try {
            server = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ParkingLot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void register(String userName, String password) throws RemoteException {

        server.register(userName, password);
    }

    public boolean login(String userName, String password) throws RemoteException {

        return server.login(userName, password);
    }

    public void registerFirstAndLastName(String firstName, String lastName, String userName) throws RemoteException {
        server.registerFirstAndLastName(firstName, lastName, userName);
    }

    public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException {
        server.registerSpace(username, parkingSpace, time, date);
    }

    public User getUserByUserName(String userName) throws RemoteException {
        return server.getUserByUserName(userName);
    }

    public void registerVehicle(String username, String licenseNo, String color, String carBrand)
            throws RemoteException {
        server.registerVehicle(username, licenseNo, color, carBrand);
    }

    public ParkingLot getParkingLot() {
        return server.getParkingLot();
    }
}
