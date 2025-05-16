package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Cosmetic;
import com.mycompany.pharmacy.Classes.Medicine;
import com.mycompany.pharmacy.Classes.Person;
import com.mycompany.pharmacy.Classes.PharmacyEmployee;
import com.mycompany.pharmacy.Classes.Product;
import com.mycompany.pharmacy.Classes.Recipe;
import java.util.ArrayList;
import java.util.Collections;



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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SetMedicine {
    ArrayList<Product> Products = App.Products;
    String path = App.path;
    Image logo = App.logo;

    // =================== Tarekhee ==================
    public void start(Stage stage, Person Emp) {
        // Implementing The Controllers first
        Button btn_add = new Button("Add The Product");
        Button btn_next = new Button("Next");
        Button btn_back = new Button("Back");
        TextField tf_name = new TextField();
        TextField tf_id = new TextField();
        TextField tf_cost = new TextField();
        TextField tf_expireDate = new TextField();
        TextField tf_quantity1 = new TextField();
        TextField tf_quantity2 = new TextField();
        TextField tf_quantity3 = new TextField();
        // if the Product is medicine
        // TextField tf_medicineType = new TextField();
        ComboBox cb_medicineType = new ComboBox();
        cb_medicineType.getItems().addAll("Lebos", "ampoule", "Tablets");
        cb_medicineType.setValue("Choose The Type");
        TextField tf_medicineCompany = new TextField();
        TextField tf_medicineDose = new TextField();
        // if the Product is Recipe
        TextField tf_recipetype = new TextField();
        // if the Product is Cosmetic
        TextField tf_cosmeticType = new TextField();
        TextField tf_brand = new TextField();
        // Texts
        Text lbl_name = new Text("Name: ");
        textStyle(lbl_name);
        Text lbl_id = new Text("ID: ");
        textStyle(lbl_id);
        Text lbl_cost = new Text("Cost: ");
        textStyle(lbl_cost);
        Text lbl_expiryDate = new Text("Expiry Date: ");
        textStyle(lbl_expiryDate);
        Text lbl_quantity1 = new Text("Quantity: ");
        textStyle(lbl_quantity1);
        Text lbl_quantity2 = new Text("Quantity: ");
        textStyle(lbl_quantity2);
        Text lbl_quantity3 = new Text("Quantity: ");
        textStyle(lbl_quantity3);
        Text lbl_productType = new Text("Product Type: ");
        textStyle(lbl_productType);
        // Text lbl_quantity = new Text("Quantity: "); //To be Checked First with
        // Saeed;
        // if the product is Medicine
        Text lbl_medicineType = new Text("Medicine Type: ");
        textStyle(lbl_medicineType);
        Text lbl_medicineCompany = new Text("Medicine Company: ");
        textStyle(lbl_medicineCompany);
        Text lbl_medicineDose = new Text("Medicine Dose: ");
        textStyle(lbl_medicineDose);
        // if the Product is Recipe
        Text lbl_recipeType = new Text("Recipe Type: ");
        textStyle(lbl_recipeType);
        Text lbl_pharmacistName = new Text("Pharmacist Name is: " + Emp.getName());
        // if the Product is Cosmetic
        Text lbl_cosmeticType = new Text("Cosmetic Type: ");
        textStyle(lbl_cosmeticType);
        Text lbl_brand = new Text("Brand: ");
        textStyle(lbl_brand);
        Text Product_Type = new Text("Adding Products: ");
        textStyle(Product_Type);
        Text lbl_numOfProducts = new Text("   Number of Products:  " + Products.size());
        textStyle(lbl_numOfProducts);
        ComboBox<String> cb_productType = new ComboBox<>();
        cb_productType.getItems().addAll("Medicine", "Recipe", "Cosmetic");
        cb_productType.setValue("Choose The Type");
        // Intializaton with All product attributes is disabled (will be chosen Later);
        cb_medicineType.setVisible(false);
        tf_medicineCompany.setVisible(false);
        tf_medicineDose.setVisible(false);
        tf_recipetype.setVisible(false);
        tf_cosmeticType.setVisible(false);
        tf_brand.setVisible(false);
        lbl_medicineType.setVisible(false);
        lbl_medicineCompany.setVisible(false);
        lbl_medicineDose.setVisible(false);
        lbl_recipeType.setVisible(false);
        lbl_pharmacistName.setVisible(false);
        lbl_cosmeticType.setVisible(false);
        lbl_brand.setVisible(false);
        lbl_quantity1.setVisible(false);
        lbl_quantity1.setVisible(false);
        lbl_quantity2.setVisible(false);
        lbl_quantity3.setVisible(false);
        tf_quantity1.setVisible(false);
        tf_quantity2.setVisible(false);
        tf_quantity3.setVisible(false);
        // Orange button styling
        btn_add.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 12px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        btn_next.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 12px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        btn_back.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 12px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        // Setting Button Disable to ensure that user must select type of Product
        btn_add.setDisable(true);// When Event Happen the btn_add will be set to true
        // GridPane for form
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setAlignment(Pos.CENTER);
        // Zero row
        // Pharamcist Name Handling
        GridPane.setColumnSpan(lbl_pharmacistName, 2);
        lbl_pharmacistName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        // Handling Product_Type "it displays adding Products but mistakenly i named it
        // product_Type :)";
        GridPane.setColumnSpan(Product_Type, 2);
        // Number of Products Handeling
        GridPane.setColumnSpan(lbl_numOfProducts, 2);
        // Add elements to GridPane
        grid.add(Product_Type, 0, 0);
        grid.add(lbl_numOfProducts, 2, 0);
        Product_Type.setStyle(
                "-fx-font-size: 24px; -fx-text-fill:rgb(74, 130, 154); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        lbl_numOfProducts.setStyle(
                "-fx-font-size: 24px; -fx-text-fill:rgb(74, 130, 154); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        // First Row
        // adding Name
        grid.add(lbl_name, 0, 1);
        grid.add(tf_name, 1, 1);
        // adding ID
        grid.add(lbl_id, 2, 1);
        grid.add(tf_id, 3, 1);

        // Second Row
        // Adding Checkbox Product
        grid.add(lbl_productType, 0, 2);
        grid.add(cb_productType, 1, 2);
        // Adding Expiry Date
        grid.add(lbl_expiryDate, 2, 2);
        grid.add(tf_expireDate, 3, 2);
        // Thrid Row
        // Adding Cost
        grid.add(lbl_cost, 0, 3);
        grid.add(tf_cost, 1, 3);
        // Adding Medicine Attributes (if Choosen)
        grid.add(lbl_medicineType, 2, 3);
        grid.add(cb_medicineType, 3, 3);
        grid.add(lbl_medicineCompany, 0, 4);
        grid.add(tf_medicineCompany, 1, 4);
        grid.add(lbl_medicineDose, 2, 4);
        grid.add(tf_medicineDose, 3, 4);
        // Adding Recipe Attributes (if Choosen)
        grid.add(lbl_recipeType, 2, 3);
        grid.add(tf_recipetype, 3, 3);
        grid.add(lbl_pharmacistName, 0, 4);
        // Adding Cosmetic Attributes (if Choosen)
        grid.add(lbl_cosmeticType, 2, 3);
        grid.add(tf_cosmeticType, 3, 3);
        grid.add(lbl_brand, 0, 4);
        grid.add(tf_brand, 1, 4);

        grid.add(lbl_quantity1, 0, 5);
        grid.add(tf_quantity1, 1, 5);
        grid.add(lbl_quantity2, 2, 4);
        grid.add(tf_quantity2, 3, 4);
        grid.add(lbl_quantity3, 2, 4);
        grid.add(tf_quantity3, 3, 4);
        // Adding Buttons
        grid.add(btn_add, 2, 8);
        grid.add(btn_next, 3, 8);
        grid.add(btn_back, 0, 8);
        // Adding Message like Saeed
        Text Message = new Text("");
        Message.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(254, 0, 0); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        GridPane.setColumnSpan(Message, 2);
        grid.add(Message, 0, 10);
        ///////////////////////////////////////////
        grid.setStyle("-fx-background-color: transparent;");
        ImageView backgroundView = new ImageView(logo);
        backgroundView.setPreserveRatio(false);
        backgroundView.setFitWidth(stage.getHeight());
        backgroundView.setFitHeight(stage.getHeight());
        backgroundView.setOpacity(0.2);

        // Wrap everything in a StackPane
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, grid); // background is first
        Scene scene3 = new Scene(root, 700, 700);
        grid.prefHeightProperty().bind(stage.heightProperty());
        grid.prefWidthProperty().bind(stage.widthProperty());
        scene3.setFill(Color.WHITE);
        stage.setScene(scene3);
        stage.setTitle("Products Entry Form");
        stage.getIcons().add(logo);

        // Hide Data fields or show based on my Choice
        cb_productType.setOnAction(e -> {
            String selected = cb_productType.getValue();
            boolean isMed = selected.equals("Medicine");
            boolean isRec = selected.equals("Recipe");
            boolean isCos = selected.equals("Cosmetic");
            // if the product is choosen the btn_add will be On
            if (isMed || isRec || isCos)
                btn_add.setDisable(false);

            cb_medicineType.setVisible(isMed);
            tf_medicineCompany.setVisible(isMed);
            tf_medicineDose.setVisible(isMed);
            tf_quantity1.setVisible(isMed);

            tf_recipetype.setVisible(isRec);
            tf_cosmeticType.setVisible(isCos);
            tf_brand.setVisible(isCos);
            tf_quantity2.setVisible(isRec);

            lbl_medicineType.setVisible(isMed);
            lbl_medicineCompany.setVisible(isMed);
            lbl_medicineDose.setVisible(isMed);
            lbl_quantity1.setVisible(isMed);

            lbl_recipeType.setVisible(isRec);
            lbl_pharmacistName.setVisible(isRec);
            lbl_quantity2.setVisible(isRec);

            lbl_cosmeticType.setVisible(isCos);
            lbl_brand.setVisible(isCos);
            lbl_quantity3.setVisible(isCos);
            tf_quantity3.setVisible(isCos);
        });
        // Action on Add Button (The behaviour of combobox is considered)
        btn_add.setOnAction(e1 -> {
            // evert time Event is called the Message will be null
            Message.setText("\0");
            String nameInput = tf_name.getText();
            String quantityString;
            String selected = cb_productType.getValue();
            String Medicine_Type = (String) cb_medicineType.getValue();
            switch (selected) {
                case "Medicine":
                    quantityString = tf_quantity1.getText();
                    break;
                case "Recipe":
                    quantityString = tf_quantity2.getText();
                    break;
                case "Cosmetic":
                    quantityString = tf_quantity3.getText();
                    break;
                default:
                    throw new AssertionError();
            }
            int quantity = 0;
            try {
                quantity = Integer.parseInt(quantityString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid quantity input: " + quantityString);
                Message.setText("Invalid quantity input: " + quantityString);
                tf_quantity1.clear();
                tf_quantity2.clear();
                tf_quantity3.clear();
                return;
            }
            String ID = tf_id.getText();
            String Expiry_date = tf_expireDate.getText();
            double Cost = 0;
            try {
                Cost = Double.parseDouble(tf_cost.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Cost Input: It must be a number");
                Message.setText("Invalid Cost Input: It must be a number");
                tf_cost.clear();
                return;
            }
            switch (selected) {
                case "Medicine": {
                    String Medicine_company = tf_medicineCompany.getText();
                    String Medicine_dose = tf_medicineDose.getText();
                    Products.add(new Medicine(nameInput, Cost, quantity, Expiry_date, ID, Medicine_Type,
                            Medicine_company, Medicine_dose));
                    System.out.println("The Medicine has been Registerd");
                    lbl_numOfProducts.setText("   Number of Products:  " + Products.size());
                    cb_productType.setValue("Choose The Type");
                    btn_add.setDisable(true);
                    scene3Reset(grid);

                }
                    break;
                case "Recipe": {
                    String Recipe_Type = tf_recipetype.getText();
                    Products.add(new Recipe(nameInput, Cost, quantity, Expiry_date, ID, Recipe_Type,
                            ((PharmacyEmployee) Emp)));
                    System.out.println("The Recipe has been Registerd");
                    lbl_numOfProducts.setText("   Number of Products:  " + Products.size());
                    cb_productType.setValue("Choose The Type");
                    btn_add.setDisable(true);
                    scene3Reset(grid);
                }
                    break;
                case "Cosmetic": {
                    String Cosmetic_Type = tf_cosmeticType.getText();
                    String Brand = tf_brand.getText();
                    Products.add(new Cosmetic(nameInput, Cost, quantity, Expiry_date, ID, Cosmetic_Type, Brand));
                    System.out.println("The Cosmetic has been Registerd");
                    lbl_numOfProducts.setText("   Number of Products:  " + Products.size());
                    cb_productType.setValue("Choose The Type");
                    btn_add.setDisable(true);
                    scene3Reset(grid);
                }
                    break;
            }
        });

        Collections.sort(Products);

        btn_next.setOnAction(e2 -> {
            SetSales setSales = new SetSales();
            setSales.Start(stage);
        });

        btn_back.setOnAction(e3 -> {

            PharmasistSetData scene2 = new PharmasistSetData();
            scene2.start(stage);
            System.out.println("Returning Back to Pharmacist Entry Form");
        });

    }

    public static void scene3Reset(GridPane grid1) {
        for (int i = 0; i < grid1.getChildren().size(); i++) {
            if (grid1.getChildren().get(i) instanceof TextField) {
                ((TextField) grid1.getChildren().get(i)).clear();
            }
        }
    }

    public static void textStyle(Text tx) {
        tx.setStyle(
                "-fx-font-size: 16px; -fx-text-fill:rgb(227, 165, 20); -fx-font-weight: bold; -fx-font-family: 'Arial Black '");
        tx.setFill(Color.BLACK); // Text fill color
        tx.setStroke(Color.web("#E3A514")); // Border color
        tx.setStrokeWidth(0.2);
    }
}