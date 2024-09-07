package com.learning.copilot;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

// InventoryManager class that uses a Map to add, remove, list, and update products
public class InventoryManager {
    private static final Logger logger = Logger.getLogger(InventoryManager.class.getName());
    private Map<Integer, Product> products = new HashMap<>();

    // Add a product to the inventory
    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            logger.warning("Product with ID " + product.getId() + " already exists.");
        } else {
            products.put(product.getId(), product);
            logger.info("Product added: " + product);
        }
    }

    // Remove a product from the inventory by ID
    public void removeProduct(int id) {
        if (products.remove(id) != null) {
            logger.info("Product with ID " + id + " removed.");
        } else {
            logger.warning("Product with ID " + id + " not found.");
        }
    }

    // List all products in the inventory
    public Map<Integer, Product> listProducts() {
        if (products.isEmpty()) {
            logger.info("No products in inventory.");
        }
        return products;
    }
    
    // Get all products in the inventory
    public Product getProduct(int id) {
        return products.get(id);
    }

    // Update the quantity of a product by ID
    public void updateProductQuantity(int id, int quantity) {
        Product product = products.get(id);
        if (product != null) {
            product.setQuantity(quantity);
            logger.info("Product quantity updated: " + product);
        } else {
            logger.warning("Product with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Add products
        inventoryManager.addProduct(new Product(1, "Laptop", 10));
        inventoryManager.addProduct(new Product(2, "Mouse", 50));
        inventoryManager.addProduct(new Product(3, "Keyboard", 20));

        // List products
        inventoryManager.listProducts();

        // Update product quantity
        inventoryManager.updateProductQuantity(1, 5);

        // List products after updating quantity
        inventoryManager.listProducts();

        // Remove product
        inventoryManager.removeProduct(2);

        // List products after removing product
        inventoryManager.listProducts();
    }
}
