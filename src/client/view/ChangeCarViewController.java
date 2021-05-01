package client.view;

import client.viewModel.ChangeCarViewModel;
import client.viewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

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
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.reset();
  }

  @FXML private void onChange()
  {

  }
}
