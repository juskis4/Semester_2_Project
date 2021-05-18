package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ParkingLotViewModel {

    private StringProperty spaceA1;
    private StringProperty spaceA2;
    private StringProperty spaceA3;
    private StringProperty spaceA4;
    private StringProperty spaceA5;
    private StringProperty spaceA6;

    private StringProperty spaceB1;
    private StringProperty spaceB2;
    private StringProperty spaceB3;
    private StringProperty spaceB4;

    private StringProperty spaceC1;
    private StringProperty spaceC2;
    private StringProperty spaceC3;
    private StringProperty spaceC4;

    private StringProperty spaceD1;
    private StringProperty spaceD2;
    private StringProperty spaceD3;
    private StringProperty spaceD4;
    private StringProperty spaceD5;
    private StringProperty spaceD6;

    Model model;

    public ParkingLotViewModel(Model model){
        this.model = model;

        spaceA1 = new SimpleStringProperty("A1");
        spaceA2 = new SimpleStringProperty("A2");
        spaceA3 = new SimpleStringProperty("A3");
        spaceA4 = new SimpleStringProperty("A4");
        spaceA5 = new SimpleStringProperty("A5");
        spaceA6 = new SimpleStringProperty("A6");
        spaceB1 = new SimpleStringProperty("B1");
        spaceB2 = new SimpleStringProperty("B2");
        spaceB3 = new SimpleStringProperty("B3");
        spaceB4 = new SimpleStringProperty("B4");
        spaceC1 = new SimpleStringProperty("C1");
        spaceC2 = new SimpleStringProperty("C2");
        spaceC3 = new SimpleStringProperty("C3");
        spaceC4 = new SimpleStringProperty("C4");
        spaceD1 = new SimpleStringProperty("D1");
        spaceD2 = new SimpleStringProperty("D2");
        spaceD3 = new SimpleStringProperty("D3");
        spaceD4 = new SimpleStringProperty("D4");
        spaceD5 = new SimpleStringProperty("D5");
        spaceD6 = new SimpleStringProperty("D6");
    }

    public void reset(){

    }

    public boolean isOccupied(String name){

    }
}
