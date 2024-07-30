import java.text.MessageFormat;

public class Item {
    private static int idGenerator;
    private final int id;
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.id = ++idGenerator;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Item ID: {0}. Item Name: {1}. Item Quantity: {2}. Item Price: {3}", id, name, quantity, price);
    }
}
