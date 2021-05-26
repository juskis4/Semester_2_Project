package client.model;

import client.mediator.RMIClient;
import server.model.domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ModelManager implements Model {
    private RMIClient client;
    private User user;
    private PropertyChangeSupport support;

    public ModelManager(RMIClient client) {
        user = null;
        this.client = client;
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void register(String userName, String password) {
        try {
            this.user = new User(userName, password);
            client.register(userName, password);
        } catch (RemoteException ignored) {

        }
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            this.user = client.getUserByUserName(userName);
            if(user.getFirstname() != null)
            {
                support.firePropertyChange("FirstLastNames", user.getFirstname(), user.getLastname());
            }
            if(user.getVehicle() != null)
            {
                support.firePropertyChange("getVehicle", null, user.getVehicle());
            }
            support.firePropertyChange("Login", user.getUsername(), null);
            return client.login(userName, password);
        } catch (RemoteException | SQLException ignored) {

        }
        return false;
    }

    @Override
    public void registerFirstAndLastName(String firstName, String lastName, String userName) {
        try {
            user.setLastname(lastName);
            user.setFirstname(firstName);
            support.firePropertyChange("FirstLastNames", user.getFirstname(), user.getLastname());
            client.registerFirstAndLastName(firstName, lastName, userName);

        } catch (RemoteException | SQLException e) {

        }
    }

    @Override
    public void pressOnParkingSpace(String nameOfSpace) {
        support.firePropertyChange("PressOnReserve",null,nameOfSpace);
    }

    @Override
    public void registerSpace(String username, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date) throws RemoteException {
        client.registerSpace(username, parkingSpace, startingTime, endingTime, date);
        support.firePropertyChange("ReserveSpace", null, parkingSpace.getNameOfParkingSpace());
    }

    @Override
    public User getUserByUserName() throws RemoteException, SQLException {
        return null;
//        return client.getUserByUserName(user.getUsername());
    }

    @Override
    public void registerVehicle(String licenseNo,
                                String color, String carBrand) throws RemoteException {
        client.registerVehicle(user.getUsername(), licenseNo, carBrand, color);
        user.registerVehicle(licenseNo, carBrand, color);
        support.firePropertyChange("Vehicle", null, user.getVehicle().getLicenseNo());
    }

    @Override
    public ParkingLot getParkingLot() throws RemoteException {
        return client.getParkingLot();
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


    @Override
    public void setNameSpace(String name) {
        support.firePropertyChange(name, null, 1);
    }

    @Override
    public User getUser() {
        return user;
    }
}
