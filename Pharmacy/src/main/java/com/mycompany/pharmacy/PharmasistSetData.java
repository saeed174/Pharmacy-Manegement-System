package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Person;
import com.mycompany.pharmacy.Classes.PharmacyEmployee;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

public class PharmasistSetData {
    static Person Emp = null;
    Image logo = App.logo;
    String path = App.path;
    public void start(Stage stage){
        GridPane new_grid = new GridPane();
        new_grid.setHgap(10);
        new_grid.setVgap(10);
        new_grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        new_grid.setAlignment(Pos.CENTER);
        // zero row
        Label Pharmacist = new Label("Pharmacist Set Data : ");
        GridPane.setColumnSpan(Pharmacist, 2);
        new_grid.add(Pharmacist, 0, 0);
        Pharmacist.setStyle(
                "-fx-font-size: 24px; -fx-text-fill:rgb(74, 130, 154); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        // first row
        Text Name = new Text("Name ");
        textStyle(Name);
        TextField Namefield = new TextField();
        new_grid.add(Name, 0, 1);
        new_grid.add(Namefield, 1, 1);

        Text Age = new Text("Age ");
        textStyle(Age);
        TextField Agefield = new TextField();
        new_grid.add(Age, 2, 1);
        new_grid.add(Agefield, 3, 1);

        // second row
        Text genderlabel = new Text("gender ");
        textStyle(genderlabel);
        new_grid.add(genderlabel, 0, 2);

        ComboBox<String> gendercomboBox = new ComboBox<>();
        gendercomboBox.setValue("Choose");
        gendercomboBox.getItems().addAll("Male", "Female");
        new_grid.add(gendercomboBox, 1, 2);

        Text email = new Text("Email ");
        textStyle(email);
        new_grid.add(email, 2, 2);

        TextField emailfield = new TextField();
        new_grid.add(emailfield, 3, 2);

        // third row
        Text telephone = new Text("Telephone ");
        textStyle(telephone);
        new_grid.add(telephone, 0, 3);

        TextField telephonefield = new TextField();
        new_grid.add(telephonefield, 1, 3);

        Text insuranceCompany = new Text("Insurance Company ");
        textStyle(insuranceCompany);
        new_grid.add(insuranceCompany, 2, 6);

        TextField insuranceCompanyfield = new TextField();
        new_grid.add(insuranceCompanyfield, 3, 6);
        // fourth row
        Text insuranceNumber = new Text("Insurance Number ");
        textStyle(insuranceNumber);
        new_grid.add(insuranceNumber, 0, 7);

        TextField insuranceNumberfield = new TextField();
        new_grid.add(insuranceNumberfield, 1, 7);

        Text position = new Text("position ");
        textStyle(position);
        new_grid.add(position, 2, 4);

        ComboBox<String> positioncomboBox = new ComboBox<>();
        positioncomboBox.getItems().addAll("Pharmacist", "Pharmacy Employee", "Manager", "Delivery Employee");
        positioncomboBox.setValue("Choose");
        new_grid.add(positioncomboBox, 3, 4);
        // fifth row
        Text workingHours = new Text("Working Hours ");
        textStyle(workingHours);
        new_grid.add(workingHours, 0, 5);

        TextField workingHoursfield = new TextField();
        new_grid.add(workingHoursfield, 1, 5);

        Text workingShift = new Text("Working Shift ");
        textStyle(workingShift);
        new_grid.add(workingShift, 2, 5);

        ComboBox<String> workingShiftcomboBox = new ComboBox<>();
        workingShiftcomboBox.getItems().addAll("Morning", "Night", "Overnight");
        workingShiftcomboBox.setValue("Choose");
        new_grid.add(workingShiftcomboBox, 3, 5);
        // sixth row
        Text employeeId = new Text("Employee ID ");
        textStyle(employeeId);
        new_grid.add(employeeId, 0, 6);

        TextField employeeIdfield = new TextField();
        new_grid.add(employeeIdfield, 1, 6);

        Text salary = new Text("Salary ");
        textStyle(salary);
        new_grid.add(salary, 2, 3);
        TextField salaryfield = new TextField();
        new_grid.add(salaryfield, 3, 3);
        // seventh row
        Text salaryBonus = new Text("Salary Bonus ");
        textStyle(salaryBonus);
        new_grid.add(salaryBonus, 0, 4);
        TextField salaryBonusfield = new TextField();
        new_grid.add(salaryBonusfield, 1, 4);

        Button btn = new Button("Submit");
        btn.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 12px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        Button btn2 = new Button("Reset");
        btn2.setStyle(
                "-fx-background-color:rgb(255, 165, 0);" + // Green background
                        "-fx-text-fill: white;" + // White text
                        "-fx-font-size: 12px;" + // Font size
                        "-fx-font-weight: bold;" + // Bold text
                        "-fx-background-radius: 10;" + // Rounded corners
                        "-fx-padding: 8 15 8 15;" // Padding: top, right, bottom, left
        );
        new_grid.add(btn, 2, 8);
        new_grid.add(btn2, 3, 8);

        Label Message = new Label("");
        Message.setStyle(
                "-fx-font-size: 12px; -fx-text-fill:rgb(254, 0, 0); -fx-font-weight: bold; -fx-font-family: 'Berlin Sans FB Demi'");
        GridPane.setColumnSpan(Message, 2);
        new_grid.add(Message, 0, 8);

        btn.setOnAction(e -> {
            String nameInput = Namefield.getText();
            String ageString = Agefield.getText();
            int age = 0;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid age input: " + ageString);
                Message.setText("Invalid age input: " + ageString);
                scene2Reset(new_grid);
                return;
            }

            String gender = gendercomboBox.getValue();
            String emailInput = emailfield.getText();
            String telephoneInput = telephonefield.getText();
            String insuranceCompanyInput = insuranceCompanyfield.getText();
            String insuranceNumberInput = insuranceNumberfield.getText();
            String positionInput = positioncomboBox.getValue();
            String workingHoursString = workingHoursfield.getText();
            float workingHoursInput = 0.0f;
            try {
                workingHoursInput = Float.parseFloat(workingHoursString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid working hours input: " + workingHoursString);
                Message.setText("Invalid working hours input: " + workingHoursString);
                scene2Reset(new_grid);
                return;
            }
            String workingShiftInput = workingShiftcomboBox.getValue();
            String employeeIdInput = employeeIdfield.getText();
            String salaryString = salaryfield.getText();
            float salaryInput = 0.0f;
            try {
                salaryInput = Float.parseFloat(salaryString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid salary input: " + salaryString);
                Message.setText("Invalid salary input: " + salaryString);
                scene2Reset(new_grid);
                return;
            }
            String salaryBonusString = salaryBonusfield.getText();
            float salaryBonusInput = 0.0f;
            try {
                salaryBonusInput = Float.parseFloat(salaryBonusString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid salary bonus input: " + salaryBonusString);
                Message.setText("Invalid salary bonus input: " + salaryBonusString);
                scene2Reset(new_grid);
                return;
            }

            // Create a new Employee object with the provided data
            Emp = new PharmacyEmployee(nameInput, age, gender, emailInput, telephoneInput, insuranceCompanyInput,
                    insuranceNumberInput, positionInput, workingHoursInput, workingShiftInput, employeeIdInput,
                    salaryInput, salaryBonusInput);
            System.out.println("Data submitted successfully!");
            SetMedicine setscene = new SetMedicine();
            setscene.start(stage , Emp);
        });

        btn2.setOnAction(e -> {
            scene2Reset(new_grid);
            Message.setText("Fields have been reset.");
        });

        new_grid.setStyle("-fx-background-color: transparent;");
        ImageView backgroundView = new ImageView(logo);
        backgroundView.setPreserveRatio(false);
        backgroundView.setFitWidth(stage.getHeight());
        backgroundView.setFitHeight(stage.getHeight());
        backgroundView.setOpacity(0.2);

        // Wrap everything in a StackPane
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView , new_grid);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene2 = new Scene(root, 700, 700);
        new_grid.prefHeightProperty().bind(stage.heightProperty());
        new_grid.prefWidthProperty().bind(stage.widthProperty());
        scene2.setFill(Color.WHITE);
        stage.setScene(scene2);
        stage.setTitle("Pharmest set data");
        stage.getIcons().add(logo);
        // stage.show();
    }

    public static void scene2Reset(GridPane new_grid) {
        for (int i = 0; i < new_grid.getChildren().size(); i++) {
            if (new_grid.getChildren().get(i) instanceof TextField) {
                ((TextField) new_grid.getChildren().get(i)).clear();
            } else if (new_grid.getChildren().get(i) instanceof ComboBox) {
                ((ComboBox<String>) new_grid.getChildren().get(i)).setValue("Choose");
            }
        }
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
