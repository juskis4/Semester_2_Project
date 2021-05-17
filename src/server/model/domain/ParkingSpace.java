package server.model.domain;

public class ParkingSpace
{
  private boolean isOccupied;
  private String nameOfParkingSpace;
  private User user;
  

  public ParkingSpace(String nameOfParkingSpace)
  {
    this.nameOfParkingSpace = nameOfParkingSpace;
    isOccupied = false;
    this.user = null;
  }

  public void setOccupied(boolean isOccupied, User user)
  {
    this.isOccupied = isOccupied;
    this.user = user;
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
