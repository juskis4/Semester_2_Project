package client.model;

public interface Model
{
    void register(String userName, String password);
    boolean login(String userName, String password);
    void registerFirstAndLastName(String firstName, String lastName);
}
