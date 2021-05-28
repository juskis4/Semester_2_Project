package client.viewModel;

import client.model.Model;
import client.view.CancelReservationViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.ParkingSpace;
import server.model.domain.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * A class that represents the viewmodel of CancelReservation window and it is part of MVVM pattern.
 * This viewmodel is a listener to model, as a Observer pattern part.
 */
public class CancelReservationViewModel implements PropertyChangeListener
{
    public static final String USER_NULL = "User not set.";
    private StringProperty errorLabelProperty;
    private StringProperty parkingSpaceFieldProperty;
    private StringProperty authorNameProperty;
    private StringProperty vehicleInfoProperty;
    private Model model;

    /**
     * A constructor that sets the label text for every StringProperty variable.
     * @param model used for getting the actual information that user provided about his car, his username and
     *              the name of the parking space taken by him.
     */
    public CancelReservationViewModel(Model model)
    {
        try {
            this.model = model;
            User user = model.getUserByUserName();
            errorLabelProperty = new SimpleStringProperty("");
            if(user == null)
            {
                authorNameProperty = new SimpleStringProperty(USER_NULL);
                vehicleInfoProperty = new SimpleStringProperty(USER_NULL);
            }
            else {
                authorNameProperty = new SimpleStringProperty(user.getUsername());
                vehicleInfoProperty = new SimpleStringProperty(user.getVehicle().toString());
            }
            ParkingSpace parkingSpace = model.getParkingLot().getParkingSpaceByName(authorNameProperty.get());
            if(parkingSpace == null)
            {
                parkingSpaceFieldProperty = new SimpleStringProperty(USER_NULL);
            }
            else {
                parkingSpaceFieldProperty = new SimpleStringProperty(parkingSpace.getNameOfParkingSpace());
            }
        }
        catch (RemoteException | SQLException ignored)
        {

        }
    }

    /**
     * Resets all text labels and gets the actual informations, by using the model.
     */
    public void reset()
    {
        try {
            errorLabelProperty = new SimpleStringProperty("");
            authorNameProperty = new SimpleStringProperty(model.getUserByUserName().getUsername());
            parkingSpaceFieldProperty = new SimpleStringProperty(model.getParkingLot().getParkingSpaceByName(authorNameProperty.get()).getNameOfParkingSpace());
            vehicleInfoProperty = new SimpleStringProperty(model.getUserByUserName().getVehicle().toString());
        }
        catch (RemoteException | SQLException ignored)
        {

        }
    }

    /**
     * Getter for errorLabel text.
     * @return actual errorLabel informations.
     */
    public StringProperty getErrorLabelProperty()
    {
        return errorLabelProperty;
    }

    /**
     * Getter for parkingSpaceName text
     * @return actual parkingSpaceName that has been selected for cancellation.
     */
    public StringProperty getParkingSpaceFieldProperty() {
        return parkingSpaceFieldProperty;
    }

    /**
     * Getter for authorName text
     * @return the username the client logged in with.
     */

    public StringProperty getAuthorNameProperty()
    {
        return authorNameProperty;
    }

    /**
     * Getter for vehicle's informations.
     * @return the license plate, color and brand of customer's car.
     */
    public StringProperty getVehicleInfoProperty(){
        return vehicleInfoProperty;
    }

    /**
     * Cancels user reservation. Sets the parking space to unoccupied and all its information to null
     */
    public void onCancel()
    {
        try {
            model.getParkingLot().getParkingSpaceByName(parkingSpaceFieldProperty.get()).setNotOccupied();
        }
        catch (RemoteException ignored)
        {

        }
    }

    /**
     * Method part of Observer pattern, 3 statemens. Author name is received once the login has been done,
     * parkingSpaceField is received once user clicks the "Reserve" button in the "ParkingLot" window, or vehicle informations
     * are provided once user adds his car informations.
     * @param evt is used for receiving the propertyName, more precisely the name of the event fired.
     */
    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals("Login"))
        {
            authorNameProperty.setValue((String) evt.getOldValue());
        }
        else if(evt.getPropertyName().equals("ReserveSpace"))
        {
            parkingSpaceFieldProperty.setValue((String)evt.getNewValue());
        }
        else if (evt.getPropertyName().equals("Vehicle"))
        {
            vehicleInfoProperty.setValue((String) evt.getNewValue());
        }
    }
}
