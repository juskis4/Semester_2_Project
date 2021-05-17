package server.model.domain;

public interface Model {

    void reserveParkingSpace(ParkingSpace parkingSpace, User user);
    void reserveParkingSpace(int index, User user);
    void register(String userName, String password);
    boolean login(String userName, String password);
    void registerFirstAndLastName(String firstName, String lastName);
}
