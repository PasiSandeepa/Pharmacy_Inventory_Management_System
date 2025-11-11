package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.Users;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {

    private final UserService userService = new UserServiceImpl();

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private DatePicker dpcreatedat;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtCpassword;

    @FXML
    void btnViewUsersOnAction(ActionEvent event) {
        Stage stage1 = new Stage();
        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/User.fxml"))));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        stage1.show();
    }



    @FXML
    void btnRegisterOnAction(ActionEvent event) throws SQLException {
        String username = txtUserName.getText().trim();
        String email = txtEmail.getText().trim();
        String password = txtpassword.getText().trim();
        String confirmPassword = txtCpassword.getText().trim();
        String role = cmbRole.getValue();

        // 1️⃣ Validation
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || role == null) {
            showAlert("Please fill in all fields!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("The password does not match!");
            return;
        }


        Users existingUser = userService.findByEmail(email); // implement this in UserService
        if (existingUser != null) {
            showAlert("Email already registered!");
            return;
        }


        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role.toUpperCase());
        user.setCreatedAt(LocalDateTime.now());

        // 4️⃣ Save user
        boolean saved = userService.registerUser(user);
        if (saved) {
            showAlert("User registered successfully!");
            clearFields();

        } else {
            showAlert("Failed to register user!");
        }
    }


    private void clearFields() {
        txtUserName.clear();
        txtEmail.clear();
        txtpassword.clear();
        txtCpassword.clear();
        cmbRole.getSelectionModel().clearSelection();
        dpcreatedat.setValue(LocalDate.now());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> roleList = FXCollections.observableArrayList();
        roleList.add("Admin");
        roleList.add("Cashier");
        roleList.add("Manager");
        roleList.add("Pharmacist");

        cmbRole.setItems(roleList);
        dpcreatedat.setValue(LocalDate.now());
    }
}
