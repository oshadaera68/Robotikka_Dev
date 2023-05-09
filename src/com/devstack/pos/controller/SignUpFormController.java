package com.devstack.pos.controller;

import com.devstack.pos.dao.DatabaseAccessCode;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        try {
            if (DatabaseAccessCode.createUser(txtEmail.getText(), txtPassword.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Not Saved").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void clearFields() {
        txtEmail.clear();
        txtPassword.clear();
    }

    public void btnAlreadyOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LogInForm");
    }

    private void setUi(String url) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
