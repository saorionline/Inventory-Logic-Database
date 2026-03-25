import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("Test successful stock update. Should deduct stock when liquidity is sufficient")
    void testSuccessfulTrade() throws AtomicUpdateException {
        // Arrange: Set up the initial state
        Product p = new Product("T-01", "Test", 100.0, 10);
        // Act: Execute the state change
        laptop.updateStock(4);
        // Assert: Verify the outcome
        assertEquals(6, laptop.getStock(), "Stock should be 6 after selling 4.");
    }

    @Test
    @DisplayName("Should REVERT state and throw exception if stock is insufficient")
    void testFailedTradeDoesNotChangeState() {
        // Arrange
        Product laptop = new Product("T-01", "Test", 100.0, 5);

        // Act & Assert: Verify that the exception is thrown AND state remains untouched
        AtomicUpdateException exception = assertThrows(AtomicUpdateException.class, () -> {
            laptop.updateStock(5); // Attempting to sell more than available
        });
        
        // Verify the error message inside the exception
        assertTrue(exception.getMessage().contains("insufficient stock"));
        
        // CRITICAL: Verify state "Inevitability" (Stock must still be 3)
        assertEquals(3, laptop.getStock(), "State must not change if the trade fails.");
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