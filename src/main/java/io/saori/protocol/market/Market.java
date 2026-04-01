package io.saori.protocol.market;

import io.saori.protocol.core.Product;
import io.saori.protocol.core.AtomicUpdateException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Market class acts as the 'Exchange Floor'.
 * It connects the OrderBook engine with the actual Product inventory.
 */
public class Market {
    private final Product product;
    private final OrderBook orderBook;
    private final List<Double> priceHistory;

    public Market(Product product) {
        this.product = product;
        this.orderBook = new OrderBook();
        this.priceHistory = new ArrayList<>();
        // Seed the history with the product's initial price
        this.priceHistory.add(product.getPrice());
    }

    // This is the main entry point for your simulation
    public void placeOrder(double price, int quantity, Order.Type type) throws AtomicUpdateException {
        Order newOrder = new Order(price, quantity, type);
        
        // 1. Tell the OrderBook to process the trade against the Product
        orderBook.processOrder(newOrder, product);
        
        // 2. Record the price of this trade in our history
        priceHistory.add(price);
        
        System.out.println("[MARKET EVENT] Trade executed at $" + price);
    }

    public List<Double> getPriceHistory() {
        return priceHistory;
    }
    
    public double getCurrentPrice() {
        return priceHistory.get(priceHistory.size() - 1);
    }
}