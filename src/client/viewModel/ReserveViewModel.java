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
  private IntegerProperty day;
  private IntegerProperty month;
  private IntegerProperty year;
  private IntegerProperty h;
  private IntegerProperty m;

  private Model model;

  public ReserveViewModel(Model model)
  {
    this.model = model;
    this.nameOfParkingSpace = new SimpleStringProperty("");
    this.day = new SimpleIntegerProperty(0);
    this.month  = new SimpleIntegerProperty(0);
    this.year = new SimpleIntegerProperty(0);
    this.h = new SimpleIntegerProperty(0);
    this.m = new SimpleIntegerProperty(0);
  }
  public Date getDate()
  {
    Date date = new Date(day.get(), month.get(), year.get());
    return date;
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

  public IntegerProperty dayProperty()
  {
    return day;
  }

  public IntegerProperty monthProperty()
  {
    return month;
  }

  public IntegerProperty yearProperty()
  {
    return year;
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

  public void registerSpace() throws RemoteException
  {
    model.registerSpace(model.getUserByUserName().getUsername(), getParkingSpace(), getTime(), getDate());
  }
}
