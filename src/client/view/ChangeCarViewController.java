package client.view;

import client.viewModel.ChangeCarViewModel;
import client.viewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.rmi.RemoteException;

/**
 * A controller for change car view.
 */
public class ChangeCarViewController
{
  @FXML private TextField carBrandField;
  @FXML private TextField licenseNoField;
  @FXML private TextField colorField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ChangeCarViewModel viewModel;

  /**
   * Constructor that is empty.
   */
  public ChangeCarViewController()
  {

  }
  /**
   * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
   * @param viewHandler views handler.
   * @param viewModel cancel reservation viewmodel.
   * @param root root.
   */
  public void init(ViewHandler viewHandler, ChangeCarViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    carBrandField.textProperty().bindBidirectional(viewModel.getCarBrandProperty());
    licenseNoField.textProperty().bindBidirectional(viewModel.getLicenseNoProperty());
    colorField.textProperty().bindBidirectional(viewModel.getColorProperty());
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorProperty());
  }

  /**
   * Getter for root.
   * @return root.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * Resetting the controller.
   */
  public void reset()
  {
    viewModel.reset();
  }

  @FXML private void onChange() throws RemoteException
  {
    viewModel.registerVehicle();
  }

  @FXML private void onParkingLot()
  {
    viewHandler.openView("ParkingLotView");
  }

  @FXML private void onProfile()
  {
    viewHandler.openView("ProfileView");
  }
}
