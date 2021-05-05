package server.model.domain;

public class ModelManager implements Model{

    private ParkingLot parkingLot;

    public ModelManager()
    {
        parkingLot = new ParkingLot();
    }

    @Override
    public void reserveParkingSpace(ParkingSpace parkingSpace) {
        for(int i = 0; i < parkingLot.size(); i++)
        {
            if(parkingLot.getParkingSpace(i).equals(parkingSpace) && !(parkingSpace.getIsOccupied()))
            {
                parkingLot.getParkingSpace(i).setOccupied(true);
            }
        }
    }

    @Override
    public void reserveParkingSpace(int index)
    {
        if(!parkingLot.getParkingSpace(index).getIsOccupied())
        {
            parkingLot.getParkingSpace(index).setOccupied(true);
        }
    }
}
