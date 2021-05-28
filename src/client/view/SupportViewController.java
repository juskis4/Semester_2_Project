package client.view;

import client.viewModel.SupportViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * A controller for support view.
 */
public class SupportViewController
{
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private SupportViewModel supportViewModel;

  /**
   * Constructor that is empty.
   */
  public SupportViewController()
  {

  }
  /**
   * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
   * @param viewHandler views handler.
   * @param viewModel cancel reservation viewmodel.
   * @param root root.
   */
  public void init(ViewHandler viewHandler, SupportViewModel viewModel, Region root)
  {
    this.supportViewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
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
    supportViewModel.reset();
  }


  @FXML private void onProfile()
  {
    viewHandler.openView("ProfileView");
  }

  @FXML private void onParkingLot()
  {
    viewHandler.openView("ParkingLotView");
  }

  @FXML private void onChangeYourCar()
  {
    viewHandler.openView("ChangeCar");
  }

  @FXML private void onWorkingHours()
  {
    viewHandler.openView("WorkingHoursView");
  }

  @FXML private void onSubmit()
  {

  }
}
