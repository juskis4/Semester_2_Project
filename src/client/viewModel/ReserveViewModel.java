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
  private StringProperty licenseNo;
  private StringProperty color;
  private StringProperty carBrand;
  private StringProperty username;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty nameOfParkingSpace;
  private IntegerProperty day;
  private IntegerProperty month;
  private IntegerProperty year;
  private IntegerProperty h;
  private IntegerProperty m;
  private IntegerProperty s;

  private Model model;

  public ReserveViewModel(Model model)
  {
    this.model = model;
    this.licenseNo = new SimpleStringProperty("");
    this.color = new SimpleStringProperty("");
    this.carBrand = new SimpleStringProperty("");
    this.username = new SimpleStringProperty("");
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.nameOfParkingSpace = new SimpleStringProperty("");
    this.day = new SimpleIntegerProperty(0);
    this.month  = new SimpleIntegerProperty(0);
    this.year = new SimpleIntegerProperty(0);
    this.h = new SimpleIntegerProperty(0);
    this.m = new SimpleIntegerProperty(0);
    this.s = new SimpleIntegerProperty(0);
  }
  public Vehicle getVehicle()
  {
    Vehicle vehicle = new Vehicle(licenseNo.get(), color.get(), carBrand.get());
    return vehicle;
  }

  public Date getDate()
  {
    Date date = new Date(day.get(), month.get(), year.get());
    return date;
  }

  public Time getTime()
  {
    Time time = new Time(h.get(), m.get(), s.get());
    return time;
  }

  public User getUser()
  {
    User user = new User(username.get());
    user.setFirstname(firstName.get());
    user.setLastname(lastName.get());
    return user;
  }

  public ParkingSpace getParkingSpace()
  {
    ParkingSpace parkingSpace = new ParkingSpace(nameOfParkingSpace.get());
    parkingSpace.setOccupied(true, getUser());
    return parkingSpace;
  }

  public void registerSpace() throws RemoteException
  {
    model.registerSpace(username.get(), getVehicle(), getParkingSpace(), getTime(), getDate());
  }
}
