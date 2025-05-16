/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pharmacy;

import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class SetSalesTest {
    
    @Test
    public void testValidQuantity() {
        int result = InputValidator.parseQuantity("5");
        assertEquals(5, result);
    }

    @Test
    public void testInvalidQuantity() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            InputValidator.parseQuantity("5");
        });

        assertEquals("Invalid quantity entered. Please enter a valid number.", exception.getMessage());
        System.out.println(exception.getMessage());
    }
    
}
