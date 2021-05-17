package server.model.domain;

public class ModelManager implements Model{

    private ParkingLot parkingLot;
    private Login login;
    private User user;

    public ModelManager()
    {
        parkingLot = new ParkingLot();
        login = new Login();
        user = new User(login);
    }

    @Override
    public void reserveParkingSpace(ParkingSpace parkingSpace, User user) {
        for(int i = 0; i < parkingLot.size(); i++)
        {
            if(parkingLot.getParkingSpace(i).equals(parkingSpace) && !(parkingSpace.getIsOccupied()))
            {
                parkingLot.getParkingSpace(i).setOccupied(true, user);
            }
        }
    }

    @Override
    public void reserveParkingSpace(int index, User user)
    {
        if(!parkingLot.getParkingSpace(index).getIsOccupied())
        {
            parkingLot.getParkingSpace(index).setOccupied(true, user);
        }
    }

    @Override
    public void register(String userName, String password) {
        login.register(userName,password);
    }

    @Override
    public boolean login(String userName, String password) {
        return user.isCorrectLogin(userName,password);
    }

    @Override
    public void registerFirstAndLastName(String firstName, String lastName) {
        user.setFirstname(firstName);
        user.setLastname(lastName);
    }
}
