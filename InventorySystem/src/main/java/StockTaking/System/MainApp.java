package StockTaking.System;

//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;

//public class MainApp extends Application {
//    private StockManager stockManager;
//
//    @Override
//    public void start(Stage primaryStage) {
//        stockManager = new StockManager();
//        stockManager.loadData("stock_data.ser");
//
//        primaryStage.setTitle("Stock Taking System");
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(8);
//        grid.setHgap(10);
//
//        // Product name input
//        Label nameLabel = new Label("Product Name:");
//        GridPane.setConstraints(nameLabel, 0, 0);
//        TextField nameInput = new TextField();
//        GridPane.setConstraints(nameInput, 1, 0);
//
//        // Product quantity input
//        Label quantityLabel = new Label("Quantity:");
//        GridPane.setConstraints(quantityLabel, 0, 1);
//        TextField quantityInput = new TextField();
//        GridPane.setConstraints(quantityInput, 1, 1);
//
//        // Product price input
//        Label priceLabel = new Label("Price:");
//        GridPane.setConstraints(priceLabel, 0, 2);
//        TextField priceInput = new TextField();
//        GridPane.setConstraints(priceInput, 1, 2);
//
//        // Add product button
//        Button addButton = new Button("Add Product");
//        GridPane.setConstraints(addButton, 1, 3);
//        addButton.setOnAction(e -> {
//            String name = nameInput.getText();
//            int quantity = Integer.parseInt(quantityInput.getText());
//            double price = Double.parseDouble(priceInput.getText());
//            stockManager.addProduct(new Product(name, quantity, price));
//            stockManager.saveData("stock_data.ser");
//            nameInput.clear();
//            quantityInput.clear();
//            priceInput.clear();
//        });
//
//        // Sell product button
//        Button sellButton = new Button("Sell Product");
//        GridPane.setConstraints(sellButton, 1, 4);
//        sellButton.setOnAction(e -> {
//            String name = nameInput.getText();
//            int quantity = Integer.parseInt(quantityInput.getText());
//            stockManager.sellProduct(name, quantity);
//            stockManager.saveData("stock_data.ser");
//            nameInput.clear();
//            quantityInput.clear();
//        });
//
//        // View stock button
//        Button viewButton = new Button("View Stock");
//        GridPane.setConstraints(viewButton, 1, 5);
//        viewButton.setOnAction(e -> {
//            stockManager.displayStock();
//        });
//
//        // Generate report button
//        Button reportButton = new Button("Generate Report");
//        GridPane.setConstraints(reportButton, 1, 6);
//        reportButton.setOnAction(e -> stockManager.generateReport());
//
//        grid.getChildren().addAll(nameLabel, nameInput, quantityLabel, quantityInput, priceLabel, priceInput, addButton, sellButton, viewButton, reportButton);
//
//        Scene scene = new Scene(grid, 300, 250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    @Override
//    public void stop() {
//        stockManager.saveData("stock_data.ser");
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
