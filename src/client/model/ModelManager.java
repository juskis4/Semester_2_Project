package client.model;

import client.mediator.RMIClient;
import server.model.domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * A model manager class for client.
 */
public class ModelManager implements Model {
    private RMIClient client;
    private User user;
    private PropertyChangeSupport support;

    public ModelManager(RMIClient client) {
        user = null;
        this.client = client;
        support = new PropertyChangeSupport(this);
    }

    /**
     * Creating user and calling register method in client.
     * @param userName users username.
     * @param password users password.
     */
    @Override
    public void register(String userName, String password) {
        try {
            this.user = new User(userName, password);
            client.register(userName, password);
        } catch (RemoteException ignored) {

        }
    }

    /**
     * Calling login method in client and firing events with user first, last names and vehicle.
     * @param userName users username.
     * @param password users password.
     * @return true if login is validated false, if not.
     */
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

    /**
     * Calling register first and last name method, setting user first, last names and firing them.
     * @param firstName users first name.
     * @param lastName users last name.
     * @param userName users username.
     */
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

    /**
     * Firing parking space name when pressed on reserve button in Reserve view.
     * @param nameOfSpace
     */
    @Override
    public void pressOnParkingSpace(String nameOfSpace) {
        support.firePropertyChange("PressOnReserve",null,nameOfSpace);
    }

    /**
     * Calling register parking space method in client and firing parking space name.
     * @param username users username.
     * @param parkingSpace parking space.
     * @param startingTime reservation starting time.
     * @param endingTime reservation ending time.
     * @param date reservation date.
     * @throws RemoteException throwing remote exception.
     */
    @Override
    public void registerSpace(String username, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date) throws RemoteException {
        client.registerSpace(username, parkingSpace, startingTime, endingTime, date);
        support.firePropertyChange("ReserveSpace", null, parkingSpace.getNameOfParkingSpace());
    }

    @Override
    public User getUserByUserName() throws RemoteException, SQLException {
        return null;
    }

    /**
     * Calling register vehicle methods in client and user. Firing vehicle.
     * @param licenseNo users vehicle license number.
     * @param color users vehicle color.
     * @param carBrand users vehicle car brand.
     * @throws RemoteException throwing remote exception.
     */
    @Override
    public void registerVehicle(String licenseNo,
                                String color, String carBrand) throws RemoteException {
        client.registerVehicle(user.getUsername(), licenseNo, carBrand, color);
        user.registerVehicle(licenseNo, carBrand, color);
        support.firePropertyChange("Vehicle", null, user.getVehicle().getLicenseNo());
    }

    /**
     * Calling get parking lot method in client.
     * @return parking lot.
     * @throws RemoteException throwing remote exception.
     */
    @Override
    public ParkingLot getParkingLot() throws RemoteException {
        return client.getParkingLot();
    }

    /**
     * A method for other classed to add themselves as listeners to model.
     * @param listener a class that will be a listener.
     */
    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * A method for other classed to remove themselves as listeners to model.
     * @param listener a class that is a listener.
     */
    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * Firing parking space name.
     * @param name parking space name.
     */
    @Override
    public void setNameSpace(String name) {
        support.firePropertyChange(name, null, 1);
    }

    /**
     * Getter for user.
     * @return user.
     */
    @Override
    public User getUser() {
        return user;
    }

    /**
     * Calling add log method in client.
     * @param username users username.
     * @param parkingSpace parking space name.
     * @throws RemoteException throwing remote exception.
     * @throws SQLException throwing sql exception.
     */
    @Override public void addLog(String username, String parkingSpace)
        throws RemoteException, SQLException
    {
        client.addLog(username, parkingSpace);
    }
}
