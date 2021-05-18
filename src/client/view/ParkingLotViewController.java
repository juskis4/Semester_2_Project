package client.view;

import client.viewModel.ParkingLotViewModel;
import client.viewModel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import server.model.domain.ParkingLot;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;

public class ParkingLotViewController {

    @FXML private Label spaceA1;
    @FXML private Label spaceA2;
    @FXML private Label spaceA3;
    @FXML private Label spaceA4;
    @FXML private Label spaceA5;
    @FXML private Label spaceA6;

    @FXML private Label spaceB1;
    @FXML private Label spaceB2;
    @FXML private Label spaceB3;
    @FXML private Label spaceB4;

    @FXML private Label spaceC1;
    @FXML private Label spaceC2;
    @FXML private Label spaceC3;
    @FXML private Label spaceC4;

    @FXML private Label spaceD1;
    @FXML private Label spaceD2;
    @FXML private Label spaceD3;
    @FXML private Label spaceD4;
    @FXML private Label spaceD5;
    @FXML private Label spaceD6;

    private ViewHandler viewHandler;
    private Region root;
    private ParkingLotViewModel viewModel;

    public ParkingLotViewController(){

    }

    public void init(ViewHandler viewHandler, ParkingLotViewModel viewModel, Region root)
    {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        this.root = root;

        if(spaceA1.isOccupied()) {
            spaceA1.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA1.isYourCar()){
            spaceA1.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA1.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceA2.isOccupied()) {
            spaceA2.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA2.isYourCar()){
            spaceA2.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA2.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceA3.isOccupied()) {
            spaceA3.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA3.isYourCar()){
            spaceA3.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA3.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceA4.isOccupied()) {
            spaceA4.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA4.isYourCar()){
            spaceA4.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA4.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceA5.isOccupied()) {
            spaceA5.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA5.isYourCar()){
            spaceA5.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA5.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceA6.isOccupied()) {
            spaceA6.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceA6.isYourCar()){
            spaceA6.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceA6.setTextFill(Color.rgb(0, 255, 0));
        }

        //////////////////////////// B LINE ///////////////////////////

        if(spaceB1.isOccupied()) {
            spaceB1.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceB1.isYourCar()){
            spaceB1.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceB1.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceB2.isOccupied()) {
            spaceB2.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceB2.isYourCar()){
            spaceB2.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceB2.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceB3.isOccupied()) {
            spaceB3.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceB3.isYourCar()){
            spaceB3.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceB3.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceB4.isOccupied()) {
            spaceB4.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceB4.isYourCar()){
            spaceB4.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceB4.setTextFill(Color.rgb(0, 255, 0));
        }

        //////////////////////// C LINE ////////////////////////

        if(spaceC1.isOccupied()) {
            spaceC1.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceC1.isYourCar()){
            spaceC1.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceC1.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceC2.isOccupied()) {
            spaceC2.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceC2.isYourCar()){
            spaceC2.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceC2.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceC3.isOccupied()) {
            spaceC3.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceC3.isYourCar()){
            spaceC3.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceC3.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceC4.isOccupied()) {
            spaceC4.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceC4.isYourCar()){
            spaceC4.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceC4.setTextFill(Color.rgb(0, 255, 0));
        }

        ////////////////////// D LINE ///////////////////////

        if(spaceD1.isOccupied()) {
            spaceD1.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD1.isYourCar()){
            spaceD1.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD1.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceD2.isOccupied()) {
            spaceD2.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD2.isYourCar()){
            spaceD2.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD2.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceD3.isOccupied()) {
            spaceD3.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD3.isYourCar()){
            spaceD3.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD3.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceD4.isOccupied()) {
            spaceD4.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD4.isYourCar()){
            spaceD4.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD4.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceD5.isOccupied()) {
            spaceD5.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD5.isYourCar()){
            spaceD5.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD5.setTextFill(Color.rgb(0, 255, 0));
        }

        if(spaceD6.isOccupied()) {
            spaceD6.setTextFill(Color.rgb(255, 0, 0));
        }
        else if (spaceD6.isYourCar()){
            spaceD6.setTextFill(Color.rgb(0, 0, 255));
        }
        else{
            spaceD6.setTextFill(Color.rgb(0, 255, 0));
        }
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {
        viewModel.reset();
    }

    @FXML private void onLogin()
    {
        if(viewModel.login()){

        }
    }
}
