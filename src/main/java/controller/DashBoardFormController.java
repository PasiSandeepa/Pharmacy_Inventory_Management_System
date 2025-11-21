package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {

    @FXML
    private AnchorPane LoadMedicine;

    @FXML
    private Button btnMedicine;

    @FXML
    private Text txtPurchase;

    @FXML
    private Text txtStock;

    @FXML
    private Text txtTotalSale;

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Home_Page.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/ReportForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnMedicinesOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/MedicineForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnPurchaseItemOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Purchase_ItemForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

       LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnPurchaseOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/PurchaseForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Registerform.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnSalesOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/SalesForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnSalesitemsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Sales_ItemsForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/SupplierForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }

    public void btnBillingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/Billing.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        LoadMedicine.getChildren().clear();
        LoadMedicine.getChildren().add(load);
    }
    }
