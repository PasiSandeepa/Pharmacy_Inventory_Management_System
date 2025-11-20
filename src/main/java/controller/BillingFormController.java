package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.dto.Medicine;
import service.MedicineService;
import service.UserService;
import service.impl.MedicineServiceImpl;
import service.impl.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class BillingFormController implements Initializable {

    MedicineService medicineService = new MedicineServiceImpl();

    @FXML
    private ComboBox<String> cmbCashier;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colMedicineName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblFinalTotal;

    @FXML
    private Label lblSubtotal;

    @FXML
    private TableView<?> tblBilling;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtMedicineName;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;



    @FXML
    void btnAddToCart(ActionEvent event) {

    }

    @FXML
    void btnExportPDFOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {

    }

    public void MedicineOnKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
        String text = txtMedicineName.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        Medicine medicine = medicineService.searchByName(text);
        if (medicine != null) {
            txtUnitPrice.setText(String.valueOf(medicine.getUnit_price()));
        } else {
            txtUnitPrice.clear();
        }
    }

    private void showAlert(Alert.AlertType warning, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Cmblist = FXCollections.observableArrayList();
        Cmblist.add("Cashier A");
        Cmblist.add("Cashier B");
        Cmblist.add("Cashier C");
        Cmblist.add("Cashier D");
        Cmblist.add("Cashier E");
        cmbCashier.setItems(Cmblist);

    }
}

