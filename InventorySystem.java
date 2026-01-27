class Product {
    // 1. Encapsulation: We make fields private so they can't be changed accidentally
    private String name;
    private int stock;
    private double price;

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    // 2. The Logic: A method that "does" something
    public String sell(int quantity) {
        if (quantity <= this.stock) {
            this.stock = this.stock - quantity; // Update internal memory
            return "SUCCESS: Sold " + quantity + " " + this.name + "(s).";
        } else {
            return "ERROR: Not enough stock for " + this.name + "!";
        }
    }

    // 3. A Return: To see the current state
    public void displayStatus() {
        System.out.println("Item: " + name + " | Remaining Stock: " + stock);
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        // Create one product mockup
        Product laptop = new Product("Laptop", 10, 1200.00);

        // Try to sell items
        System.out.println(laptop.sell(3)); // Should work
        laptop.displayStatus();

        System.out.println(laptop.sell(15)); // Should fail (only 7 left)
        laptop.displayStatus();
    }
}