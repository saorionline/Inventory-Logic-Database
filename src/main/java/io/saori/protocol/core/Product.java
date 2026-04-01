package io.saori.protocol.core;


public class Product {

    private String ticker;   // asset "address" — e.g. "LAPTOP-01"
    private String name;
    private double price;
    private int    stock;

    public Product(String ticker, String name, double price, int stock) {
        this.ticker = ticker;
        this.name   = name;
        this.price  = price;
        this.stock  = stock;
    }

    /**
     * Atomic stock deduction.
     * Either the full quantity is deducted, or the state is untouched.
     * Throws AtomicUpdateException if the trade cannot be fulfilled.
     */
    public void updateStock(int qty) throws AtomicUpdateException {
    // 1. Calculate what the new stock WOULD be
    // If qty is -4 (BUY), stock goes down. If qty is +2 (SELL), stock goes up.
    int newStock = this.stock + qty;

    // 2. The Golden Rule of Liquidity: You cannot have less than 0 stock.
    if (newStock < 0) {
        // We use Math.abs to show the user how much they tried to take
        throw new AtomicUpdateException(ticker, Math.abs(qty), stock);
    }

    // 3. Execution: If we didn't crash above, the trade is inevitable.
    System.out.printf("[OK]       %s | stock: %d → %d%n", 
                      ticker, this.stock, newStock);
                      
    this.stock = newStock;
}

    // Getters
    public String getTicker() { return ticker; }
    public String getName()   { return name; }
    public double getPrice()  { return price; }
    public int    getStock()  { return stock; }

    @Override
    public String toString() {
        return String.format("Product{ticker='%s', name='%s', price=%.2f, stock=%d}",
            ticker, name, price, stock);
    }

    // This "bridges" the name your Market expects (quantity) 
    // with the name your Product uses (stock).
    public int getQuantity() {
    return this.stock;
}
}