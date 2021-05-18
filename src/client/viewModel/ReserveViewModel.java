package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.domain.Date;
import server.model.domain.ParkingSpace;
import server.model.domain.Time;
import server.model.domain.Vehicle;

public class ReserveViewModel
{
  private StringProperty licenseNo;
  private StringProperty color;
  private StringProperty carBrand;
  private Model model;

  public ReserveViewModel(Model model)
  {
    this.model = model;
    this.licenseNo = new SimpleStringProperty("");
    this.color = new SimpleStringProperty("");
    this.carBrand = new SimpleStringProperty("");
  }
  public Vehicle getVehicle()
  {
    Vehicle vehicle = new Vehicle(licenseNo.get(), color.get(), carBrand.get());
    return vehicle;
  }

  public void registerSpace(String username, Vehicle vehicle,
      ParkingSpace parkingSpace, Time time, Date date)
  {

  }
}
