package StockTaking.System;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class StockManagerTest {
    private StockManager stockManager;

    @BeforeEach
    public void setUp() {
        stockManager = new StockManager();
        stockManager.addProduct(new Product("Apple", 50, 0.50));
        stockManager.addProduct(new Product("Banana", 30, 0.30));
    }

    @Test
    public void testAddProduct() {
        stockManager.addProduct(new Product("Orange", 20, 0.80));
        List<Product> products = stockManager.getProducts();
        assertEquals(3, products.size());
        assertEquals("Orange", products.get(2).getName());
    }

    @Test
    public void testSellProduct() {
        stockManager.sellProduct("Apple", 10);
        Product apple = stockManager.getProducts().stream()
                .filter(p -> p.getName().equals("Apple"))
                .findFirst().orElse(null);
        assertNotNull(apple);
        assertEquals(40, apple.getQuantity());
    }

    @Test
    public void testSellProductNotFound() {
        stockManager.sellProduct("Orange", 10);
        // Ensure no product is added or modified
        assertEquals(2, stockManager.getProducts().size());
    }

    @Test
    public void testDisplayStock() {
        // Output might be more complex to test; consider checking internal state instead
        stockManager.displayStock();
    }

    @Test
    public void testGenerateReport() {
        // As above, direct output testing may be complex
        stockManager.generateReport();
    }
}

