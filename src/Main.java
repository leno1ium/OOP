import market.markets.EmployeeException;
import market.employees.Cashier;
import market.employees.Jobs;
import market.markets.OnlineMarket;
import market.markets.ProductInStockException;
import market.markets.Supermarket;
import product.Drink;
import product.Meal;
import product.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws EmployeeException {
        Stack stack1 = new Stack(1, Stack.Location.SHOP, 100);

        Product milk = new Drink("milk", LocalDateTime.now(),
                "manufacturer 0", 79, 1, false);

        Product bread = new Meal("bread", LocalDateTime.now(),
                "manufacturer 1", 65, 0.5, true);

        Product product = new Product("usual product", "somebody, but not me");

        ProductOnStack productOnStack = new ProductOnStack(milk, stack1);
        ProductOnStack productOnStack1 = new ProductOnStack(bread, stack1);

        /*product.consume();
        milk.consume();
        bread.consume();*/
        System.out.println("---------");

        //productOnStack.productArrivalToday();
        //productOnStack.setQuantity(56);

        Product p1 = new Product("usual product", "somebody, but not me");
        System.out.println(p1.equals(product)); //true

        Product m1 = new Drink("milk", LocalDateTime.now(),
                "manufacturer 0", 79, 1, true);
        System.out.println(m1.equals(milk));//false

        Product b1 = new Meal("bread", LocalDateTime.of(2023, 12, 31, 22, 22),
                "manufacturer 1", 65, 0.5, true);
        System.out.println(b1.equals(bread));//true

        ProductOnStack pos1 = new ProductOnStack(m1, stack1);
        System.out.println(pos1.equals(productOnStack));//false

        ProductOnStack pos2 = new ProductOnStack(b1, stack1);
        System.out.println(pos2.equals(productOnStack1));//true

        Supermarket sup = new Supermarket("pyaterochka", "somebody");
        if (sup.employ("Elena", "Seriakova", 19, Jobs.CASHIER))
            System.out.println(sup.getLastEmployed() + " успешно принят!");
        OnlineMarket mark = new OnlineMarket("wildberries", "wildberries.com");
        mark.employ("Dmitriy", "Paschenkov", 24, Jobs.MANAGER);
        System.out.println(mark.getEmployeesList());

        sup.makeOrderToFactory(milk, 100);
        try {
            mark.makeOrderToFactory(bread, 500);
            mark.sellProducts(bread, 2000);
        } catch (ProductInStockException p) {
            System.err.println(p.getMessage());
        }
        System.out.println(sup.getProductsList());

        try {
            mark.employ("Elena", "S", 19, Jobs.MANAGER);
            mark.employ("Elena", "S", 19, Jobs.MANAGER);
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
        }
        //System.out.println(sup.fire(cashier));
    }
}