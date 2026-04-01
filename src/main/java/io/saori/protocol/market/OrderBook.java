package io.saori.protocol.market;

import io.saori.protocol.core.Product;

public class OrderBook {
    public void processOrder(Order order, Product product) {
        // This is where the 10 -> 6 logic will live!
        if (order.getType() == Order.Type.SELL) {
            // Logic to add to the book
        }
    }
}
