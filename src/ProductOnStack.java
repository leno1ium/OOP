import product.Product;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductOnStack {
    private Product product;
    private Stack stack;
    private int quantity = 100;
    private LocalDateTime arrivingDate;
    private static final String PROPERTY_PRODUCT;
    private static final String PROPERTY_STACK;
    private static final String PROPERTY_QUANTITY;
    private static final String PROPERTY_ARRIVING_DATE;

    static {
        PROPERTY_PRODUCT = "Product: ";
        PROPERTY_STACK = "Stack: ";
        PROPERTY_QUANTITY = "Quantity: ";
        PROPERTY_ARRIVING_DATE = "Product arrival date: ";
    }

    {
        arrivingDate = LocalDateTime.now();
    }

    public ProductOnStack(Product product, Stack stack, int quantity, LocalDateTime arrivingDate) {
        this.product = product;
        this.stack = stack;
        this.quantity = quantity;
        this.arrivingDate = arrivingDate;
    }

    public ProductOnStack(Product product, Stack stack) {
        this.product = product;
        this.stack = stack;
    }

    @Override
    public boolean equals(Object o) {//except date
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOnStack that = (ProductOnStack) o;
        return quantity == that.quantity && Objects.equals(product, that.product) && Objects.equals(stack, that.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, stack, quantity);
    }

    public void productArrivalToday() {
        this.arrivingDate = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(LocalDateTime arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    @Override
    public String toString() {
        return "[Product on Stack] \n" +
                PROPERTY_PRODUCT + product + "\n" +
                PROPERTY_STACK + stack + "\n" +
                PROPERTY_QUANTITY + quantity + "\n" +
                PROPERTY_ARRIVING_DATE + arrivingDate + ";\n";
    }
}
