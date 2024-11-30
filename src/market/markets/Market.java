package market.markets;

import market.employees.Employee;
import market.employees.Jobs;
import product.Product;

public interface Market {
    void makeOrderToFactory(Product product, int quantity);

    boolean sellProducts(Product product, int quantity) throws ProductInStockException;

    boolean employ(String name, String surname, int age, Jobs job) throws EmployeeException;

    boolean fire(Employee employee) throws EmployeeException;
}
