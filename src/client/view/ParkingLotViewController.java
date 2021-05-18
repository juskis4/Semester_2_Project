package client.view;

import client.viewModel.ParkingLotViewModel;
import client.viewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

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
}
