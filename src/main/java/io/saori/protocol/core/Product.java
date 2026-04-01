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
        if (qty <= 0) {
            throw new AtomicUpdateException(ticker, qty, stock);
        }
        if (stock < qty) {
            throw new AtomicUpdateException(ticker, qty, stock);
        }
        // Only reaches here if BOTH guards pass — all-or-nothing
        this.stock -= qty;
        System.out.printf("[OK]       %s | stock: %d → %d%n",
            ticker, stock + qty, stock);
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
}