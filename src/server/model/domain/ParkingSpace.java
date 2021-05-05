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

  public boolean equals(Object obj)
  {
    if(!(obj instanceof ParkingSpace))
      return false;
    ParkingSpace other = (ParkingSpace) obj;
    return isOccupied == other.isOccupied && nameOfParkingSpace.equals(other.nameOfParkingSpace);
  }

  @Override public String toString()
  {
    return "ParkingSpace{" + "isOccupied=" + isOccupied
        + ", nameOfParkingSpace='" + nameOfParkingSpace + '\'' + '}';
  }
}
