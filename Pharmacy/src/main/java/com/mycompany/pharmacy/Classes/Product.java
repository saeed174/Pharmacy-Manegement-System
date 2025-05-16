package com.mycompany.pharmacy.Classes;

public class Product implements Sortable {
    private String name;
    private String Id;
    private double cost;
    private String expireDate;
    private int quantity;
    private static int NumberOfproducts;

    Product() {
        NumberOfproducts++;
        this.name = "Unknown";
        this.Id = "Unknown";
        this.cost = 0.0;
        this.expireDate = "Unknown";
    }

    Product(String name, double cost, int quantity, String expireDate, String Id) {
        this.name = name;
        this.cost = cost;
        this.expireDate = expireDate;
        this.Id = Id;
        this.quantity = quantity;
        NumberOfproducts += quantity;

    }

    public void Display() {
        System.out.println("Product name: " + name);
        System.out.print("\tProduct cost: " + cost);
        System.out.println("\tProduct Expiry Date: " + expireDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String Id) {
        this.Id = Id;

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setexpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getName() {
        return name;

    }

    public String getId() {
        return Id;

    }

    public static int getNumberOfProducts() {
        return NumberOfproducts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product p) {
        if (p == null) return 1;
        return this.name.compareToIgnoreCase(p.getName());
    }

}
