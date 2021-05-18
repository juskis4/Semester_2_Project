package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;

public class ProfileViewModel {

    private StringProperty userNameProperty;
    private StringProperty licenseNoProperty;
    private StringProperty actualFirstNameProperty;
    private StringProperty actualSecondNameProperty;
    private StringProperty firstNameProperty;
    private StringProperty secondNameProperty;
    private Model model;

    public ProfileViewModel(Model model) throws RemoteException
    {

        this.model = model;
        userNameProperty = new SimpleStringProperty(model.getUserByUserName().getUsername());
        licenseNoProperty = new SimpleStringProperty(model.getUserByUserName().getVehicle().getLicenseNo());
        actualFirstNameProperty = new SimpleStringProperty(model.getUserByUserName().getFirstname());
        actualSecondNameProperty = new SimpleStringProperty(model.getUserByUserName().getLastname());
        firstNameProperty = new SimpleStringProperty("");
        secondNameProperty = new SimpleStringProperty("");
    }

    public void reset() throws RemoteException
    {
        userNameProperty = new SimpleStringProperty(model.getUserByUserName().getUsername());
        licenseNoProperty = new SimpleStringProperty(model.getUserByUserName().getVehicle().getLicenseNo());
        actualFirstNameProperty = new SimpleStringProperty(model.getUserByUserName().getFirstname());
        actualSecondNameProperty = new SimpleStringProperty(model.getUserByUserName().getLastname());
        firstNameProperty = new SimpleStringProperty("");
        secondNameProperty = new SimpleStringProperty("");
    }

    public StringProperty getUserNameProperty()
    {
        return userNameProperty;
    }

    public StringProperty getLicenseNoProperty()
    {
        return licenseNoProperty;
    }

    public StringProperty getActualFirstNameProperty()
    {
        return actualFirstNameProperty;
    }

    public StringProperty getActualSecondNameProperty()
    {
        return actualSecondNameProperty;
    }

    public StringProperty getFirstNameProperty()
    {
        return firstNameProperty;
    }

    public StringProperty getSecondNameProperty()
    {
        return secondNameProperty;
    }

    public void changeNames()
    {
        model.registerFirstAndLastName(firstNameProperty.get(),secondNameProperty.get(),userNameProperty.get());
    }
}