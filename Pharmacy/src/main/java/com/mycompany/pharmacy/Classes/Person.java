package com.mycompany.pharmacy.Classes;

public abstract class Person {
    public String name;
    public int age;
    public String gender;
    public String email;
    public String telephoneNumber;
    public String insuranceCompany ;
    public String insuranceNumber ;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.email = "Unknown";
        this.telephoneNumber = "Unknown";
        this.insuranceCompany = "Unknown";
        this.insuranceNumber = "Unknown";
    }

    public Person(String name, int age, String gender, String email, String telephoneNumber , String insuranceCompany , String insuranceNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }
    public Person(String name, int age, String gender, String email, String telephoneNumber ) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public abstract String getName();
    public abstract int getAge();
    public abstract String getGender();
    public abstract String getEmail();
    public abstract String getPhoneNumber();
    public abstract String getInsuranceCompany();
    public abstract String getInsuranceNumber();
}