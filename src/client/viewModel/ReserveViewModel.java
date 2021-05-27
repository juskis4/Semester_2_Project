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

public class ReserveViewModel implements PropertyChangeListener
{
  private StringProperty nameOfParkingSpace;
  private StringProperty errorLabelProperty;
  private StringProperty dateInString;
  private IntegerProperty h;
  private IntegerProperty m;
  private String userName;

  private Model model;

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

  public StringProperty dateInStringProperty()
  {
    return dateInString;
  }

  public StringProperty getErrorLabelProperty()
  {
    return errorLabelProperty;
  }

  public Time getTime()
  {
    Time time = new Time(h.get(), m.get());
    return time;
  }

  public ParkingSpace getParkingSpace() throws RemoteException
  {
    return model.getParkingLot().getParkingSpaceByName(nameOfParkingSpace.get());

  }

  public IntegerProperty hProperty()
  {
    return h;
  }

  public IntegerProperty mProperty()
  {
    return m;
  }

  public StringProperty nameOfParkingSpaceProperty()
  {
    return nameOfParkingSpace;
  }

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
  public ParkingLot getParkingLot() throws RemoteException
  {
    return model.getParkingLot();
  }

  public User getUser() throws RemoteException, SQLException
  {
    return model.getUserByUserName();
  }

  public void addLog() throws RemoteException, SQLException
  {
    model.addLog(userName, getParkingSpace().getNameOfParkingSpace());
  }

  public void reset()
  {
      this.dateInString = new SimpleStringProperty("");
      this.errorLabelProperty = new SimpleStringProperty("");
      this.h = new SimpleIntegerProperty(0);
      this.m = new SimpleIntegerProperty(0);
  }
}
