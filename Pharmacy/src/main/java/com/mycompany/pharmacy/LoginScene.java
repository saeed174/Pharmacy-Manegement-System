package com.mycompany.pharmacy;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScene {
    String currentPassword = "1234";
    String currentEmail = "admin";
    private static Scene scene;
    Image logo = App.logo;
    String path = App.path;
    void start(Stage stage) {
        System.out.println(path);
        VBox main_layout = new VBox(0);
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        StackPane stackPane = new StackPane();
        stackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane.getChildren().add(imageView);
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.setPrefHeight(imageView.getFitHeight());
        stackPane.setPrefWidth(imageView.getFitWidth());
        main_layout.getChildren().add(stackPane);

        StackPane stackPane2 = new StackPane();
        Text loginLabel = new Text("Login");
        loginLabel.setStyle(
                "-fx-font-size: 24px; -fx-text-fill:rgb(227, 165, 20); -fx-font-weight: bold; -fx-font-family: 'Arial Black'");
        loginLabel.setFill(Color.web("#E3A514")); // Text fill color
        loginLabel.setStroke(Color.BLACK); // Border color
        loginLabel.setStrokeWidth(1);
        stackPane2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane2.getChildren().add(loginLabel);
        stackPane2.setAlignment(Pos.CENTER);
        main_layout.getChildren().add(stackPane2);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Text e_mail = new Text("Email : ");
        e_mail.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(227, 165, 20); -fx-font-weight: bold; -fx-font-family: 'Arial Black'");
        e_mail.setFill(Color.web("#E3A514")); // Text fill color
        e_mail.setStroke(Color.BLACK); // Border color
        e_mail.setStrokeWidth(0.1);
        gridPane.add(e_mail, 0, 0);

        Text pss = new Text("Password : ");
        pss.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(227, 165, 20); -fx-font-weight: bold; -fx-font-family: 'Arial Black'");
        pss.setFill(Color.web("#E3A514")); // Text fill color
        pss.setStroke(Color.BLACK); // Border color
        pss.setStrokeWidth(0.1);
        gridPane.add(pss, 0, 1);

        TextField Email = new TextField();
        gridPane.add(Email, 1, 0);
        TextField password = new TextField();
        gridPane.add(password, 1, 1);
        Button btn = new Button("Submit");
        btn.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 10px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        Button btn2 = new Button("Reset");
        btn2.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 10px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        gridPane.add(btn, 0, 2);
        gridPane.add(btn2, 1, 2);
        StackPane stackPane4 = new StackPane();
        stackPane4.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane4.getChildren().add(gridPane);
        stackPane4.setAlignment(Pos.CENTER);
        main_layout.getChildren().add(stackPane4);
        stackPane4.prefHeightProperty().bind(stage.heightProperty());
        stackPane4.prefWidthProperty().bind(stage.widthProperty());

        btn.setOnAction(e -> {
            String em = Email.getText();
            String pass = password.getText();
            System.out.println("Submitted Email: " + em);
            System.out.println("Submitted Password: " + pass);
            if (em.equals(currentEmail) && pass.equals(currentPassword)) {
                PharmasistSetData scene2 = new PharmasistSetData();
                scene2.start(stage);
            } else {
                failLogin(gridPane);
            }
        });

        main_layout.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    String em = Email.getText();
                    String pass = password.getText();
                    if (em.equals(currentEmail) && pass.equals(currentPassword)) {
                        PharmasistSetData scene2 = new PharmasistSetData();
                        scene2.start(stage);
                    } else {
                        failLogin(gridPane);
                    }
                    break;
                default:
                    break;
            }
        });

        btn2.setOnAction(e -> {
            Email.clear();
            password.clear();
            System.out.println("Fields have been reset.");
        });

        scene = new Scene(main_layout, 400, 400);
        main_layout.prefHeightProperty().bind(stage.heightProperty());
        main_layout.prefWidthProperty().bind(stage.widthProperty());
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Pharmacy App Login");
        stage.getIcons().add(logo);
        // stage.setResizable(false); //Commented Till Saeed Gives the OK
        stage.show();
    }

    public static void failLogin(GridPane gridPane) {
        System.out.println("Login failed!");
        Label label3 = new Label("Login failed!");
        label3.setTextFill(Color.RED);
        label3.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        GridPane.setConstraints(label3, 1, 3);
        gridPane.getChildren().add(label3);
    }
}
