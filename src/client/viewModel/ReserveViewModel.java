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
  private StringProperty dateInString;
  private IntegerProperty h;
  private IntegerProperty m;

  private Model model;

  public ReserveViewModel(Model model)
  {
    this.model = model;
    this.nameOfParkingSpace = new SimpleStringProperty("");
    this.dateInString = new SimpleStringProperty("");
    this.h = new SimpleIntegerProperty(0);
    this.m = new SimpleIntegerProperty(0);
  }

  public StringProperty dateInStringProperty()
  {
    return dateInString;
  }

  public Time getTime()
  {
    Time time = new Time(h.get(), m.get());
    return time;
  }

  public ParkingSpace getParkingSpace() throws RemoteException
  {
    ParkingSpace parkingSpace = new ParkingSpace(nameOfParkingSpace.get());
    parkingSpace.setOccupied(true, model.getUserByUserName());
    return parkingSpace;
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
  }
}
