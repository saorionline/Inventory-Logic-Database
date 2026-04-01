package io.saori.protocol.core;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    @Test
    @DisplayName("Should return the correct price")
    void testProductPrice() {
        // Constructor consistente de 4 args: (id, name, price, stock)
        Product laptop = new Product("LAPTOP-01", "Laptop", 1200.0, 5);

        assertEquals(1200.0, laptop.getPrice());
    }

    @Test
    @DisplayName("Test successful stock update. Should deduct stock when liquidity is sufficient")
    void testSuccessfulTrade() throws AtomicUpdateException {
        // FIX 1: Renombrado de `p` a `laptop` para ser consistente
        // FIX 2: Constructor de 4 args (igual que los demás tests)
        Product laptop = new Product("T-01", "Test", 100.0, 10);

        laptop.updateStock(4);

        assertEquals(6, laptop.getStock(), "Stock should be 6 after selling 4.");
    }

    @Test
    @DisplayName("Should REVERT state and throw exception if stock is insufficient")
    void testFailedTradeDoesNotChangeState() {
        Product laptop = new Product("T-01", "Test", 100.0, 5);

        AtomicUpdateException exception = assertThrows(AtomicUpdateException.class, () -> {
            laptop.updateStock(10); // Intentar vender más del stock disponible (5)
        });

        assertTrue(exception.getMessage().contains("insufficient stock"));

        // FIX: El stock inicial era 5 y NO debe cambiar tras el fallo
        assertEquals(5, laptop.getStock(), "State must not change if the trade fails.");
    }

    @Test
    @DisplayName("Should reject non-positive quantities")
    void testInvalidQuantity() {
        Product laptop = new Product("LAPTOP-01", "ThinkPad", 1200.0, 10);

        assertThrows(AtomicUpdateException.class, () -> {
            laptop.updateStock(0);
        });

        assertThrows(AtomicUpdateException.class, () -> {
            laptop.updateStock(-5);
        });
    }
}