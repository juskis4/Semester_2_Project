package client.model;

import client.mediator.RMIClient;
import server.model.domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ModelManager implements Model
{
    private PropertyChangeSupport support;
    private RMIClient client;

    public ModelManager(RMIClient client)
    {
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
            client.registerFirstAndLastName(firstName,lastName,userName);
        }
        catch (RemoteException e)
        {

        }
    }

    @Override public void registerSpace(String username, Vehicle vehicle,
        ParkingSpace parkingSpace, Time time, Date date) throws RemoteException
    {
        client.registerSpace(username, vehicle, parkingSpace, time, date);
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
    public String getUserName() throws RemoteException {
        return client.getUserName();
    }
}
