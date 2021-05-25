package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ProfileViewModel implements PropertyChangeListener {

    public static final String USER_NULL = "";
    private StringProperty userNameProperty;
    private StringProperty licenseNoProperty;
    private StringProperty actualFirstNameProperty;
    private StringProperty actualSecondNameProperty;
    private StringProperty firstNameProperty;
    private StringProperty secondNameProperty;
    private Model model;

    public ProfileViewModel(Model model) throws RemoteException, SQLException
    {

        this.model = model;
        userNameProperty = new SimpleStringProperty(USER_NULL);
        licenseNoProperty = new SimpleStringProperty(USER_NULL);
        actualFirstNameProperty = new SimpleStringProperty(USER_NULL);
        actualSecondNameProperty = new SimpleStringProperty(USER_NULL);
        firstNameProperty = new SimpleStringProperty("");
        secondNameProperty = new SimpleStringProperty("");
    }

    public void reset() throws RemoteException, SQLException
    {
        userNameProperty = new SimpleStringProperty(model.getUser().getUsername());
        licenseNoProperty = new SimpleStringProperty(model.getUser().getVehicle().getLicenseNo());
        actualFirstNameProperty = new SimpleStringProperty(model.getUser().getFirstname());
        actualSecondNameProperty = new SimpleStringProperty(model.getUser().getLastname());
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName())
        {
            case "Login" : {
                userNameProperty.setValue((String)evt.getOldValue());
                break;
            }
            default: {
                try {
                    reset();
                }
                catch (Exception ignored)
                {

                }
            }
        }
    }
}