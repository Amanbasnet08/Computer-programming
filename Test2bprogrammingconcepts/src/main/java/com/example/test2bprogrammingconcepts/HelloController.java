package com.example.test2bprogrammingconcepts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<User> usertable;
    public TableColumn<User,Integer> userID;
    public TableColumn <User,String> ProductName;
    public TableColumn <User,String> ProductPrice;
    public TableColumn <User,String> OrderDate;
    public TextField id;
    public TextField name;
    public TextField price;
    public TextField date;
    @FXML
    private Label welcomeText;

    ObservableList<User> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fethdata();
    }

    private void fethdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM usertable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("OrderID");
                String name = resultSet.getString("ProductName");
                String email = resultSet.getString("ProductPrice");
                String zipcode = resultSet.getString("OrderDate");
                usertable.getItems().add(new User(OrderID, ProductName, ProductPrice, OrderDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<User,Integer>("OrderID"));
        name.setCellValueFactory(new PropertyValueFactory<User,String>("ProductName"));
        price.setCellValueFactory(new PropertyValueFactory<User,String>("ProductPrice"));
        date.setCellValueFactory(new PropertyValueFactory<User,String>("OrderDate"));
        usertable.setItems(list);


    }

    public void InsertData(ActionEvent actionEvent) {



        String name = name.getText();
        String email = price.getText();
        String zipcode = date.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `usertable`( `name`, `price`, `date) VALUES ('"+name+"','"+price+"','"+date+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String Orderid = id.getText();
        String Productname = name.getText();
        String ProdcutPrice = price.getText();
        String OrderDate = date.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `usertable` SET `name`='"+name+"',`email`='"+email+"',`zipcode`='"+zipcode+"' WHERE id='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String OrderID = id.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `usertable` WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String id = sid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM usertable WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String email = resultSet.getString("price");
                String zipcode = resultSet.getString("date");

                name.setText(ProductName);
                price.setText(ProductPrice);
                date.setText(OrderDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}