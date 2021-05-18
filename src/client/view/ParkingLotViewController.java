package client.view;

import client.viewModel.ParkingLotViewModel;
import client.viewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import server.model.domain.ParkingLot;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;

public class ParkingLotViewController {

    @FXML private Label spaceA1;
    @FXML private Label spaceA2;
    @FXML private Label spaceA3;
    @FXML private Label spaceA4;
    @FXML private Label spaceA5;
    @FXML private Label spaceA6;

    @FXML private Label spaceB1;
    @FXML private Label spaceB2;
    @FXML private Label spaceB3;
    @FXML private Label spaceB4;

    @FXML private Label spaceC1;
    @FXML private Label spaceC2;
    @FXML private Label spaceC3;
    @FXML private Label spaceC4;

    @FXML private Label spaceD1;
    @FXML private Label spaceD2;
    @FXML private Label spaceD3;
    @FXML private Label spaceD4;
    @FXML private Label spaceD5;
    @FXML private Label spaceD6;

    private ViewHandler viewHandler;
    private Region root;
    private ParkingLotViewModel viewModel;

    public ParkingLotViewController(){

    }

    public void init(ViewHandler viewHandler, ParkingLotViewModel viewModel, Region root)
    {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        this.root = root;

        spaceA1.setTextFill(Color.rgb(0,255,0));
        spaceA2.setTextFill(Color.rgb(0,255,0));
        spaceA3.setTextFill(Color.rgb(0,255,0));
        spaceA4.setTextFill(Color.rgb(0,255,0));
        spaceA5.setTextFill(Color.rgb(0,255,0));
        spaceA6.setTextFill(Color.rgb(0,255,0));

        usernameField.textProperty().bindBidirectional(viewModel.getUserNameProperty());
        passwordField.textProperty().bindBidirectional(viewModel.getPasswordProperty());
        errorLabel.textProperty().bindBidirectional(viewModel.getErrorProperty());
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {
        viewModel.reset();
    }

    @FXML private void onLogin()
    {
        if(viewModel.login()){

        }
    }
}
