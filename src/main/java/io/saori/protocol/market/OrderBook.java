package io.saori.protocol.market;

import io.saori.protocol.core.Product;
import io.saori.protocol.core.AtomicUpdateException;
public class OrderBook {
    // This method simulates a "Market Order" hitting your inventory
    public void processOrder(Order order, Product product) throws AtomicUpdateException {
        System.out.println("[MARKET] Incoming " + order.getType() + " for " + order.getQuantity() + " units");
        // This is where the 10 -> 6 logic will live!
        if (order.getType() == Order.Type.BUY) {
            // BUYER takes stock FROM the protocol
            // We use a negative number to subtract from inventory
            product.updateStock(-order.getQuantity()); 
            System.out.println("[OK] Trade Settled: Inventory Decreased.");
            
        } else if (order.getType() == Order.Type.SELL) {
            // SELLER adds stock TO the protocol
            // We use a positive number to increase inventory
            product.updateStock(order.getQuantity());
            System.out.println("[OK] Trade Settled: Inventory Increased.");
        }
        // Price Discovery: The last processed order sets the Market Price
        System.out.println("[TICKER] New Market Price: $" + order.getPrice());
    }
}
