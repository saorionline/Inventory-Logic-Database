package io.saori.protocol.market;

import io.saori.protocol.core.Product;
import io.saori.protocol.core.AtomicUpdateException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarketTest {

    @Test
    void testForexTrade() throws AtomicUpdateException {
        // 1. Initialize our Peso Vault with 1 Million COP
        Product copPool = new Product("USD/COP", "COP Liquidity", 3950.50, 1000000)  ;
        OrderBook book = new OrderBook();

        // 2. A Corporate Client wants to BUY 250,000 Pesos       
        // Price: 3960.00 (The rate they agreed on), Quantity: 250000, Type: BUY
        Order buyPesos = new Order(3960.00, 250000, Order.Type.BUY);
        book.processOrder(buyPesos, copPool);
        assertEquals(750000, copPool.getQuantity(), "Stock should decrease to 750k");

        // 3. The Inevitability: The Vault must decrease
        // 1,000,000 - 250,000 = 750,000 
       
        Order sellPesos = new Order(3940.00, 50000, Order.Type.SELL);
        book.processOrder(sellPesos, copPool);
        assertEquals(800000, copPool.getQuantity(), "Stock should increase to 800k after SELL");
        
        System.out.println("[SUCCESS] Forex Round Trip Complete.");
        System.out.println("New USD/COP Market Price: " + buyPesos.getPrice());   
        System.out.println("Final COP Liquidity: " + copPool.getQuantity()); }
}