package market.markets;

import market.employees.Cashier;
import market.employees.Employee;
import market.employees.Jobs;
import market.employees.Manager;
import product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Supermarket implements Market {
    private String name;
    private String owner;
    private HashMap<Product, Integer> productsInStock = new HashMap<>();
    private List<Employee> employees = new ArrayList<>();

    public void makeOrderToFactory(Product product, int quantity) {
        productsInStock.put(product, productsInStock.getOrDefault(product, 0) + quantity);
    }

    public boolean sellProducts(Product product, int quantity) {
        if (quantity > 0 && productsInStock.get(product) > quantity) {
            productsInStock.put(product, productsInStock.getOrDefault(product, 0) - quantity);
            return true;
        }
        return false;
    }

    @Override
    public boolean employ(String name, String surname, int age, Jobs job) {
        if (job == Jobs.CASHIER) {
            return employees.add(new Cashier(name, surname, age, LocalDate.now()));
        }
        if (job == Jobs.MANAGER) {
            return employees.add(new Manager(name, surname, age, LocalDate.now()));
        }
        return false;
    }

    @Override
    public boolean fire(Employee employee) {
        for (Employee e : employees) {
            if (e.equals(employee)) return employees.remove(e);
        }
        return false;
    }

    public Supermarket(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getEmployeesList() {
        StringBuilder str = new StringBuilder();
        for (Employee emp : employees) {
            str.append(emp.toString());
        }
        return str.toString();
    }

    public String getLastEmployed() {
        return employees.get(employees.size() - 1).toString();
    }

    public String getProductsList() {
        StringBuilder str = new StringBuilder();
        for (Product pr : productsInStock.keySet()) {
            str.append(pr.toString()).append(" - ").append(productsInStock.get(pr)).append(" ед. \n");
        }
        return str.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", productsInStock=" + productsInStock +
                ", employees=" + employees +
                '}';
    }
}

