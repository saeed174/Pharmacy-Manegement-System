package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Customer;
import com.mycompany.pharmacy.Classes.Delivary;
import com.mycompany.pharmacy.Classes.Order;
import com.mycompany.pharmacy.Classes.Person;
import com.mycompany.pharmacy.Classes.Product;
import java.util.Map;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ByDelivary {
    String path = App.path;
    Image logo = App.logo;
    Person Delivary = App.Delivary;
    Customer customer1 = App.customer1;
    Map<Product, Integer> Sales = App.Sales;
    public void start(Stage stage) {
        BorderPane border =new BorderPane();
        // Create a grid pane to hold the Texts
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setPadding(new Insets(40, 25, 20, 25));
        grid.setAlignment(Pos.CENTER);

        // Create Texts and add them to the grid pane(top_BorderPane)
        Text title1 = new Text("Customer Set Data"); textStyle(title1);
        title1.setFont(Font.font("System", FontWeight.BOLD, 20));
        grid.add(title1, 0, 0);
        Text title2 = new Text("Customer_Name");textStyle(title2);
        TextField name = new TextField();
        grid.add(title2, 0, 1);
        grid.add(name, 1, 1);
        Text title3 = new Text("Customer_ID"); textStyle(title3); 
        TextField id = new TextField();
        grid.add(title3, 2, 1);
        grid.add(id, 3, 1);
        Text title4 = new Text("Customer_Age"); textStyle(title4);
        TextField age = new TextField();
        grid.add(title4, 0, 3);
        grid.add(age, 1, 3);
        Text title5 = new Text("Customer_Gender"); textStyle(title5);
        ComboBox<String> cb_customer_gender = new ComboBox<>();
        cb_customer_gender.getItems().addAll("Male", "Female");
        cb_customer_gender.setValue("Gender");
        grid.add(cb_customer_gender, 3, 3); 
        grid.add(title5, 2, 3);
        Text title6 = new Text("Customer_Email"); textStyle(title6);
        TextField email = new TextField();
        grid.add(title6, 0, 4);
        grid.add(email, 1, 4);
        Text title7 = new Text("Customer_Phone"); textStyle(title7);
        TextField phone = new TextField();
        grid.add(title7, 2, 4);
        grid.add(phone, 3, 4);
        Text title8 = new Text("Customer_Address"); textStyle(title8);
        TextField address = new TextField();
        grid.add(title8, 0, 6);
        grid.add(address, 1, 6);
        Text title9 = new Text("Customer_Insurance_Company"); textStyle(title9);
        TextField insuranceCompany = new TextField();
        grid.add(title9, 0, 5);
        grid.add(insuranceCompany, 1, 5);
        Text title10 = new Text("Customer_Insurance_Number"); textStyle(title10);
        TextField insuranceNumber = new TextField();
        grid.add(title10, 2, 5);
        grid.add(insuranceNumber,3, 5); 
        Text title11 = new Text("Customer_points"); textStyle(title11);
        TextField Points = new TextField();
        grid.add(title11, 2, 6);
        grid.add(Points, 3, 6);     
        // Create buttons and add them to the grid pane(bottom_BorderPane)
        Button button1 = new Button("Save");        
        Button button2 = new Button("Reset");
        Text Message = new Text("");
        Message.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(254, 0, 0); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        GridPane.setColumnSpan(Message, 2);
        grid.add(Message, 0, 8);

        button1.setStyle(
            "-fx-background-color:rgb(255, 165, 0);" + // Green background
                    "-fx-text-fill: white;" + // White text
                    "-fx-font-size: 10px;" + // Font size
                    "-fx-font-weight: bold;" + // Bold text
                    "-fx-background-radius: 10;" + // Rounded corners
                    "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
    );

    button2.setStyle(
        "-fx-background-color:rgb(255, 165, 0);" + // Green background
                "-fx-text-fill: white;" + // White text
                "-fx-font-size: 10px;" + // Font size
                "-fx-font-weight: bold;" + // Bold text
                "-fx-background-radius: 10;" + // Rounded corners
                "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
    );

        grid.add(button1, 2, 7);
        grid.add(button2, 3, 7);
        
        //create an action with button
        button1.setOnAction(eh -> {
        String Name = name.getText();
        String ID = id.getText();
        int Id =0;

        // handle wrong id

        try {
            Id= Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            Message.setText("ID must be a number");
            return;
        }
        
        // handle wrong age

        int Age =0;
        try {
            Age= Integer.parseInt(age.getText());
        } catch (NumberFormatException e) {
            Message.setText("Age must be a number");
            return;
        }

         // handle wrong POINTS

        int points =0;
        try {
            points= Integer.parseInt(Points.getText());
        } catch (NumberFormatException e) {
            Message.setText("Points must be a number");
            return;
        }

        String Gender = cb_customer_gender.getValue();
        String Email = email.getText();
        String Phone = phone.getText();
        String Address = address.getText();
        String InsuranceCompany = insuranceCompany.getText();
        String InsuranceNumber = insuranceNumber.getText();
        customer1 = new Customer(Name, Age, Gender, Email, Phone,ID ,Address, InsuranceCompany, InsuranceNumber);
        customer1.addPoints(points); 
        
        Message.setText("Customer Saved");
        });

        
        
        button2.setOnAction(eh -> {
            name.setText("");
            id.setText("");
            age.setText("");
            cb_customer_gender.setValue("Gender");
            email.setText("");
            phone.setText("");
            address.setText("");
            insuranceCompany.setText("");
            insuranceNumber.setText("");
            Message.setText("");

            
        });
        
        // Add the grid pane to the border pane
        border.setTop(grid);

        //create the the second grid (bottom_BorderPane)
        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10, 25, 15, 25));
        grid2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid2.setAlignment(Pos.CENTER);

        //create second grid pane(delivary)
        Text title12 = new Text("Delivary_Process"); textStyle(title12);
        grid2.add(title12, 0, 0);
        title12.setFont(Font.font("System", FontWeight.BOLD, 20));
        Text title13 = new Text("Delivary_Name"); textStyle(title13);
        TextField Name_Delivary = new TextField();
        grid2.add(title13, 0, 1);
        grid2.add(Name_Delivary, 1, 1);
        Text title14 = new Text("Delivary_ID"); textStyle(title14);
        TextField ID_Delivary = new TextField();
        grid2.add(title14, 2, 1);
        grid2.add(ID_Delivary, 3, 1);
        Text title15 = new Text("Delivary_Age"); textStyle(title15);
        TextField Age_Delivary = new TextField();
        grid2.add(title15, 0, 2);
        grid2.add(Age_Delivary, 1, 2);
        Text title16 = new Text("Delivary_Gender"); textStyle(title16);
        ComboBox<String> cb_delivary_gender = new ComboBox<>();
        cb_delivary_gender.getItems().addAll("Male", "Female");
        cb_delivary_gender.setValue("Gender");
        grid2.add(title16, 2, 2);
        grid2.add(cb_delivary_gender, 3, 2);
        Text title17 = new Text("Delivary_Email"); textStyle(title17);
        TextField Email_DELIVARY = new TextField();
        grid2.add(title17, 0, 3);
        grid2.add(Email_DELIVARY, 1, 3);
        Text title18 = new Text("Delivary_Phone"); textStyle(title18);
        TextField Phone_Delivary = new TextField();
        grid2.add(title18, 2, 3);
        grid2.add(Phone_Delivary, 3, 3);
        Text title20 = new Text("Delivary_working_hours");  textStyle(title20);
        TextField working_hours = new TextField();
        grid2.add(title20, 0, 4);
        grid2.add(working_hours, 1, 4);
        Text title21 = new Text("Delivary_working_shift"); textStyle(title21);
        TextField working_shift= new TextField();
        grid2.add(title21, 2, 4);
        grid2.add(working_shift, 3, 4);
        Text title22=new Text("state_order"); textStyle(title22);
        TextField state_order =new TextField();
        grid2.add(title22, 0, 5);
        grid2.add(state_order, 1, 5);
        Text title23 = new Text("Delivary_DATE"); textStyle(title23);
        TextField DATE = new TextField();
        grid2.add(title23, 2, 5);
        grid2.add(DATE, 3, 5);
        Button button3 = new Button("MAKE AN ORDER");        
        Button button4 = new Button("Reset");
        Text Message2 = new Text("");
        Message2.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(254, 0, 0); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        GridPane.setColumnSpan(Message2, 2);
        grid2.add(Message2, 0, 8);

        button3.setStyle(
            "-fx-background-color:rgb(255, 165, 0);" + // Green background
                    "-fx-text-fill: white;" + // White text
                    "-fx-font-size: 10px;" + // Font size
                    "-fx-font-weight: bold;" + // Bold text
                    "-fx-background-radius: 10;" + // Rounded corners
                    "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
    );

    button4.setStyle(
        "-fx-background-color:rgb(255, 165, 0);" + // Green background
                "-fx-text-fill: white;" + // White text
                "-fx-font-size: 10px;" + // Font size
                "-fx-font-weight: bold;" + // Bold text
                "-fx-background-radius: 10;" + // Rounded corners
                "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
    );

        grid2.add(button3, 2, 6);
        grid2.add(button4, 3, 6);
        border.setCenter(grid2);

        //create action to buttons
        button3.setOnAction(eh -> {
            String name_dev = Name_Delivary.getText();
            String I_D =ID_Delivary.getText();
            
            int AGE=0;
            try {
                AGE=Integer.parseInt(Age_Delivary.getText());
                
            } catch (NumberFormatException e) {
                Message2.setText("Invalid Age_Delivary");
                return;

            }

            String gender_DEV = cb_delivary_gender.getValue();
            String e_mail = Email_DELIVARY.getText();
            String pHone=Phone_Delivary.getText();
            
            float work_hours=0.0f;
            try {
            work_hours=Float.parseFloat(working_hours.getText());
            
            } catch (NumberFormatException e) {
            Message2.setText("Invalid working_hours");
            return;
            }
            String working_shift1 = working_shift.getText();
            String state_order1 = state_order.getText();
            String DATE1 = DATE.getText();
            Order order = new Order(Sales,customer1, "Cash");
            Delivary = new Delivary(name_dev,AGE, gender_DEV , e_mail, pHone, work_hours, working_shift1, I_D ,state_order1, DATE1, order);

            Recipt recipt = new Recipt();
            recipt.start(stage);

        });
        button4.setOnAction(e -> {
            this.start(stage);
        });
        border.setStyle("-fx-background-color: transparent;");
        ImageView backgroundView = new ImageView(logo);
        backgroundView.setPreserveRatio(false);
        backgroundView.setFitWidth(stage.getWidth());
        backgroundView.setFitHeight(stage.getHeight());
        backgroundView.setOpacity(0.2);
        
        
        // Wrap everything in a StackPane
        StackPane root = new StackPane();
        root.getChildren().add(backgroundView);
        root.setPrefWidth(stage.getWidth());
        root.setPrefHeight(stage.getHeight());
        root.getChildren().add(border);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setStyle("-fx-background-color: transparent;");
        grid2.setStyle("-fx-background-color: transparent;");
        border.setStyle("-fx-background-color: transparent;");
        Scene scene2 = new Scene(root, 750, 650);
        border.prefHeightProperty().bind(stage.heightProperty());
        border.prefWidthProperty().bind(stage.widthProperty());
        scene2.setFill(Color.WHITE);
        stage.setScene(scene2);
        stage.setTitle("Delivary stage");
        stage.getIcons().add(logo);
        // stage.show();
        
    }

    public static void textStyle(Text tx)
    {
        tx.setStyle(
                "-fx-font-size: 16px; -fx-text-fill:rgb(227, 165, 20); -fx-font-weight: bold; -fx-font-family: 'Arial Black '");
        tx.setFill(Color.BLACK); // Text fill color
        tx.setStroke(Color.web("#E3A514")); // Border color
        tx.setStrokeWidth(0.2);
    }
}
