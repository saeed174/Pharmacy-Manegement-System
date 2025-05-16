package com.mycompany.pharmacy.Classes;

public class Recipe extends Product {

    private PharmacyEmployee Pharmacist;
    private String recipeType;

    public Recipe() {
        super();
        this.Pharmacist = new PharmacyEmployee();
        this.recipeType = "Unknown";
    }

    public Recipe(String name, double cost, int quantity, String expireDate, String Id, String recipeType,
            PharmacyEmployee Pharmacist) {
        super(name, cost, quantity, expireDate, Id);
        this.recipeType = recipeType;
        this.Pharmacist = Pharmacist;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public PharmacyEmployee getPharmacist() {
        return Pharmacist;
    }

    @Override
    public void Display() {
        System.out.println("The Pharmacist's Name is : " + Pharmacist.getName());
        System.out.println("Recipe Type is : " + getPharmacist());
        System.out.println("Expire Date is: " + getExpireDate());
        System.out.println("The Product Cost is : " + getCost());

    }

}