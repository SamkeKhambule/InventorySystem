package StockTaking.System;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private List<Product> products;

    public StockManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sellProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.sell(quantity);
                if (product.isOutOfStock()) {
                    System.out.println(product.getName() + " is out of stock!");
                }
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    public void displayStock() {
        System.out.println("Current Stock:");
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getQuantity() + " units, R" + product.getPrice() + " each");
        }
    }

    public void saveData(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateReport() {
        System.out.println("Sales and Stock Report:");
        displayStock();
    }

    public List<Product> getProducts() {
    return products;
    }
}
