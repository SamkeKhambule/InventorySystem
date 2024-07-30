package StockTaking.System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockManager stockManager = new StockManager();
        stockManager.loadData("stock_data.ser");
        Scanner scanner = new Scanner(System.in);

        stockManager.addProduct(new Product("Apple", 50, 1.50));
        stockManager.addProduct(new Product("Banana", 30, 2.00));
        stockManager.addProduct(new Product("Orange", 20, 2.00));

        while (true) {
            System.out.println("\nStock Taking System Menu:");
            System.out.println("1. View Stock");
            System.out.println("2. Sell Product");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stockManager.displayStock();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter quantity to sell: ");
                    int quantity = scanner.nextInt();
                    stockManager.sellProduct(productName, quantity);
                    stockManager.saveData("stock_data.ser");
                    break;
                case 3:
                    stockManager.generateReport();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    stockManager.saveData("stock_data.ser");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
