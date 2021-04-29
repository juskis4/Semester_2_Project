package server.model.domain;

public class Vehicle
{
  private String LicenseNo;
  private String Color;
  private String CarBrand;

  public Vehicle(String licenseNo, String color, String carBrand)
  {
    this.LicenseNo = licenseNo;
    this.Color = color;
    this.CarBrand = carBrand;
  }

  public String getCarBrand()
  {
    return CarBrand;
  }

  public String getColor()
  {
    return Color;
  }

  public String getLicenseNo()
  {
    return LicenseNo;
  }

  public void changeCar(String licenseNo, String color, String carBrand)
  {
    this.LicenseNo = licenseNo;
    this.Color = color;
    this.CarBrand = carBrand;
  }

  @Override public String toString()
  {
    return "Vehicle{" + "LicenseNo='" + LicenseNo + '\'' + ", Color='" + Color
        + '\'' + ", CarBrand='" + CarBrand + '\'' + '}';
  }
}
