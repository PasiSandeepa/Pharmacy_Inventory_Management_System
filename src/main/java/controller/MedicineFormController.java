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

public class MedicineFormController {

    @FXML
    private TableColumn<?, ?> colbatchno;

    @FXML
    private TableColumn<?, ?> colbrand;

    @FXML
    private TableColumn<?, ?> colcreatedat;

    @FXML
    private TableColumn<?, ?> colexpireate;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colrecorderlevel;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableColumn<?, ?> colupdatedat;

    @FXML
    private TableView<?> tblmedicine;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnAddMedicineOnAction(ActionEvent event) {
        Stage stage1 = new Stage();
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddEditMedicineForm.fxml"))));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();
    }
}
