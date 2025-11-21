package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.dto.Suppliers;
import service.SupplierService;
import service.impl.SupplierServiceImpl;

public class AddSupplierFormController {

    private final SupplierService supplierService = new SupplierServiceImpl();

    @FXML
    private DatePicker dpcreatedat;

    @FXML
    private TextField txtPhoneno;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtid.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please enter supplier ID to delete");
            return;
        }
        boolean isDeleted = supplierService.deleteSupplier(txtid.getText().trim());
        if (isDeleted) {
            showAlert(Alert.AlertType.INFORMATION, "Supplier deleted successfully");
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to delete supplier");

        }
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {
        if(txtname.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please enter supplier name to edit");
            return;
        }
        Suppliers suppliers = new Suppliers();
        suppliers.setId(txtid.getText().trim());
        suppliers.setName(txtname.getText().trim());
        suppliers.setPhone(txtPhoneno.getText().trim());
        suppliers.setEmail(txtemail.getText().trim());
        suppliers.setAddress(txtaddress.getText().trim());
        suppliers.setCreatedAt(dpcreatedat.getValue());
        boolean isUpdated = supplierService.updateSupplier(suppliers);
        if (isUpdated) {
            showAlert(Alert.AlertType.INFORMATION, "Supplier updated successfully");
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to update supplier");
        }




    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtname.getText().isEmpty() || txtemail.getText().isEmpty() || txtPhoneno.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please fill all required fields");
            return;
        }
        Suppliers suppliers = new Suppliers();
        suppliers.setId(txtid.getText().trim());
        suppliers.setName(txtname.getText().trim());
        suppliers.setPhone(txtPhoneno.getText().trim());
        suppliers.setEmail(txtemail.getText().trim());
        suppliers.setAddress(txtaddress.getText().trim());
        suppliers.setCreatedAt(dpcreatedat.getValue());

        boolean isAddeded = supplierService.addSupplier(suppliers);
        if (isAddeded) {
            showAlert(Alert.AlertType.INFORMATION, "Supplier added successfully");
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to add supplier");
        }
    }

    private void showAlert(Alert.AlertType warning, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void clearFields() {
        txtid.clear();
        txtname.clear();
        txtPhoneno.clear();
        txtemail.clear();
        txtaddress.clear();
        dpcreatedat.setValue(null);
    }

    public void OnKeyReleased(KeyEvent keyEvent) {
        String name = txtname.getText();

        Suppliers suppliers = supplierService.findByName(name);
        if (suppliers != null) {
            txtid.setText(suppliers.getId());
            txtPhoneno.setText(suppliers.getPhone());
            txtemail.setText(suppliers.getEmail());
            txtaddress.setText(suppliers.getAddress());
            dpcreatedat.setValue(suppliers.getCreatedAt());
        } else {

        }

    }
}


