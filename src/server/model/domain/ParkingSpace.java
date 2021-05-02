package server.model.domain;

public class ParkingSpace
{
  private boolean isOccupied;
  private String nameOfParkingSpace;
  

  public ParkingSpace(String nameOfParkingSpace)
  {
    this.nameOfParkingSpace = nameOfParkingSpace;
    isOccupied = false;
  }

  public void setOccupied(boolean isOccupied)
  {
    this.isOccupied = isOccupied;
  }

  public String getNameOfParkingSpace()
  {
    return nameOfParkingSpace;
  }

  public boolean getIsOccupied()
  {
    return isOccupied;
  }

  @Override public String toString()
  {
    return "ParkingSpace{" + "isOccupied=" + isOccupied
        + ", nameOfParkingSpace='" + nameOfParkingSpace + '\'' + '}';
  }
}
