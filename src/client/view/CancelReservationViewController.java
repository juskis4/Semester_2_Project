package client.view;

import client.viewModel.CancelReservationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class CancelReservationViewController {

    @FXML
    private Label errorLabel;
    @FXML
    private Label parkingSpaceField;
    @FXML
    private Label authorName;
    @FXML
    private Label vehicleInfo;

    private ViewHandler viewHandler;
    private CancelReservationViewModel viewModel;
    private Region root;

    public CancelReservationViewController() {

    }

    public void init(ViewHandler viewHandler, CancelReservationViewModel viewModel, Region root) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        this.root = root;

        errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());
        parkingSpaceField.textProperty().bindBidirectional(viewModel.getParkingSpaceFieldProperty());
        authorName.textProperty().bindBidirectional(viewModel.getAuthorNameProperty());
        vehicleInfo.textProperty().bindBidirectional(viewModel.getVehicleInfoProperty());

        reset();
    }

    public void reset() {
        viewModel.reset();
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    private void onCancel() {
        viewModel.onCancel();
    }
}
