package com.mycompany.pharmacy.Classes;

public class Delivary extends PharmacyEmployee {
    private Order currentOrder;
    private String custumerAddress;
    private String deliveryDate ;
    

    public Delivary() {
        super();
        currentOrder = null;
        custumerAddress= "UNKOWN";
        deliveryDate = "UNKOWN";
    }
    

    public Delivary(String name, int age, String gender, String email, String telephoneNumber, String insuranceCompany,
            String insuranceNumber, String position, float workingHours,
            String workingShift, String employeeId, float salary, float salaryBonus, Order currentOrder,
            Customer currentCustomer, String custumerAddress, String deliveryDate) {
        super( name,  age,  gender,  email,  telephoneNumber ,  insuranceCompany ,  insuranceNumber,  position,  workingHours,  workingShift,  employeeId,  salary,  salaryBonus);
        this.currentOrder = currentOrder;
        this.custumerAddress = custumerAddress;
        this.deliveryDate = deliveryDate;
    }

    public Delivary(String name , int age ,String gender ,String email ,String telephoneNumber , float workingHours, String workingShift, String employeeId,String stateOfOrder,String deliveryDate , Order currentOrder) {
        super(name, age, gender, email, telephoneNumber, workingHours, workingShift, employeeId);
        this.currentOrder=currentOrder;
        this.deliveryDate=deliveryDate;
    }


    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }


    public void setCustumerAddress(String custumerAddress) {
        this.custumerAddress = custumerAddress;
    }


    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public Order getCurrentOrder() {
        return currentOrder;
    }

    public String getCustumerAddress() {
        return custumerAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    void DeliverOrder() {
        System.out.println("Delivering order to " + custumerAddress + " on " + deliveryDate);
        currentOrder.DisplayOrder();
        System.out.println("Order delivered successfully!");
    }
}