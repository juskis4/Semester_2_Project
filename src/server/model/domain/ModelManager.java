package server.model.domain;

public class ModelManager implements Model{

    private ParkingLot parkingLot;
    private Login login;
    private UserList userList;

    public ModelManager()
    {
        parkingLot = new ParkingLot();
        login = new Login();
        userList = new UserList();
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
        return login.isCorrectLogin(userName,password);
    }

    @Override
    public void registerFirstAndLastName(String firstName, String lastName, String username) {
        userList..setFirstname(firstName);
        user.setLastname(lastName);
    }
}
