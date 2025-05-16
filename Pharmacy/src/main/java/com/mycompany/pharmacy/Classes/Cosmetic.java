package com.mycompany.pharmacy.Classes;

public class Cosmetic extends Product {

    private String cosmeticType;
    private String brand;

    public Cosmetic() {
        super();
    }

    public Cosmetic(String name, double cost, int quantity, String expireDate, String Id, String cosmeticType,
            String brand) {
        super(name, cost, quantity, expireDate, Id);
        this.cosmeticType = cosmeticType;
        this.brand = brand;
    }

    String getCosmeticType() {
        return cosmeticType;
    }

    String getBrand() {
        return brand;
    }

    @Override
    public void Display() {

        super.Display();
        System.out.println("Cosmetic type: " + cosmeticType);
        System.out.println("Cosmetic brand: " + brand);
    }

}
