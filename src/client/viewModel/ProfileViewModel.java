package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.User;

import java.rmi.RemoteException;

public class ProfileViewModel {

    public static final String USER_NULL = "User not set.";
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
        User user = model.getUserByUserName();
        if(user == null)
        {
            userNameProperty = new SimpleStringProperty(USER_NULL);
            licenseNoProperty = new SimpleStringProperty(USER_NULL);
            actualFirstNameProperty = new SimpleStringProperty(USER_NULL);
            actualSecondNameProperty = new SimpleStringProperty(USER_NULL);
        }
        else {
            userNameProperty = new SimpleStringProperty(user.getUsername());
            licenseNoProperty = new SimpleStringProperty(user.getVehicle().getLicenseNo());
            actualFirstNameProperty = new SimpleStringProperty(user.getFirstname());
            actualSecondNameProperty = new SimpleStringProperty(user.getLastname());
        }
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