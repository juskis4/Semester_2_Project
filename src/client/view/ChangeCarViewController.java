package client.view;

import client.viewModel.ChangeCarViewModel;
import client.viewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.rmi.RemoteException;

public class ChangeCarViewController
{
  @FXML private TextField carBrandField;
  @FXML private TextField licenseNoField;
  @FXML private TextField colorField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ChangeCarViewModel viewModel;

  public ChangeCarViewController()
  {

  }

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

  public Region getRoot()
  {
    return root;
  }

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
