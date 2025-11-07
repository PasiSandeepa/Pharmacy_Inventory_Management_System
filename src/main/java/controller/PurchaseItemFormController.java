package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PurchaseItemFormController {

    @FXML
    private TableColumn<?, ?> colbatchno;

    @FXML
    private TableColumn<?, ?> colcreatedat;

    @FXML
    private TableColumn<?, ?> colexpirydate;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colmedicineid;

    @FXML
    private TableColumn<?, ?> colpurchaseid;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableView<?> tblPurchaseItem;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnAddPurchaseItemOnAction(ActionEvent event) {

    }

}
