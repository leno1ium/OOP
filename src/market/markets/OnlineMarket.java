package market.markets;

import market.employees.Employee;
import market.employees.Jobs;
import market.employees.Manager;
import product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnlineMarket implements Market {
    private String name;
    private String webSite;
    private HashMap<Product, Integer> productsInStock = new HashMap<>();
    private List<Employee> employees = new ArrayList<>();

    public void makeOrderToFactory(Product product, int quantity) {
        productsInStock.put(product, productsInStock.getOrDefault(product, 0) + quantity);
    }

    public boolean sellProducts(Product product, int quantity) throws ProductInStockException {
        if (quantity > 0 && productsInStock.get(product) > quantity) {
            productsInStock.put(product, productsInStock.getOrDefault(product, 0) - quantity);
            return true;
        } else throw new ProductInStockException("Недостаточно товара", product, productsInStock.get(product));
    }

    @Override
    public boolean employ(String name, String surname, int age, Jobs job) throws EmployeeException {
        Manager newManager = new Manager(name, surname, age, LocalDate.now());
        if (!employees.contains(newManager)) {
            if (job == Jobs.MANAGER) {
                return employees.add(newManager);
            }
            return false;
        } else throw new EmployeeException("Сотрудник уже нанят", newManager);
    }

    @Override
    public boolean fire(Employee employee) throws EmployeeException {
        if (employees.contains(employee)) {
            for (Employee e : employees) {
                if (e.equals(employee)) return employees.remove(e);
            }
            return false;
        } else throw new EmployeeException("Сотрудник уже уволен", employee);
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
            str.append(pr.toString()).append(" - ").append(productsInStock.get(pr));
        }
        return str.toString();
    }

    public OnlineMarket(String name, String webSite) {
        this.name = name;
        this.webSite = webSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "OnlineMarket{" +
                "name='" + name + '\'' +
                ", webSite='" + webSite + '\'' +
                ", productsInStock=" + productsInStock +
                ", employees=" + employees +
                '}';
    }
}
