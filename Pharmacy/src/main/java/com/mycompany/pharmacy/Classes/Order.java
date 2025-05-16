package com.mycompany.pharmacy.Classes;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products;
    private Customer customer;
    private String TypeOfPayment;


    public Order(Map<Product, Integer> products, Customer customer, String paymentMethod) {
        this.products = products;
        this.customer = customer;
        this.TypeOfPayment = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void AddProducts(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }
    public void RemoveProducts(Product product) {
        products.remove(product);
    }
    public int CalculateTotal()
    {
        return products.size();
    }
    public double CalculateCost ()
    {
        double cost=0;
        for(Map.Entry<Product, Integer> entry : products.entrySet())
        {
            cost += entry.getKey().getCost();
        }
        return cost;
    }
    public void DisplayOrder()
    {
        System.out.println("Order Details: ");
        System.out.println("\tCustomer Name: " + customer.getName());
        System.out.println("\tCustomer Phone Number: " + customer.getPhoneNumber());
        System.out.println("\tProducts: ");
        for(Map.Entry<Product, Integer> entry : products.entrySet())
        {
            System.out.print("\t\tProduct Name: " + entry.getKey().getName());
            System.out.print("\tProduct Price: " + entry.getKey().getCost());
            System.out.print("\tProduct Expiry Date: " + entry.getKey().getExpireDate());
            System.out.println();
        }
        System.out.println("\tTotal Cost: " + CalculateCost());
        System.out.println("\tType of Payment: " + TypeOfPayment);
    }
    public void SetTypeOfPayment(String TypeOfPayment) {
        this.TypeOfPayment = TypeOfPayment;
    }


}
