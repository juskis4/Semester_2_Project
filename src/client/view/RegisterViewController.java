package client.view;

import client.viewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

/**
 * Controller for register view.
 */
public class RegisterViewController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    private ViewHandler viewHandler;
    private Region root;
    private RegisterViewModel viewModel;

    /**
     * Constructor that is empty.
     */
    public RegisterViewController() {
    }
    /**
     * Initialization method to initialize controllers viewmodel, viewhandler, root and binding instance variables to viewmodels.
     * @param viewHandler views handler.
     * @param viewModel cancel reservation viewmodel.
     * @param root root.
     */
    public void init(ViewHandler viewHandler, RegisterViewModel viewModel, Region root) {
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
    private void onRegister() {
        viewModel.register();
        viewHandler.openView("Login");
    }

    @FXML
    private void onLogin() {
        viewHandler.openView("Login");
    }
}
