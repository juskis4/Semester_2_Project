package server.model.domain;

/**
 * A class that represents vehicle.
 */
public class Vehicle
{
  private String LicenseNo;
  private String Color;
  private String CarBrand;

  /**
   * A constructor for vehicle.
   * @param licenseNo vehicles license number.
   * @param color vehicles color.
   * @param carBrand vehicles brand.
   */
  public Vehicle(String licenseNo, String color, String carBrand)
  {
    changeCar(licenseNo,color,carBrand);
  }

  /**
   * A getter for vehicles brand
   * @return vehicles brand.
   */
  public String getCarBrand()
  {
    return CarBrand;
  }

  /**
   * A getter for vehicles color.
   * @return vehicles color.
   */
  public String getColor()
  {
    return Color;
  }

  /**
   * A getter for vehicles license number.
   * @return vehicles license number.
   */
  public String getLicenseNo()
  {
    return LicenseNo;
  }

  /**
   * A method that changes vehicles information or the vehicle itself.
   * @param licenseNo license number that is going to be changed to.
   * @param color color that is going to be changes to.
   * @param carBrand brand that is going to be changed to.
   */
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

  /**
   * A method that puts vehicle into a specific format.
   * @return string with vehicle in a specific format.
   */
  @Override public String toString()
  {
    return "Vehicle " + CarBrand + ", license no: " + LicenseNo + ", color: " + Color;
  }
}
