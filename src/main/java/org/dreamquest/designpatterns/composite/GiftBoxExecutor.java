package org.dreamquest.designpatterns.composite;

public class GiftBoxExecutor {
    public static void main(String[] args) {

        GiftBox mainBox = new GiftBox("Main Box");
        GiftBox subBox1 = new GiftBox("Sub Box 1");
        GiftBox subBox2 = new GiftBox("Sub Box 2");

        Product product1 = new Product("Toy Car", 10.99);
        Product product2 = new Product("Doll", 15.49);
        Product product3 = new Product("Puzzle", 8.99);
        Product product4 = new Product("Board Game", 20.00);
        Product product5 = new Product("Action Figure", 12.99);

        subBox1.add(product1);
        subBox1.add(product2);

        subBox2.add(product3);
        subBox2.add(product4);

        mainBox.add(subBox1);
        mainBox.add(subBox2);
        mainBox.add(product5);

        System.out.println("Gift Box Contents:");
        double operation = mainBox.operation();
        System.out.println(operation);
    }
}
