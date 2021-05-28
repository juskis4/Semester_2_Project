package client.view;

import client.viewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A controller for login view.
 */
public class LoginViewController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    private ViewHandler viewHandler;
    private Region root;
    private LoginViewModel viewModel;

    /**
     * Constructor that is empty.
     */
    public LoginViewController() {

    }
    /**
     * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
     * @param viewHandler views handler.
     * @param viewModel cancel reservation viewmodel.
     * @param root root.
     */
    public void init(ViewHandler viewHandler, LoginViewModel viewModel, Region root) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        this.root = root;

        usernameField.textProperty().bindBidirectional(viewModel.getUserNameProperty());
        passwordField.textProperty().bindBidirectional(viewModel.getPasswordProperty());
        errorLabel.textProperty().bindBidirectional(viewModel.getErrorProperty());
    }

    /**
     * Getter for root.
     * @return root.
     */
    public Region getRoot() {
        return root;
    }

    /**
     * Resetting the controller.
     */
    public void reset() {
        viewModel.reset();
    }

    @FXML
    private void onLogin() {
        try{
            viewModel.login();
            viewHandler.openView("ParkingLotView");
        }
        catch (Exception e)
        {
            errorLabel.setText("Wrong password or username!");
        }

    }

    @FXML
    private void onRegister() {
        viewHandler.openView("Register");
    }

}
