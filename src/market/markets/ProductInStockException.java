package market.markets;

import market.employees.Employee;
import product.Product;

public class ProductInStockException extends Exception {
    public ProductInStockException(String message, Product product, int count) {
        super(message + " - " + product.getName() + " - " + count);
    }

}
