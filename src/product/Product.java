package product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private String name = "product";
    private LocalDateTime createData;
    private String manufacturer = "manufacturer";
    private double price;
    /*private static final String PROPERTY_NAME = "Name: ";
    private static final String PROPERTY_CREATE_DATA = "Creation date: ";
    private static final String PROPERTY_MANUFACTURER;
    private static final String PROPERTY_PRICE;*/

    {
        createData = LocalDateTime.now();
    }

    /*static {
        PROPERTY_MANUFACTURER = "Manufacturer: ";
        PROPERTY_PRICE = "Price: ";
    }*/
    public Product(String name, String manufacturer) {
        this(name, LocalDateTime.now(), manufacturer, 100);
    }

    public Product(String name, LocalDateTime createData,
                   String manufacturer, double price) {
        this.name = name;
        this.createData = createData;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Product(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) { //except date
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturer, price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateData() {
        return createData;
    }

    public void setCreateData(LocalDateTime createData) {
        this.createData = createData;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void consume() {
        System.out.println("You've consumed the " + name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", createData=" + createData +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }


/*@Override
    public String toString(){
        return "[Product] \n" +
                PROPERTY_NAME + name + "\n" +
                PROPERTY_CREATE_DATA + createData + "\n" +
                PROPERTY_MANUFACTURER + manufacturer + "\n" +
                PROPERTY_PRICE + price;
    }*/
}
