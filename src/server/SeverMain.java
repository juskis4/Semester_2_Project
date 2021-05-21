package server;

import server.model.RemoteModel;
import server.model.mediator.Model;
import server.model.RemoteInterface;
import server.model.mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class SeverMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Model model = new ModelManager();
        RemoteModel server = new RemoteModel(model);
    }
}
