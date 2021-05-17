package server.model.domain;

public interface Model {

    void reserveParkingSpace(ParkingSpace parkingSpace, User user);
    void reserveParkingSpace(int index, User user);
}
