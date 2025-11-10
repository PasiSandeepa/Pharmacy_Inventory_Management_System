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

public class SalesItemFormController {

    @FXML
    private TableColumn<?, ?> colCreatedAt;

    @FXML
    private TableColumn<?, ?> colMedicineid;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSalesid;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableView<?> tblSalesItems;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnAddSalesItemOnAction(ActionEvent event) {
        Stage stage1 = new Stage();
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddSalesItemForm.fxml"))));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();

    }

}
