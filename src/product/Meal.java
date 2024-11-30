package product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Meal extends Product {
    private double weight;
    private boolean isReadyForConsumption;
    private static String consumption = "yes";
    //private static final String PROPERTY_WEIGHT;
    //private static final String PROPERTY_CONSUMPTION;

    /*static {
        PROPERTY_WEIGHT = "Weight: ";
        PROPERTY_CONSUMPTION = "Ready for consumption: ";
    }*/

    {
        isReadyForConsumption = true;
    }

    public Meal(String name, LocalDateTime createData,
                String manufacturer, double price,
                double weight, boolean isReadyForConsumption) {
        super(name, createData, manufacturer, price);
        this.weight = weight;
        this.isReadyForConsumption = isReadyForConsumption;
    }

    public Meal(String name, LocalDateTime createData, String manufacturer, double price, double weight) {
        super(name, createData, manufacturer, price);
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) { //all
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meal meal = (Meal) o;
        return Double.compare(weight, meal.weight) == 0 && isReadyForConsumption == meal.isReadyForConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, isReadyForConsumption);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean getReadyForConsumption() {
        return isReadyForConsumption;
    }

    public void setReadyForConsumption(boolean readyForConsumption) {
        isReadyForConsumption = readyForConsumption;
    }

    public void consume() {
        System.out.println("You've eaten the " + getName());
    }

    @Override
    public String toString() {
        return super.toString() + "Meal{" +
                "weight=" + weight +
                ", isReadyForConsumption=" + isReadyForConsumption +
                '}';
    }
/*@Override
    public String toString() {
        if (!isReadyForConsumption) consumption = "no";
        return "[Meal] \n" +
                PROPERTY_WEIGHT + weight + "\n" +
                PROPERTY_CONSUMPTION + consumption + ";\n" +
                super.toString();
    }*/
}
