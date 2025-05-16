package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Product;
import java.util.HashMap;
import java.util.Map;



import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Recipt{
    String path = App.path;
    Image logo = App.logo;
    Map<String, Integer> frequencyMap = new HashMap<>();
    Map<String, Product> productMap = new HashMap<>();
    Map<Product, Integer> Sales = App.Sales;
    double totalPrice = 0.0;
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(30));

        ImageView backgroundView = new ImageView(logo);
        backgroundView.setPreserveRatio(false);
        backgroundView.fitWidthProperty().bind(stage.widthProperty());
        backgroundView.fitHeightProperty().bind(stage.heightProperty());
        backgroundView.setOpacity(0.2);
        root.getChildren().add(0, backgroundView);

        // Top HBox for the label in top-left
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(0, 0, 0, 20));
        topBox.setAlignment(Pos.TOP_LEFT);

        Label rec = new Label("Receipt :");
        rec.setStyle("-fx-text-fill: orange;");
        rec.setFont(Font.font("System", FontWeight.BOLD, 26));
        topBox.getChildren().add(rec);

        // Center content with StackPane for the Rectangle and receipt
        StackPane centerPane = new StackPane();
        centerPane.setAlignment(Pos.CENTER);

        int width = 400;
        double height = 320;
        Rectangle boarder = new Rectangle();
        boarder.setWidth(width);
        boarder.setHeight(height);
        boarder.setStroke(Color.BLACK);
        boarder.setFill(Color.WHITE);
        centerPane.getChildren().add(boarder);

        VBox receipt = new VBox();
        receipt.setPadding(new Insets(0));
        receipt.setAlignment(Pos.TOP_CENTER);
        receipt.setMaxHeight(height);
        receipt.setMaxWidth(width);

        Label design = new Label("*".repeat(43));
        design.setFont(Font.font("System", FontWeight.BOLD, 20));
        Label title = new Label("Receipt");
        title.setFont(Font.font("System", FontWeight.BOLD, 25));
        title.setAlignment(Pos.CENTER);
        HBox titleBox = new HBox(title);
        titleBox.setPadding(new Insets(0, 0, 25, 0));
        titleBox.setAlignment(Pos.CENTER);

        Label design2 = new Label("*".repeat(43));
        design2.setFont(Font.font("System", FontWeight.BOLD, 20));
        Label title2 = new Label("RIMBERIO Pharmacy");
        title2.setFont(Font.font("System", FontWeight.BOLD, 18));
        Label design3 = new Label("-".repeat(49));
        design3.setFont(Font.font("System", FontWeight.LIGHT, 20));
        Label title3 = new Label("Product");
        title3.setFont(Font.font("System", FontWeight.LIGHT, 17));
        title3.setPadding(new Insets(0, 0, 0, 10));
        Label title4 = new Label("Quantity");
        title4.setFont(Font.font("System", FontWeight.LIGHT, 17));
        Label title5 = new Label("Price");
        title5.setFont(Font.font("System", FontWeight.LIGHT, 17));
        title5.setPadding(new Insets(0, 10, 0, 0));

        VBox topPattern = new VBox(titleBox, design2, title2, design3);
        topPattern.setAlignment(Pos.TOP_CENTER);
        receipt.getChildren().add(topPattern);

        // Product list
        VBox productList = new VBox();
        productList.setAlignment(Pos.TOP_CENTER);
        productList.setSpacing(10);

        GridPane product = new GridPane();
        product.setHgap(10);
        product.setVgap(10);

        // Define column constraints for better alignment
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHalignment(HPos.LEFT);
        col0.setPrefWidth(100);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.CENTER);
        col2.setPrefWidth(80);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPrefWidth(20);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPrefWidth(20);
        ColumnConstraints col6 = new ColumnConstraints();
        col6.setHalignment(HPos.RIGHT);
        col6.setPrefWidth(80);
        product.getColumnConstraints().addAll(col0, col1, col2, col3, col4, col5, col6);
        product.add(title3, 0, 0);
        product.add(title4, 2, 0);
        product.add(title5, 6, 0);


        int Row = 1;
        for (Map.Entry<Product, Integer> entry : Sales.entrySet()) {
            String productName = entry.getKey().getName();
            int quantity = entry.getValue();
            Product item = entry.getKey();
            Label nameLabel = new Label(productName);
            nameLabel.setFont(Font.font("System", FontWeight.LIGHT, 15));
            nameLabel.setPadding(new Insets(0, 0, 0, 10));
            Label quantityLabel = new Label(String.valueOf(quantity));
            quantityLabel.setFont(Font.font("System", FontWeight.LIGHT, 15));
            Label priceLabel = new Label(String.format("%.2f", item.getCost() * quantity));
            priceLabel.setFont(Font.font("System", FontWeight.LIGHT, 15));
            priceLabel.setPadding(new Insets(0, 10, 0, 0));

            product.add(nameLabel, 0, Row);
            product.add(quantityLabel, 2, Row);
            product.add(priceLabel, 6, Row);

            GridPane.setHalignment(nameLabel, HPos.LEFT);
            GridPane.setHalignment(quantityLabel, HPos.CENTER);
            GridPane.setHalignment(priceLabel, HPos.RIGHT);
            totalPrice += item.getCost() * quantity;
            Row++;

            int totalRows = Row;
            double RowHeight = 5;
            height += (totalRows * RowHeight) + ((totalRows - 1) * product.getVgap());
            boarder.setHeight(height);
        }

        Line dashedLine = new Line();
        dashedLine.setStartX(0);
        dashedLine.setEndX(width);
        dashedLine.setStartY(0);
        dashedLine.setEndY(0);
        dashedLine.setStroke(Color.BLACK);
        dashedLine.getStrokeDashArray().addAll(Double.valueOf(5), Double.valueOf(5));
        product.add(dashedLine, 0, ++Row, 7, 1);

        Label title6 = new Label("TOTAL");
        title6.setFont(Font.font("System", FontWeight.BOLD, 17));
        title6.setPadding(new Insets(0, 0, 0, 10));
        product.add(title6, 0, ++Row);

        Label title7 = new Label(String.valueOf(String.format("%.2f", totalPrice)));
        title7.setFont(Font.font("System", FontWeight.BOLD, 17));
        title7.setPadding(new Insets(0, 10, 0, 0));
        product.add(title7, 6, Row);

        Line dashedLine2 = new Line();
        dashedLine2.setStartX(0);
        dashedLine2.setEndX(width);
        dashedLine2.setStartY(0);
        dashedLine2.setEndY(0);
        dashedLine2.setStroke(Color.BLACK);
        dashedLine2.getStrokeDashArray().addAll(5d, 5d);
        product.add(dashedLine2, 0, ++Row, 7, 1);

        Label title8 = new Label("THANK YOU");
        title8.setFont(Font.font("System", FontWeight.BOLD, 20));
        product.add(title8, 0, ++Row, 7, 1);
        GridPane.setHalignment(title8, HPos.CENTER);
        GridPane.setValignment(title8, VPos.CENTER);

        Label starLine = new Label("*".repeat(44));
        starLine.setFont(Font.font("System", FontWeight.BOLD, 20));
        // product.add(starLine, 0, Row += 2, 7, 1);

        productList.getChildren().add(product);
        receipt.getChildren().add(productList);
        centerPane.getChildren().add(receipt);

        // Buttons under the Rectangle
        GridPane bottom = new GridPane();
        bottom.setHgap(40);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(0, 25, 0, 0));
        bottom.setAlignment(Pos.CENTER);

        Button button1 = new Button("Print");
        button1.setStyle("-fx-background-color: rgb(255, 165, 0);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" + // Increased font size
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 15;" + // Adjusted for larger size
                "-fx-padding: 12 25 12 25;"); // Increased padding
        button1.setPrefWidth(100); // Increased width
        button1.setPrefHeight(40); // Increased height

        Button button2 = new Button("Home");
        button2.setStyle("-fx-background-color: rgb(255, 165, 0);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" + // Increased font size
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 15;" + // Adjusted for larger size
                "-fx-padding: 12 25 12 25;"); // Increased padding
        button2.setPrefWidth(100); // Increased width
        button2.setPrefHeight(40); // Increased height
        bottom.add(button1, 0, 0);
        bottom.add(button2, 1, 0);

        button1.setOnMouseClicked(e -> {
            System.out.println("***************************************");
            System.out.println("              Receipt                   ");
            System.out.println("***************************************");
            System.out.println("         RIMBERIO Pharmacy            ");
            System.out.println("---------------------------------------");
            System.out.println(" Product     Quantity         Price   ");
            for (Map.Entry<Product, Integer> entry : Sales.entrySet()) {
                String productName = entry.getKey().getName();
                int quantity = entry.getValue();
                Product item = entry.getKey();
                System.out.println(
                        " " + productName + "          " + quantity + "             " + item.getCost() + "   ");

            }
            System.out.println("---------------------------------------");
            System.out.println(" " + "TOTAL" + "       " + "             " + "     " + totalPrice + "   ");
            System.out.println("---------------------------------------");
            System.out.println("              THANK YOU                   ");

        });

        button2.setOnMouseClicked(e -> {
            PharmasistSetData scene2 = new PharmasistSetData();
            scene2.start(stage);
        });

        // Wrap centerPane and buttons in a VBox to stack them vertically
        VBox centerWithButtons = new VBox(10); // 10 is the spacing between the Rectangle and buttons
        centerWithButtons.setAlignment(Pos.CENTER);
        centerWithButtons.getChildren().addAll(centerPane, bottom);

        // Set positions in BorderPane
        root.setTop(topBox);
        root.setCenter(centerWithButtons);

        receipt.setMaxHeight(Region.USE_PREF_SIZE);
        root.prefHeightProperty().bind(stage.heightProperty());
        root.prefWidthProperty().bind(stage.widthProperty());

        Scene scene = new Scene(root, 700, 750);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(650);
        stage.getIcons().add(logo);
        stage.show();
    }
}
