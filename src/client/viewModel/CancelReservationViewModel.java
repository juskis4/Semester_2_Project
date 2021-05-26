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

public class CancelReservationViewModel implements PropertyChangeListener
{
    public static final String USER_NULL = "User not set.";
    private StringProperty errorLabelProperty;
    private StringProperty parkingSpaceFieldProperty;
    private StringProperty authorNameProperty;
    private StringProperty vehicleInfoProperty;
    private Model model;

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

    public StringProperty getErrorLabelProperty()
    {
        return errorLabelProperty;
    }

    public StringProperty getParkingSpaceFieldProperty() {
        return parkingSpaceFieldProperty;
    }

    public StringProperty getAuthorNameProperty()
    {
        return authorNameProperty;
    }

    public StringProperty getVehicleInfoProperty(){
        return vehicleInfoProperty;
    }

    public void onCancel()
    {
        try {
            model.getParkingLot().getParkingSpaceByName(parkingSpaceFieldProperty.get()).setOccupied(false,null, null, null, null);
        }
        catch (RemoteException ignored)
        {

        }
    }

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
