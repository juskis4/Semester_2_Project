package client.viewModel;

import client.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.*;

import java.rmi.RemoteException;

public class ReserveViewModel
{
  private StringProperty nameOfParkingSpace;
  private StringProperty errorLabelProperty;
  private static final String USER_NULL = "User not set";
  private StringProperty dateInString;
  private IntegerProperty h;
  private IntegerProperty m;

  private Model model;

  public ReserveViewModel(Model model) throws RemoteException
  {
    this.model = model;
    if(getUser() == null)
    {
      nameOfParkingSpace = new SimpleStringProperty(USER_NULL);
    }
    else {
      String parkingSpaceName;
      parkingSpaceName = getParkingLot().getParkingSpaceByUser(
              getUser()).getNameOfParkingSpace();
      nameOfParkingSpace = new SimpleStringProperty(parkingSpaceName);
    }
    this.dateInString = new SimpleStringProperty("");
    this.errorLabelProperty = new SimpleStringProperty("");
    this.h = new SimpleIntegerProperty(0);
    this.m = new SimpleIntegerProperty(0);
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

  public void registerSpace() throws RemoteException
  {
    model.registerSpace(model.getUserByUserName().getUsername(), getParkingSpace(), getTime(), getDate());
    getParkingSpace().setOccupied(true, model.getUserByUserName());
  }
  public ParkingLot getParkingLot() throws RemoteException
  {
    return model.getParkingLot();
  }

  public User getUser() throws RemoteException
  {
    return model.getUserByUserName();
  }

  public void reset()
  {
    try
    {
      if(getUser() == null)
      {
        nameOfParkingSpace = new SimpleStringProperty(USER_NULL);
      }
      else {
        String parkingSpaceName;
        parkingSpaceName = getParkingLot().getParkingSpaceByUser(
                getUser()).getNameOfParkingSpace();
        nameOfParkingSpace = new SimpleStringProperty(parkingSpaceName);
      }
      this.dateInString = new SimpleStringProperty("");
      this.errorLabelProperty = new SimpleStringProperty("");
      this.h = new SimpleIntegerProperty(0);
      this.m = new SimpleIntegerProperty(0);
    }
    catch (RemoteException ignored)
    {

    }
  }

}
