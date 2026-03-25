public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("LAPTOP-01", "ThinkPad X1", 1200.00, 3);

        try { laptop.updateStock(2); } catch (AtomicUpdateException e) { System.out.println(e.getMessage()); }
        try { laptop.updateStock(5); } catch (AtomicUpdateException e) { System.out.println(e.getMessage()); }
        try { laptop.updateStock(0); } catch (AtomicUpdateException e) { System.out.println(e.getMessage()); }

        System.out.println(laptop);
    }
}
```

Expected output:
```
[OK]       LAPTOP-01 | stock: 3 → 1
[REJECTED] LAPTOP-01 | requested: 5 | available: 1 | reason: insufficient stock
[REJECTED] LAPTOP-01 | requested: 0 | available: 1 | reason: insufficient stock
Product{ticker='LAPTOP-01', name='ThinkPad X1', price=1200.00, stock=1}