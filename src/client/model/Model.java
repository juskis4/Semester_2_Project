package client.model;

import server.model.domain.*;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Model extends UnnamedPropertyChangeSubject {
    void register(String userName, String password);

    boolean login(String userName, String password);

    void registerFirstAndLastName(String firstName, String lastName, String userName);

    void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date)
            throws RemoteException;

    User getUserByUserName() throws RemoteException, SQLException;

    void registerVehicle(String licenseNo, String color, String carBrand) throws RemoteException;

    ParkingLot getParkingLot() throws RemoteException;

    void setNameSpace(String name);

    client.utility.User getUser();
}
