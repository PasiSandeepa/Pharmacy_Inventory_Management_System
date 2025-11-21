package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.dto.CartItem;
import model.dto.Medicine;
import service.BillingService;
import service.impl.BillingServiceImpl;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BillingFormController implements Initializable {

    BillingService billingService = new BillingServiceImpl();

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
    private TableColumn<?, ?> colCashier;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblFinalTotal;


    @FXML
    private TextField txtSaleid;

    @FXML
    private TableView<CartItem> tblBilling;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtMedicineName;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;


    @FXML
    private Label lblSubTotal;


    @FXML
    void MedicineOnKeyReleased(KeyEvent event) {
        String name = txtMedicineName.getText() == null ? "" : txtMedicineName.getText().trim();
        if (name.isEmpty()) {

            return;
        }
        Medicine medicine = billingService.searchByName(name);
        if (medicine != null) {
            txtUnitPrice.setText(String.valueOf(medicine.getUnit_price()));
        } else {
            txtUnitPrice.clear();
        }
    }

    @FXML
    void btnAddToCart(ActionEvent event) {

        if (txtCustomerName.getText().isEmpty()) {
            show(Alert.AlertType.ERROR, "Error", "Customer Name is required");
            return;
        }

        ObservableList<CartItem> cartItems = tblBilling.getItems();

        String medName = txtMedicineName.getText();
        String customerName = txtCustomerName.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double total = calculateTotal(qty, unitPrice);


        for (CartItem item : cartItems) {
            if (item.getMedicineName().equalsIgnoreCase(medName) &&
                    item.getCustomerName().equalsIgnoreCase(customerName)) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Duplicate Item");
                alert.setHeaderText("This medicine is already in the cart for this customer!");
                alert.setContentText("Do you want to update the quantity?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == ButtonType.OK) {

                    int newQty = item.getQuantity() + qty;
                    item.setQuantity(newQty);

                    item.setTotal(newQty * item.getUnitPrice());

                    tblBilling.refresh();
                    calculateFinalyTotal();
                    clearFields();
                    return;

                } else {
                    return;
                }
            }
        }
        CartItem newItem = new CartItem(
                txtCustomerName.getText(),
                medName,
                unitPrice,
                qty,
                total,
                cmbCashier.getValue()
        );

        cartItems.add(newItem);

        tblBilling.setItems(cartItems);
        calculateFinalyTotal();
        clearFields();
    }


    private double calculateTotal(int qty, double unitPrice) {
        return qty * unitPrice;
    }


    @FXML
    void btnExportPDFOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> CmbList = FXCollections.observableArrayList();
        CmbList.addAll("Cashier A", "Cashier B", "Cashier C", "Cashier D", "Cashier E");
        cmbCashier.setItems(CmbList);

        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colMedicineName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colCashier.setCellValueFactory(new PropertyValueFactory<>("cashier"));
    }

    public void clearFields() {
        txtCustomerName.clear();
        txtMedicineName.clear();
        txtQty.clear();
        txtUnitPrice.clear();
        cmbCashier.getSelectionModel().clearSelection();
    }

    public void show(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void calculateFinalyTotal() {
        ObservableList<CartItem> cartItems = tblBilling.getItems();
        double subtotal = 0.0;
        for (CartItem item : cartItems) {
            subtotal += item.getTotal();
        }
       lblSubTotal.setText(String.format("%.2f", subtotal));

        double discount = subtotal * 0.1;
        lblDiscount.setText(String.format("%.2f", discount));

        double finalTotal = subtotal - discount;
        lblFinalTotal.setText(String.format("%.2f", finalTotal));
    }
}
