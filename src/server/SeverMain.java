package server;

import server.model.RemoteInterface;
import server.model.RemoteModel;
import server.model.mediator.Model;
import server.model.mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class SeverMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Model model = new ModelManager();
        RemoteInterface server = new RemoteModel(model);
        server.startRegistry();
        server.startServer();
    }
}
