package server.model.domain;

public class User
{
  private Vehicle vehicle;

  public User()
  {
    this.vehicle = null;
  }

  public void registerVehicle(String licenseNo, String color, String carBrand)
  {
    this.vehicle = new Vehicle(licenseNo, color, carBrand);
  }
}
