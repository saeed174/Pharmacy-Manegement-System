package com.mycompany.pharmacy;

import com.mycompany.pharmacy.Classes.Customer;
import com.mycompany.pharmacy.Classes.Person;
import com.mycompany.pharmacy.Classes.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    static Person Emp ;
    static Customer customer1;
    static Person Delivary ;
    public static ArrayList<Product> Products = new ArrayList();
    static Map<Product, Integer> Sales = new HashMap<>();
    static String path = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    static Image logo;
    static {
        logo = new Image(App.class.getResourceAsStream("/Images/Logo.png"));
    }
    public static  Customer[] Customers = new Customer[100];

    @Override
    public void start(Stage stage) throws IOException {
        LoginScene loginScene = new LoginScene();
        loginScene.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}