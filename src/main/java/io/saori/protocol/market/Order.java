package io.saori.protocol.market;

public class Order {
    public enum Type { BUY, SELL }
    
    private final double price;
    private int quantity;
    private final Type type;

    public Order(double price, int quantity, Type type) {
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }
    // Add getters for price and quantity
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public Type getType() {
        return type;
    }
}


