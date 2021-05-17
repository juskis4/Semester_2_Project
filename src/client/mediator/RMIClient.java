package client.mediator;

import java.rmi.Naming;

public class RMIClient implements RemoteInterface{

    private RemoteInterface server;

    public RMIClient()
    {
        try
        {
            server = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ParkingLot");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
