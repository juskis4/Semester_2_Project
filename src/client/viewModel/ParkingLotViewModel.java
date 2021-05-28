package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.model.domain.ParkingLot;
import utility.observer.javaobserver.PropertyChangeSubject;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * A constructor that represents the viewmodel for ParkingLot and it is part of MVVM pattern.
 * This viewmodel is a subject and listener, as a part of Observer pattern.
 */
public class ParkingLotViewModel implements PropertyChangeListener, UnnamedPropertyChangeSubject {

    private StringProperty spaceA1;
    private StringProperty spaceA2;
    private StringProperty spaceA3;
    private StringProperty spaceA4;
    private StringProperty spaceA5;
    private StringProperty spaceA6;

    private StringProperty spaceB1;
    private StringProperty spaceB2;
    private StringProperty spaceB3;
    private StringProperty spaceB4;

    private StringProperty spaceC1;
    private StringProperty spaceC2;
    private StringProperty spaceC3;
    private StringProperty spaceC4;

    private StringProperty spaceD1;
    private StringProperty spaceD2;
    private StringProperty spaceD3;
    private StringProperty spaceD4;
    private StringProperty spaceD5;
    private StringProperty spaceD6;

    private StringProperty errorLabel;

    private Model model;
    private String userName;
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * A constructor the initializes the model and names for every parking space. Model ads this class as a listener.
     * @param model client model.
     */
    public ParkingLotViewModel(Model model){
        this.model = model;
        model.addListener(this);
        userName = "";
        spaceA1 = new SimpleStringProperty("A1");
        spaceA2 = new SimpleStringProperty("A2");
        spaceA3 = new SimpleStringProperty("A3");
        spaceA4 = new SimpleStringProperty("A4");
        spaceA5 = new SimpleStringProperty("A5");
        spaceA6 = new SimpleStringProperty("A6");
        spaceB1 = new SimpleStringProperty("B1");
        spaceB2 = new SimpleStringProperty("B2");
        spaceB3 = new SimpleStringProperty("B3");
        spaceB4 = new SimpleStringProperty("B4");
        spaceC1 = new SimpleStringProperty("C1");
        spaceC2 = new SimpleStringProperty("C2");
        spaceC3 = new SimpleStringProperty("C3");
        spaceC4 = new SimpleStringProperty("C4");
        spaceD1 = new SimpleStringProperty("D1");
        spaceD2 = new SimpleStringProperty("D2");
        spaceD3 = new SimpleStringProperty("D3");
        spaceD4 = new SimpleStringProperty("D4");
        spaceD5 = new SimpleStringProperty("D5");
        spaceD6 = new SimpleStringProperty("D6");
        errorLabel = new SimpleStringProperty("");
        propertyChangeSupport = new PropertyChangeSupport(this);

    }


    /**
     * A method that is empty.
     */
    public void reset(){

    }

    /**
     * A method that sets the specific parking space as occupied.
     * @param name name of the parking space that user selects.
     * @return true or false, if that space is occupied or not.
     * @throws RemoteException if connection between client and server is wrong.
     */
    public boolean isOccupied(String name) throws RemoteException {
        return model.getParkingLot().isOccupiedBySpaceName(name);
    }

    /**
     * Method part of Observer pattern, 2 statements.
     * If "reserveSpace" event namem is fired, then this class fires another event that goes into ParkingLotController
     * to take the name of the parking space that has just been reserved by the user. "Login" event is fired once customer logged
     * in, and gets its username.
     * @param evt gets name of the specific fired event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ReserveSpace"))
        {
            propertyChangeSupport.firePropertyChange("ParkingSpaceName", null, evt.getNewValue());
        }
        else if(evt.getPropertyName().equals("Login"))
        {
            userName = (String) evt.getOldValue();
        }
    }

    /**
     * Gets the errorLabel information.
     * @return error text.
     */
    public StringProperty getErrorLabel()
    {
        return errorLabel;
    }

    /**
     * Gets the name of A1 parking space.
     * @return spaceA1 name;
     **/
    public StringProperty spaceA1Property() {
        return spaceA1;
    }

    /**
     * Gets the name of A2 parking space.
     * @return spaceA2 name;
     **/

    public StringProperty spaceA2Property() {
        return spaceA2;
    }

    /**
     * Gets the name of A3 parking space.
     * @return spaceA3 name;
     **/

    public StringProperty spaceA3Property() {
        return spaceA3;
    }

    /**
     * Gets the name of A4 parking space.
     * @return spaceA4 name;
     **/

    public StringProperty spaceA4Property() {
        return spaceA4;
    }


    /**
     * Gets the name of A5 parking space.
     * @return spaceA5 name;
     **/
    public StringProperty spaceA5Property() {
        return spaceA5;
    }

    /**
     * Gets the name of A6 parking space.
     * @return spaceA6 name;
     **/

    public StringProperty spaceA6Property() {
        return spaceA6;
    }

    /**
     * Gets the name of B1 parking space.
     * @return spaceB1 name;
     **/

    public StringProperty spaceB1Property() {
        return spaceB1;
    }

    /**
     * Gets the name of B2 parking space.
     * @return spaceB2 name;
     **/

    public StringProperty spaceB2Property() {
        return spaceB2;
    }

    /**
     * Gets the name of B3 parking space.
     * @return spaceB3 name;
     **/

    public StringProperty spaceB3Property() {
        return spaceB3;
    }

    /**
     * Gets the name of B4 parking space.
     * @return spaceB4 name;
     **/

    public StringProperty spaceB4Property() {
        return spaceB4;
    }

    /**
     * Gets the name of C1 parking space.
     * @return spaceC1 name;
     **/

    public StringProperty spaceC1Property() {
        return spaceC1;
    }

    /**
     * Gets the name of C2 parking space.
     * @return spaceC2 name;
     **/

    public StringProperty spaceC2Property() {
        return spaceC2;
    }


    /**
     * Gets the name of C3 parking space.
     * @return spaceC3 name;
     **/

    public StringProperty spaceC3Property() {
        return spaceC3;
    }

    /**
     * Gets the name of C4 parking space.
     * @return spaceC4 name;
     **/

    public StringProperty spaceC4Property() {
        return spaceC4;
    }

    /**
     * Gets the name of D1 parking space.
     * @return spaceD1 name;
     **/

    public StringProperty spaceD1Property() {
        return spaceD1;
    }

    /**
     * Gets the name of D2 parking space.
     * @return spaceD2 name;
     **/

    public StringProperty spaceD2Property() {
        return spaceD2;
    }

    /**
     * Gets the name of D3 parking space.
     * @return spaceD3 name;
     **/

    public StringProperty spaceD3Property() {
        return spaceD3;
    }

    /**
     * Gets the name of D4 parking space.
     * @return spaceD4 name;
     **/

    public StringProperty spaceD4Property() {
        return spaceD4;
    }

    /**
     * Gets the name of D5 parking space.
     * @return spaceD5 name;
     **/

    public StringProperty spaceD5Property() {
        return spaceD5;
    }

    /**
     * Gets the name of D6 parking space.
     * @return spaceD6 name;
     **/

    public StringProperty spaceD6Property() {
        return spaceD6;
    }

    /**
     * Method that fires an event in model once the specific parking space is not occupied by user. Returns true if
     * the process has been done, false if not.
     * @param name of the parking space.
     * @return
     */
    public boolean onClickUndef(String name)
    {
        try {
            if(!model.getParkingLot().isOcuppiedByUser(userName))
            {
                model.pressOnParkingSpace(name);
                return true;
            }
        }
        catch (RemoteException ignored)
        {

        }
        return false;
    }

    /**
     * Verifies if the specific parking space is yours or not and returns true, false if not.
     * @param nameOfParkingSpace
     * @return
     */

    public boolean parkingSpaceIsYours(String nameOfParkingSpace)
    {
        try {
            ParkingLot parkingLot = model.getParkingLot();
            for(int i = 0; i < parkingLot.size(); i++)
            {
                if(parkingLot.getParkingSpace(i).getNameOfParkingSpace().equals(nameOfParkingSpace) && parkingLot.isOcuppiedByUser(userName))
                {
                    return true;
                }
            }
        }
        catch (RemoteException ignored)
        {

        }
        return false;
    }

    /**
     * Method provided by Observer pattern. It adds a class as a listener for this viewmodel.
     * @param listener
     */

    @Override public void addListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Method provided by Observer pattern. It removes a class as a listener for this viewmodel.
     * @param listener
     */

    @Override public void removeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
