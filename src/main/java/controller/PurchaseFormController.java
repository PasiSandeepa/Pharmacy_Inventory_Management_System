package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PurchaseFormController {

    @FXML
    private TableColumn<?, ?> colCreatedat;

    @FXML
    private TableColumn<?, ?> colInvoiceno;

    @FXML
    private TableColumn<?, ?> colPurchasedate;

    @FXML
    private TableColumn<?, ?> colSupplierid;

    @FXML
    private TableColumn<?, ?> colTotalamount;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableView<?> tblPurchase;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnAddPurchaseOnAction(ActionEvent event) {
        Stage stage1 = new Stage();
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddPurchaseForm.fxml"))));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();
    }
    }

