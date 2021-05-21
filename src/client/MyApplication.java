package client;

import client.mediator.RMIClient;
import client.model.Model;
import client.model.ModelManager;
import client.view.ViewHandler;
import client.viewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class MyApplication extends Application {


    @Override
    public void start(Stage stage) throws RemoteException {
            RMIClient client = new RMIClient();
            Model model = new ModelManager(client);
            ViewModelFactory viewModelFactory = new ViewModelFactory(model);
            ViewHandler viewHandler = new ViewHandler(viewModelFactory);
            viewHandler.start(stage);
    }
}
