package com.devstack.pos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CustomerFormController {

    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colEmail;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colSalary;
    public TableColumn colOperate;
    public JFXTextField txtSearch;

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnManageLoyaltyCardsOnAction(ActionEvent actionEvent) {
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
