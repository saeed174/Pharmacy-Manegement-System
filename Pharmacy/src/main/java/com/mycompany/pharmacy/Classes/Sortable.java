package com.mycompany.pharmacy.Classes;

public interface Sortable extends Comparable<Product> {

    public abstract int compareTo(Product p);
}
