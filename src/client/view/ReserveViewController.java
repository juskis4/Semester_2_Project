package client.view;

import client.utility.IntStringConverter;
import client.viewModel.ParkingLotViewModel;
import client.viewModel.ReserveViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import server.model.domain.User;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Controller for reserve view.
 */
public class ReserveViewController
{
  @FXML private TextField hourField;
  @FXML private TextField minField;
  @FXML private DatePicker reserveDate;
  @FXML private Label parkingSpaceField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ReserveViewModel viewModel;

  /**
   * Constructor that is empty.
   */
  public ReserveViewController()
  {

  }
  /**
   * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
   * @param viewHandler views handler.
   * @param viewModel cancel reservation viewmodel.
   * @param root root.
   */
  public void init(ViewHandler viewHandler, ReserveViewModel viewModel, Region root)
      throws RemoteException
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    parkingSpaceField.textProperty().bindBidirectional(viewModel.nameOfParkingSpaceProperty());
    Bindings.bindBidirectional(hourField.textProperty(),
        viewModel.hProperty(), new IntStringConverter());
    Bindings.bindBidirectional(minField.textProperty(),
        viewModel.mProperty(), new IntStringConverter());
    TextField dateEditor = reserveDate.getEditor();
    viewModel.dateInStringProperty().bindBidirectional(dateEditor.textProperty());
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());
  }

  /**
   * Resetting the controller.
   */
  public void reset()
  {
    viewModel.reset();
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
   * A method that calls register space, add log methods and opens parking lot view after pressing reserve button.
   * @throws RemoteException
   * @throws SQLException
   */
  @FXML public void onReserve() throws RemoteException, SQLException
  {
    viewModel.registerSpace();
    viewModel.addLog();
    viewHandler.openView("ParkingLotView");
  }

  /**
   * A method that opens working hours window.
   */
  @FXML public void onWorkingHours()
  {
    viewHandler.openView("WorkingHoursView");
  }
}
