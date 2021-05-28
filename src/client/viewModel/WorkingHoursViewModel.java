package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that represents a model for working hours.
 */
public class WorkingHoursViewModel
{

    private StringProperty errorProperty;
    private Model model;

    /**
     * Constructor which initializes model and properties.
     * @param model
     */
    public WorkingHoursViewModel(Model model)
    {
        this.model = model;
        errorProperty = new SimpleStringProperty("");
    }

    /**
     * Resetting error property.
     */
    public void reset()
    {
        errorProperty.set("");
    }

    /**
     * Getter for model.
     * @return model.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Getter for error property.
     * @return error property.
     */
    public StringProperty getErrorProperty()
    {
        return errorProperty;
    }

}
