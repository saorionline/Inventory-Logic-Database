public class AtomicUpdateException extends Exception {

    private final String ticker;
    private final int    requestedQty;
    private final int    availableStock;

    public AtomicUpdateException(String ticker, int requestedQty, int availableStock) {
        super(buildMessage(ticker, requestedQty, availableStock));
        this.ticker         = ticker;
        this.requestedQty   = requestedQty;
        this.availableStock = availableStock;
    }

    private static String buildMessage(String ticker, int qty, int stock) {
        if (qty <= 0) {
            return String.format(
                "[REJECTED] %s | invalid quantity: %d (must be > 0)",
                ticker, qty
            );
        }
        return String.format(
            "[REJECTED] %s | insufficient stock: requested=%d, available=%d",
            ticker, qty, stock
        );
    }

    // Getters (opcionales, útiles para assertions más específicas)
    public String getTicker()        { return ticker; }
    public int    getRequestedQty()  { return requestedQty; }
    public int    getAvailableStock(){ return availableStock; }
}

/* 
**Por qué este diseño funciona con tus tests:**

| Test | Condición que lanza la excepción | Mensaje que contiene |
|---|---|---|
| `testFailedTradeDoesNotChangeState` | `stock(5) < qty(10)` | `"insufficient stock"` ✓ |
| `testInvalidQuantity` con `0` | `qty <= 0` | `"invalid quantity"` |
| `testInvalidQuantity` con `-5` | `qty <= 0` | `"invalid quantity"` |

El `assertTrue(exception.getMessage().contains("insufficient stock"))` en tu test va a pasar porque el mensaje generado por `buildMessage` incluye exactamente esa cadena.

**Estructura final de archivos que deberías tener:**
```
src/
├── main/java/
│   ├── Product.java               ✅ ya lo tienes
│   └── AtomicUpdateException.java ← agregar este
└── test/java/
    └── ProductTest.java           ✅ ya corregido */