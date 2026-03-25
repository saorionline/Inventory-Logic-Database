public class AtomicUpdateException extends Exception {

    private final String ticker;
    private final int requestedQty;
    private final int availableStock;

    public AtomicUpdateException(String ticker, int requestedQty, int availableStock) {
        super(String.format(
            "[REJECTED] %s | requested: %d | available: %d | reason: insufficient stock",
            ticker, requestedQty, availableStock
        ));
        this.ticker      = ticker;
        this.requestedQty  = requestedQty;
        this.availableStock = availableStock;
    }

    public String getTicker()        { return ticker; }
    public int getRequestedQty()     { return requestedQty; }
    public int getAvailableStock()   { return availableStock; }
}