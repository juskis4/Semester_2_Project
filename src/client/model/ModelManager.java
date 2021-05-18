package client.model;

import client.mediator.RMIClient;
import server.model.domain.*;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;

public class ModelManager implements Model
{
    private PropertyChangeSupport support;
    private RMIClient client;
    private String userName;

    public ModelManager(RMIClient client)
    {
        userName = null;
        this.client = client;
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void register(String userName, String password) {
        try {
            client.register(userName,password);
        }
        catch (RemoteException ignored)
        {

        }
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            this.userName = userName;
            return client.login(userName,password);
        }
        catch (RemoteException ignored)
        {

        }
        return false;
    }

    @Override
    public void registerFirstAndLastName(String firstName, String lastName, String userName) {
        try {
            this.userName = userName;
            client.registerFirstAndLastName(firstName,lastName,userName);
        }
        catch (RemoteException e)
        {

        }
    }

    @Override public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
    {
        client.registerSpace(username, parkingSpace, time, date);
    }

    @Override
    public User getUserByUserName() throws RemoteException{
        return client.getUserByUserName(userName);
    }

    @Override public void registerVehicle(String licenseNo,
        String color, String carBrand) throws RemoteException
    {
        client.registerVehicle(userName, licenseNo, color, carBrand);
    }

}
