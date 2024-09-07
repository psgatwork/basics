package com.learning.copilot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class InventoryManagerTest {

    private InventoryManager inventoryManager;

    @BeforeEach
    public void setUp() {
        inventoryManager = new InventoryManager();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        assertEquals(product, inventoryManager.getProduct(1), "Product should be added to the inventory");
    }

    @Test
    public void testAddDuplicateProduct() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        inventoryManager.addProduct(product);
        assertNull(inventoryManager.getProduct(2), "Duplicate product should not be added to the inventory");
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        inventoryManager.removeProduct(1);
        assertNull(inventoryManager.getProduct(1), "Product should be removed from the inventory");
    }

    @Test
    public void testRemoveNonExistentProduct() {
        inventoryManager.removeProduct(1);
        assertNull(inventoryManager.getProduct(1), "Non-existent product should not be removed from the inventory");
    }

    @Test
    public void testListProducts() {
        Product product1 = new Product(1, "Laptop", 10);
        Product product2 = new Product(2, "Mouse", 50);
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);
        assertEquals(2, inventoryManager.listProducts().size(), "Inventory should contain two products");
    }

    @Test
    public void testUpdateProductQuantity() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        inventoryManager.updateProductQuantity(1, 5);
        assertEquals(5, inventoryManager.getProduct(1).getQuantity(), "Product quantity should be updated");
    }

    @Test
    public void testUpdateNonExistentProductQuantity() {
        inventoryManager.updateProductQuantity(1, 5);
        assertNull(inventoryManager.getProduct(1), "Non-existent product quantity should not be updated");
    }
}