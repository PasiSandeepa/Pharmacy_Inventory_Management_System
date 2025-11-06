package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    @FXML
    private AreaChart<?, ?> AreaChart;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColMount;

    @FXML
    private TableColumn<?, ?> ColTransAction;

    @FXML
    private TableColumn<?, ?> ColType;

    @FXML
    private LineChart<?, ?> LineChart;

    @FXML
    private TableView<?> tblRecentActivity;

    @FXML
    private Text txtPurchase;

    @FXML
    private Text txtStock;

    @FXML
    private Text txtTotalSale;

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {

    }

    @FXML
    void btnMedicinesOnAction(ActionEvent event) {

    }

    @FXML
    void btnPurchaseOnAction(ActionEvent event) {

    }

    @FXML
    void btnPurchasetemsOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        Stage stage1 = new Stage();
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();
    }

    @FXML
    void btnSalesOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalesitemsOnAction(ActionEvent event) {

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) {

    }


}
