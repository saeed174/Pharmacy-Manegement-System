package com.mycompany.pharmacy.Classes;

public class Medicine extends Product {
    private String Medicine_type;
    private String Medicine_company;
    private String Medicine_dose;

    public Medicine() {
        super();
    }

    public Medicine(String name, double cost, int quantity, String expireDate, String Id, String Medicine_type,
            String Medicine_company, String Medicine_dose) {
        super(name, cost, quantity, expireDate, Id);
        this.Medicine_type = Medicine_type;
        this.Medicine_company = Medicine_company;
        this.Medicine_dose = Medicine_dose;
    }

    public void Display() {
        super.Display();
        System.out.println("Medicine type: " + Medicine_type);
        System.out.println("Medicine company: " + Medicine_company);
        System.out.println("Medicine dose: " + Medicine_dose);
    }

    String getType() {
        return Medicine_type;
    }

    String getCompany() {
        return Medicine_company;
    }

    String getDose() {
        return Medicine_dose;
    }

}
