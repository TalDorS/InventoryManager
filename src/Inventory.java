import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final HashMap<Integer, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }

    public void viewInventory() {
        for (Item item : inventory.values()) {
            System.out.println(item.toString());
        }
    }

    public void deleteItem(int id) {
        inventory.remove(id);
    }

    public boolean updateItem(int id, String newName, int newQuantity, double newPrice) {
        for (Item item : inventory.values()) {
            if (item.getId() == id) {
                item.setName(newName);
                item.setQuantity(newQuantity);
                item.setPrice(newPrice);
                return true;
            }
        }
        return false; // Item not found
    }

    public ArrayList<Item> searchItemByName(String name) {
        ArrayList<Item> items = new ArrayList<>();

        for (Item item : inventory.values()) {
            if(item.getName().contains(name)){
                items.add(item);
            }
        }

        return items;
    }

    public void generateReport() {
        double totalValue = 0;
        ArrayList<Item> lowStockItems = new ArrayList<>();
        int lowStockThreshold = 5; // Example threshold for low stock

        for (Item item : inventory.values()) {
            totalValue += item.getQuantity() * item.getPrice();
            if (item.getQuantity() < lowStockThreshold) {
                lowStockItems.add(item);
            }
        }
        System.out.println("""
                Inventory Report
                ================
                Total Inventory Value: $""" + totalValue);
        System.out.println("Low Stock Items:");
        for (Item item : lowStockItems) {
            System.out.println(item);
        }

        if (lowStockItems.isEmpty()) {
            System.out.println("No items with low stock.");
        }
    }
}
