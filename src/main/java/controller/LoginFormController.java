package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginFormController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnSigninOnActon(ActionEvent event) {

    }

    @FXML
    void hyperRegisterOnAction(ActionEvent event) {

    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public TextField getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(TextField txtUserName) {
        this.txtUserName = txtUserName;
    }
}
