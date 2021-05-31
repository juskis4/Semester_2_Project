package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.Vehicle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

/**
 * A class that represents the viewmodel for ChangeCar window and it is part of MVVM pattern.
 * This viewmodel is a listener to client model, as a Observer pattern part.
 */
public class ChangeCarViewModel implements PropertyChangeListener {
    private StringProperty carBrandProperty;
    private StringProperty licenseNoProperty;
    private StringProperty colorProperty;
    private StringProperty errorProperty;
    private Model model;
    private String userName;


    /** A constructor that sets the label text for every StringProperty variable.
     * The model also adds this class as a listener.
     *
     * @param model client model
     */
    public ChangeCarViewModel(Model model) {
        this.model = model;
        model.addListener(this);
        userName = "Not set";
        carBrandProperty = new SimpleStringProperty("");
        licenseNoProperty = new SimpleStringProperty("");
        colorProperty = new SimpleStringProperty("");
        errorProperty = new SimpleStringProperty("");
    }

    /**
     * Resets all text labels to null, remaining to be set by the user.
     */

    public void reset() {
        carBrandProperty.set("");
        licenseNoProperty.set("");
        colorProperty.set("");
        errorProperty.set("");
    }

    /**
     * It gets the car brand information.
     * @return carBrand.
     */
    public StringProperty getCarBrandProperty() {
        return carBrandProperty;
    }

    /**
     * It gets the car color information.
     * @return color.
     */

    public StringProperty getColorProperty() {
        return colorProperty;
    }

    /**
     * It gets the license no car information.
     * @return licenseNo.
     */
    public StringProperty getLicenseNoProperty() {
        return licenseNoProperty;
    }

    /**
     * It gets the errorLabel information, if something is wrong.
     * @return errorProperty.
     */

    public StringProperty getErrorProperty() {
        return errorProperty;
    }

    /**
     * It registers the vehicle, by making the connection between client, server and database.
     * All information about vehicle are stored into database.
     * @throws RemoteException if something is wrong between client and server RMI.
     */

    public void registerVehicle() throws RemoteException {
        model.registerVehicle(licenseNoProperty.get(), colorProperty.get(),
                carBrandProperty.get());
    }


    /**
     * Method part of Observer pattern, 1 statement.
     * It gets the vehicle information such as license no, color and brand, if "getVehicle" event it is already fired.
     * An event is fired when user sets his car information.
     * @param evt is used for getting the actual name of event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("getVehicle"))
        {
            Vehicle vehicle = (Vehicle) evt.getOldValue();
            licenseNoProperty.set(vehicle.getLicenseNo());
            carBrandProperty.set(vehicle.getCarBrand());
            colorProperty.set(vehicle.getColor());
        }
    }
}
