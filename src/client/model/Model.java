package client.model;

import server.model.domain.*;

import java.rmi.RemoteException;

public interface Model {
    void register(String userName, String password);

    boolean login(String userName, String password);

    void registerFirstAndLastName(String firstName, String lastName, String userName);

    void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date)
            throws RemoteException;

    User getUserByUserName() throws RemoteException;

    void registerVehicle(String licenseNo, String color, String carBrand) throws RemoteException;

    ParkingLot getParkingLot();
}
