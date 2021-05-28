package server.model.domain;

public class Vehicle
{
  private String LicenseNo;
  private String Color;
  private String CarBrand;

  public Vehicle(String licenseNo, String color, String carBrand)
  {
    changeCar(licenseNo,color,carBrand);
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
    if(licenseNo == null)
    {
      throw new IllegalArgumentException("License number is null.");
    }
    else this.LicenseNo = licenseNo;
    if(color == null)
    {
      throw new IllegalArgumentException("Color is null");
    }
    else this.Color = color;
    if(carBrand == null)
    {
      throw new IllegalArgumentException("Car brand is null");
    }
    else this.CarBrand = carBrand;
  }

  @Override public String toString()
  {
    return "Vehicle " + CarBrand + ", license no: " + LicenseNo + ", color: " + Color;
  }
}
