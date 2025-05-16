package com.mycompany.pharmacy.Classes;

public class Customer extends Person {
    private String customerID;
    private String address;
    private int point;

    public Customer() {
        super();
        this.customerID = "Unknown";
        this.address = "Unknown";
        this.point = 0;
    }

    public Customer(String name, int age, String gender, String email, String telephoneNumber, String customerID, String address , String insuranceCompany ,
    String insuranceNumber) {
        super(name, age , gender, email, telephoneNumber , insuranceCompany , insuranceNumber);
        this.customerID = customerID;
        this.address = address;
        this.point = 0;
    }

    public void addPoints(int point) {
        this.point += point;
    }
    
    int getPoints() {
        return point;
    }

    public String getName()
    {
        return super.name;
    }
    public int getAge()
    {
        return super.age;
    }
    public String getGender()
    {
        return super.gender;
    }
    public String getEmail()
    {
        return super.email;
    }
    public String getPhoneNumber()
    {
        return super.telephoneNumber;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getAddress() {
        return address;
    }
    public String getInsuranceCompany() {
        return super.insuranceCompany;
    }
    public String getInsuranceNumber() {
        return super.insuranceNumber;
    }
}