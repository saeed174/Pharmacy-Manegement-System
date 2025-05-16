package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Product;
import java.util.ArrayList;
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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SetSales {
    Image logo = App.logo;
    ArrayList<Product> Products = App.Products;
    Map<Product, Integer> Sales = App.Sales;
    public void Start(Stage stage) {
        StackPane stackpane = new StackPane();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        stackpane.setAlignment(Pos.CENTER);
        stackpane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        // +++++++++++++back ground++++++++++++++++
        grid.setStyle("-fx-background-color: transparent;");
        ImageView backgroundView = new ImageView(logo);
        backgroundView.setPreserveRatio(false);
        backgroundView.setFitWidth(stage.getHeight());
        backgroundView.setFitHeight(stage.getHeight());
        backgroundView.setOpacity(0.3);
        stackpane.getChildren().add(backgroundView);
        backgroundView.setStyle("-fx-background-color: transparent;");
        // =============for user input==================
        Text Txt = new Text("Name of medicine :"); textStyle(Txt);
        Txt.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 5px;");
        grid.add(Txt, 0, 0);
        grid.setColumnSpan(Txt, 2);
        Txt.setStyle(
                "-fx-font-size: 15px; -fx-text-fill:rgb(255,165,0); -fx-font-weight: bold; -fx-font-family: 'Arial Black'");
        ComboBox<String> name = new ComboBox<>();
        name.setPromptText("Select Product");
        for (int i = 0; i < Products.size(); i++) {
            name.getItems().add(Products.get(i).getName());
        }
        name.setPrefWidth(200);
        grid.add(name, 2, 0);
        grid.setColumnSpan(name, 2);
        Text Text2 = new Text("Quantity :"); textStyle(Text2);
        Text2.setStyle("-fx-border-color: black; -fx-border-width: 10px; -fx-padding: 10px;");
        grid.add(Text2, 0, 1);
        TextField quantity = new TextField();
        quantity.setPromptText("Enter Quantity");
        Text2.setStyle(
                "-fx-font-size: 15px; -fx-text-fill:rgb(255,165,0); -fx-font-weight: bold; -fx-font-family: 'Arial Black'");
        grid.add(quantity, 2, 1);
        grid.setColumnSpan(quantity, 2);
        stackpane.getChildren().add(grid);
        // +===============style of button===================+
        Button button1 = new Button("Add");
        button1.setStyle("-fx-background-color:rgb(255, 165, 0);" + // Green background
                "-fx-text-fill: white;" + // White text
                "-fx-font-size: 10px;" + // Font size
                "-fx-font-weight: bold;" + // Bold text
                "-fx-background-radius: 10;" + // Rounded corners
                "-fx-padding: 8 15 8 15;");
        Button button2 = new Button("Receipt");
        button2.setStyle("-fx-background-color:rgb(255, 165, 0);" + // Green background
                "-fx-text-fill: white;" + // White text
                "-fx-font-size: 10px;" + // Font size
                "-fx-font-weight: bold;" + // Bold text
                "-fx-background-radius: 10;" + // Rounded corners
                "-fx-padding: 8 15 8 15;");
        Button button3 = new Button("Delivery");
        button3.setStyle("-fx-background-color:rgb(255, 165, 0);" + // Green background
                "-fx-text-fill: white;" + // White text
                "-fx-font-size: 10px;" + // Font size
                "-fx-font-weight: bold;" + // Bold text
                "-fx-background-radius: 10;" + // Rounded corners
                "-fx-padding: 8 15 8 15;");

        Text Message = new Text("");
        Message.setStyle(
                "-fx-font-size: 15px; -fx-text-fill:rgb(254, 0, 0); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        grid.add(button1, 0, 3);
        grid.add(button2, 2, 3);
        grid.add(button3, 4, 3);
        grid.add(Message, 1, 2);
        grid.setColumnSpan(Message, 2);
        // ===========================event===================================
        button1.setOnAction(e -> {
            int quant = 0;
            try
            {
                quant = Integer.parseInt(quantity.getText());
                for (int i = 0; i < Products.size(); i++) {
                if (Products.get(i).getName().equals(name.getValue())) {
                    System.out.println(quant);
                    System.out.println(Products.get(i).getQuantity());
                    if (Products.get(i).getQuantity() >= quant) {
                        int currentSales = Sales.getOrDefault(Products.get(i), 0);
                        Sales.put(Products.get(i), currentSales + quant);
                        Products.get(i).setQuantity(Products.get(i).getQuantity() - quant);
                        Message.setText("Product Added");
                        return;
                    } else {
                        Message.setText("The quantity you need does not exist");
                        return;
                    }
                }
            }
            } catch (NumberFormatException ex) {
                Message.setText("Invalid quantity entered. Please enter a valid number.");
            }
        });
        button2.setOnAction(e -> {
            Recipt recipt = new Recipt();
            recipt.start(stage);
        });
        button3.setOnAction(e -> {
            ByDelivary scene6 = new ByDelivary();
            scene6.start(stage);
        });

        Scene scene = new Scene(stackpane, 600, 600);
        stackpane.prefHeightProperty().bind(stage.heightProperty());
        stackpane.prefWidthProperty().bind(stage.widthProperty());
        stage.setScene(scene);
        stage.setTitle("scene4");
        stage.getIcons().add(logo);
        stage.show();

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
