package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * A class that represents the viewmodel of Profile window and it is part of MVVM pattern.
 * This viewmodel is a listener to client model, as a Observer pattern part.
 */
public class ProfileViewModel implements PropertyChangeListener {

    public static final String USER_NULL = "Not set";
    private StringProperty userNameProperty;
    private StringProperty licenseNoProperty;
    private StringProperty actualFirstNameProperty;
    private StringProperty actualSecondNameProperty;
    private StringProperty firstNameProperty;
    private StringProperty secondNameProperty;
    private StringProperty errorLabelProperty;

    private Model model;

    /**
     * A constructor that sets the label text for every StringProperty variable.
     * When profile viewmodel is created, informations about user are set to null.
     * @param model client model
     */
    public ProfileViewModel(Model model)
    {

        this.model = model;
        model.addListener(this);
        userNameProperty = new SimpleStringProperty(USER_NULL);
        licenseNoProperty = new SimpleStringProperty(USER_NULL);
        actualFirstNameProperty = new SimpleStringProperty(USER_NULL);
        actualSecondNameProperty = new SimpleStringProperty(USER_NULL);
        firstNameProperty = new SimpleStringProperty("");
        secondNameProperty = new SimpleStringProperty("");
        errorLabelProperty = new SimpleStringProperty("");
    }

    /**
     * Resets all labels and gets information about user's vehicle license plate, first and second name from model.
     * @throws RemoteException
     * @throws SQLException
     */
    public void reset() throws RemoteException, SQLException
    {
        userNameProperty = new SimpleStringProperty(model.getUser().getUsername());
        licenseNoProperty = new SimpleStringProperty(model.getUser().getVehicle().getLicenseNo());
        actualFirstNameProperty = new SimpleStringProperty(model.getUser().getFirstname());
        actualSecondNameProperty = new SimpleStringProperty(model.getUser().getLastname());
        firstNameProperty = new SimpleStringProperty("");
        secondNameProperty = new SimpleStringProperty("");
        errorLabelProperty = new SimpleStringProperty("");
    }

    /**
     * Gets the username.
     * @return
     */
    public StringProperty getUserNameProperty()
    {
        return userNameProperty;
    }

    /**
     * Gets the vehicle license number.
     * @return
     */
    public StringProperty getLicenseNoProperty()
    {
        return licenseNoProperty;
    }

    /**
     * Gets the actual first name.
     * @return
     */

    public StringProperty getActualFirstNameProperty()
    {
        return actualFirstNameProperty;
    }

    /**
     * Gets the actual second name.
     * @return
     */

    public StringProperty getActualSecondNameProperty()
    {
        return actualSecondNameProperty;
    }

    /**
     * Gets informations about errors, if any.
     * @return
     */

    public StringProperty getErrorLabelProperty()
    {
        return errorLabelProperty;
    }

    /**
     * Gets the first name that has to be set.
     * @return
     */
    public StringProperty getFirstNameProperty()
    {
        return firstNameProperty;
    }

    /**
     * Gets the second name that has to be set.
     * @return
     */

    public StringProperty getSecondNameProperty()
    {
        return secondNameProperty;
    }

    /**
     * A method that register the first and last name of user. All informations are stored in database.
     */

    public void changeNames()
    {
        model.registerFirstAndLastName(firstNameProperty.get(),secondNameProperty.get(),userNameProperty.get());
    }

    /**
     * Method part of Observer pattern, 3 statements.
     * It gets the customer's name once "Login" event is fired, if uset registers his vehicle, then the number plate is set here.
     * If names, by "FirstLastNames" event, are changed, then actual first and second name are stored in database.
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName())
        {
            case "Login" : {
                userNameProperty.setValue((String)evt.getOldValue());
                System.out.println("WORKING");
                break;
            }
            case "Vehicle":
            {
                licenseNoProperty.setValue((String) evt.getNewValue());
                break;
            }
            case "FirstLastNames":
            {
                actualFirstNameProperty.setValue((String)evt.getOldValue());
                actualSecondNameProperty.setValue((String)evt.getNewValue());
                System.out.println("Changing names");
                break;
            }

            default: {
            }
        }
    }
}