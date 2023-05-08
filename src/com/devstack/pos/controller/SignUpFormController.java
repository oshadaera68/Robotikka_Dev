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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/robotikka", "root", "1234");
            String sql = "INSERT INTO user VALUES(?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, txtEmail.getText());
            pstm.setString(2, PasswordManager.encryptPassword(txtPassword.getText()));
            if (pstm.executeUpdate()>0) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Not Saved").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
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
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
