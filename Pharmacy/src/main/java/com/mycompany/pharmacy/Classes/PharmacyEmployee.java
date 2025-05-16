package com.mycompany.pharmacy.Classes;

public class PharmacyEmployee extends Person {
    private String position;
    private float workingHours;
    private String workingShift;
    private String employeeId;
    private float salary;
    private float salaryBonus;

    public PharmacyEmployee() {
        super();
        this.position = "Unknown";
        this.workingHours = 0.0f;
        this.workingShift = "Unknown";
        this.employeeId = "Unknown";
        this.salary = 0.0f;
        this.salaryBonus = 0.0f;
    }
    
    public PharmacyEmployee(String name, int age, String gender, String email, String telephoneNumber , String insuranceCompany , String insuranceNumber, String position, float workingHours, String workingShift, String employeeId, float salary, float salaryBonus) {
        super(name, age, gender, email, telephoneNumber, insuranceCompany, insuranceNumber);
        this.position = position;
        this.workingHours = workingHours;
        this.workingShift = workingShift;
        this.employeeId = employeeId;
        this.salary = salary;
        this.salaryBonus = salaryBonus;
    }
    public PharmacyEmployee(String name , int age, String gender, String email, String telephoneNumber ,  float workingHours, String workingShift, String employeeId) {
      
     this.name = name;
     this.age = age;
     this.gender = gender;
     this.email = email;
     this.telephoneNumber = telephoneNumber;
     this.workingHours = workingHours;
     this.workingShift = workingShift;
     this.employeeId = employeeId;
    
     
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

    public String getInsuranceCompany() {
        return super.insuranceCompany;
    }
    public String getInsuranceNumber() {
        return super.insuranceNumber;
    }

    public String getPosition() {
        return position;
    }
    public float getWorkingHours() {
        return workingHours;
    }
    public String getWorkingShift() {
        return workingShift;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public float getSalary() {
        return salary + salaryBonus;
    }
    public float getSalaryBonus() {
        return salaryBonus;
    }

    public void calculateBonus()
    {
        if (this.workingHours > 40) {
            this.salaryBonus = (this.workingHours - 40) * 1.5f * this.salary;
        } else {
            this.salaryBonus = 0.0f;
        }
    }

}
