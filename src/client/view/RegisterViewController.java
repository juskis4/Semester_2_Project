package client.view;

import client.viewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class RegisterViewController
{
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private RegisterViewModel viewModel;

  public RegisterViewController()
  {
    //////
  }

  public void init(ViewHandler viewHandler, RegisterViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

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

  @FXML private void onRegister()
  {
    viewModel.register();
  }
}
