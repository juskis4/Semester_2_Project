package client.viewModel;

import client.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Locale;

/**
 * A class that represents the viewmodel for Reserve window and it is part of MVVM pattern.
 */
public class ReserveViewModel implements PropertyChangeListener
{
  private StringProperty nameOfParkingSpace;
  private StringProperty errorLabelProperty;
  private StringProperty dateInString;
  private IntegerProperty h;
  private IntegerProperty m;
  private String userName;

  private Model model;

  /**
   * A constructor that sets the Label text for every StringProperty variable.
   * The model also adds this class as a listener.
   */
  public ReserveViewModel(Model model) throws RemoteException, SQLException
  {
    this.model = model;
    userName = "";
    model.addListener(this);
    nameOfParkingSpace = new SimpleStringProperty("");
    this.dateInString = new SimpleStringProperty("");
    this.errorLabelProperty = new SimpleStringProperty("");
    this.h = new SimpleIntegerProperty(0);
    this.m = new SimpleIntegerProperty(0);
  }

  /**
   * Method part of Observer pattern, 2 statements.
   * It gets the name of parking space if "PressOnReserve" is fired. If "Login" event is fired, it gets the actual username.
   * @param evt helps get the name of event.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if(evt.getPropertyName().equals("PressOnReserve"))
    {
        nameOfParkingSpace.setValue((String) evt.getNewValue());
    }
    else if(evt.getPropertyName().equals("Login"))
    {
      userName = (String) evt.getOldValue();
    }
  }

  /**
   * Gets the informations about date.
   * @return
   */
  public StringProperty dateInStringProperty()
  {
    return dateInString;
  }

  /**
   * Gets error text, if any.
   * @return
   */
  public StringProperty getErrorLabelProperty()
  {
    return errorLabelProperty;
  }

  /**
   * Creates a Time object to be passed on register, and returns it.
   * @return
   */
  public Time getTime()
  {
    Time time = new Time(h.get(), m.get());
    return time;
  }

  /**
   * Creates user's parking space.
   * @return
   * @throws RemoteException
   */
  public ParkingSpace getParkingSpace() throws RemoteException
  {
    return model.getParkingLot().getParkingSpaceByName(nameOfParkingSpace.get());

  }

  /**
   * Gets reserved hours.
   * @return
   */
  public IntegerProperty hProperty()
  {
    return h;
  }

  /**
   * Gets reserved minutes.
   * @return
   */

  public IntegerProperty mProperty()
  {
    return m;
  }

  /**
   * Gets the name of parking space.
   * @return
   */
  public StringProperty nameOfParkingSpaceProperty()
  {
    return nameOfParkingSpace;
  }

  /**
   * Creates a Date object with informations selected on calendar and returns it.
   * @return
   */
  public Date getDate()
  {
    String date = dateInString.get();
    String delims = "[/]";
    String[] tokens = date.split(delims);
    int month = Integer.parseInt(tokens[0]);
    int day = Integer.parseInt(tokens[1]);
    int year = Integer.parseInt(tokens[2]);
    Date dateReturned = new Date(day, month, year);
    return dateReturned;
  }

  /**
   * A method that registers the time after user registered his parking space. Create a time with the current local time and an
   * ending time that calls the method ".set (seconds)". The seconds are calculated according to the
   * hours and minutes set by the user.
   * @throws RemoteException
   * @throws SQLException
   */
  public void registerSpace() throws RemoteException, SQLException
  {
    //creating current time and ending time
    int seconds = getTime().convertToSeconds();
    LocalTime localTime = LocalTime.now();
    Time currentTime = new Time(localTime.getHour(),localTime.getMinute());
    Time endingTime = currentTime.copy();
    endingTime.tic(seconds);
    model.registerSpace(userName, getParkingSpace(), currentTime,endingTime, getDate());
  }

  /**
   * Gets the parking lot.
   * @return
   * @throws RemoteException
   */
  public ParkingLot getParkingLot() throws RemoteException
  {
    return model.getParkingLot();
  }

  /**
   * Gets the user.
   * @return
   * @throws RemoteException
   * @throws SQLException
   */

  public User getUser() throws RemoteException, SQLException
  {
    return model.getUserByUserName();
  }

  /**
   * A method that adds logs with informations about when, where, what car was parked on specific parking space. Also adds
   * into database.
   * @throws RemoteException
   * @throws SQLException
   */

  public void addLog() throws RemoteException, SQLException
  {
    model.addLog(userName, getParkingSpace().getNameOfParkingSpace());
  }

  /**
   * Resets all StringPropert variables.
   */

  public void reset()
  {
      this.dateInString = new SimpleStringProperty("");
      this.errorLabelProperty = new SimpleStringProperty("");
      this.h = new SimpleIntegerProperty(0);
      this.m = new SimpleIntegerProperty(0);
  }
}
