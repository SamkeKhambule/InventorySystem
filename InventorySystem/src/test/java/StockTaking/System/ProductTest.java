package StockTaking.System;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Apple", 50, 0.50);
        assertEquals("Apple", product.getName());
        assertEquals(50, product.getQuantity());
        assertEquals(0.50, product.getPrice());
    }

    @Test
    public void testSellProduct() {
        Product product = new Product("Apple", 50, 0.50);
        product.sell(10);
        assertEquals(40, product.getQuantity());
    }

    @Test
    public void testSellProductInsufficientStock() {
        Product product = new Product("Apple", 5, 0.50);
        product.sell(10);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testIsOutOfStock() {
        Product product = new Product("Apple", 0, 0.50);
        assertTrue(product.isOutOfStock());
        product.setQuantity(10);
        assertFalse(product.isOutOfStock());
    }
}

