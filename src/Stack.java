import java.util.Objects;

public class Stack {
    private int id;
    private Location location;
    private int capacity;
    private static final String PROPERTY_ID = "Id: ";
    private static final String PROPERTY_LOCATION = "Location: ";
    private static final String PROPERTY_CAPACITY;

    static {
        PROPERTY_CAPACITY = "Capacity: ";
    }

    {
        location = Location.WAREHOUSE;
        capacity = 100;
    }

    public Stack(int id, Location location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
    }

    public Stack(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {//only unique id
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return id == stack.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "[Stack] \n" +
                PROPERTY_ID + id + "\n" +
                PROPERTY_LOCATION + location + "\n" +
                PROPERTY_CAPACITY + capacity + ";\n";
    }

    public enum Location {
        SHOP,
        WAREHOUSE
    }

}
