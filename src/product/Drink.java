package product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Drink extends Product {
    private double volume;
    private boolean isCarbonated = false;
    //private static String carbonation = "no";
    //private static final String PROPERTY_VOLUME;
    //private static final String PROPERTY_CARBONATION;

    /*static {
        //PROPERTY_VOLUME = "Volume: ";
        //PROPERTY_CARBONATION = "Carbonation: ";
    }*/

    public Drink(String name, LocalDateTime createData,
                 String manufacturer, double price,
                 double volume, boolean isCarbonated) {
        super(name, createData, manufacturer, price);
        this.volume = volume;
        this.isCarbonated = isCarbonated;
    }

    public Drink(String name, LocalDateTime createData, String manufacturer, double price, double volume) {
        super(name, createData, manufacturer, price);
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {//all
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return Double.compare(volume, drink.volume) == 0 && isCarbonated == drink.isCarbonated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, isCarbonated);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean getCarbonated() {
        return isCarbonated;
    }

    public void setCarbonated(boolean carbonated) {
        isCarbonated = carbonated;
    }

    public void consume() {
        System.out.println("You've drunk the " + getName());
    }

    @Override
    public String toString() {
        return super.toString() + "Drink{" +
                "volume=" + volume +
                ", isCarbonated=" + isCarbonated +
                '}';
    }
//@Override
    /*public String toString() {
        if (isCarbonated) carbonation = "yes";
        return "[Drink] \n" +
                PROPERTY_VOLUME + volume + "\n" +
                PROPERTY_CARBONATION + carbonation + ";\n" +
                super.toString();
    }*/
}
