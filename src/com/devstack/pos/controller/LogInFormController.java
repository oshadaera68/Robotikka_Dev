package com.devstack.pos.controller;

import com.devstack.pos.util.PasswordManager;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LogInFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void btnSignInOnAction(ActionEvent actionEvent) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/robotikka", "root", "1234");
            String sql = "SELECT * FROM user WHERE email=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, txtEmail.getText());
            ResultSet rst = pstm.executeQuery();

            if (rst.next()) {
                if (PasswordManager.checkPassword(txtPassword.getText(), rst.getString(2))) {
                    System.out.println("Completed");
                } else {
                    new Alert(Alert.AlertType.ERROR, "User email or password not found.").show();
                }

            } else {
                new Alert(Alert.AlertType.ERROR, "User email is not found.").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void btnCreateAnAccOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    private void setUi(String url) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
