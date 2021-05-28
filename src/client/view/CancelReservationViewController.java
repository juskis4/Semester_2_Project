package client.view;

import client.viewModel.CancelReservationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * A controller for cancel reservation view.
 */
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

    /**
     * Controller constructor that is empty.
     */
    public CancelReservationViewController() {

    }

    /**
     * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
     * @param viewHandler views handler.
     * @param viewModel cancel reservation viewmodel.
     * @param root root.
     */
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

    /**
     * Resetting the controller.
     */
    public void reset() {
        viewModel.reset();
    }

    /**
     * Getter for root.
     * @return root.
     */
    public Region getRoot() {
        return root;
    }

    @FXML
    private void onCancel() {
        viewModel.onCancel();
    }
}
