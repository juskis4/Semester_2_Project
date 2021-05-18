package client.viewModel;

import client.model.Model;
import client.view.CancelReservationViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class CancelReservationViewModel {
    private StringProperty errorLabelProperty;
    private StringProperty parkingSpaceFieldProperty;
    private StringProperty authorNameProperty;
    private StringProperty vehicleInfoProperty;
    private Model model;

    public CancelReservationViewModel(Model model) throws RemoteException
    {
        try {
            this.model = model;
            errorLabelProperty = new SimpleStringProperty("");
            authorNameProperty = new SimpleStringProperty(model.getUserByUserName().getUsername());
            parkingSpaceFieldProperty = new SimpleStringProperty(model.getParkingLot().getParkingSpaceByName(authorNameProperty.get()).getNameOfParkingSpace());
            vehicleInfoProperty = new SimpleStringProperty(model.getUserByUserName().getVehicle().toString());
        }
        catch (RemoteException ignored)
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
        catch (RemoteException ignored)
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
            model.getParkingLot().getParkingSpaceByName(parkingSpaceFieldProperty.get()).setOccupied(false,model.getUserByUserName());
        }
        catch (RemoteException ignored)
        {

        }
    }
}
