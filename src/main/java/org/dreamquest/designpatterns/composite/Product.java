package org.dreamquest.designpatterns.composite;

public class Product implements IProductComponent{
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double operation() {
        System.out.println("Product: " + name + ", Price: $" + price);
        return price;

    }
}
