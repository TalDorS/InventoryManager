import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private final Inventory inventory = new Inventory();

    public void runInventory(){
        Scanner input = new Scanner(System.in);
        int choice;
        boolean isQuit = false;

        while(!isQuit){
            UserInterface.clearScreen();
            UserInterface.showMenu();
            choice = input.nextInt();
            isQuit = handleMenuChoice(MenuOption.fromValue(choice));
        }
    }

    private boolean handleMenuChoice(MenuOption choice){
        boolean isQuit = false;

        switch (choice) {
            case MenuOption.ADD_ITEM:
                addItem();
                break;
            case MenuOption.VIEW_ITEMS:
                viewItems();
                break;
            case MenuOption.UPDATE_ITEM:
                updateItem();
                break;
            case MenuOption.DELETE_ITEM:
                deleteItem();
                break;
            case MenuOption.SEARCH_ITEMS:
                searchItem();
                break;
            case MenuOption.GENERATE_REPORT:
                inventory.generateReport();
                UserInterface.promptEnterToContinue();
                break;
            case MenuOption.EXIT:
                System.out.println("Exiting the program...");
                isQuit = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        return isQuit;
    }

    private void addItem() {
        Scanner input = new Scanner(System.in);
        String name;
        int quantity;
        double price;

        UserInterface.clearScreen();

        System.out.print("Enter the name of the item you would like to add: ");
        name = input.nextLine();

        while (name.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Enter the name of the item: ");
            name = input.nextLine();
        }

        while (true) {
            System.out.print("Enter the quantity of the item you would like to add: ");
            if (input.hasNextInt()) {
                quantity = input.nextInt();
                if (quantity > 0) {
                    break;
                } else {
                    System.out.println("Quantity must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }

        while (true) {
            System.out.print("Enter the price of the item you would like to add: ");
            if (input.hasNextDouble()) {
                price = input.nextDouble();
                if (price >= 0) {
                    break;
                } else {
                    System.out.println("Price cannot be negative.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }

        Item newItem = new Item(name, quantity, price);
        inventory.addItem(newItem);
        System.out.println("Item added successfully.");
    }

    private void viewItems(){
        UserInterface.clearScreen();
        inventory.viewInventory();
    }

    private void updateItem() {
        UserInterface.clearScreen();
        Scanner input = new Scanner(System.in);
        String newName;
        int newQuantity;
        double newPrice;
        int itemId;

        System.out.print("Enter the ID of the item you would like to update: ");
        while (true) {
            if (input.hasNextInt()) {
                itemId = input.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }

        input.nextLine(); // Consume the newline character

        System.out.print("Enter the new name of the item: ");
        newName = input.nextLine();

        while (newName.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Enter the new name of the item: ");
            newName = input.nextLine();
        }

        while (true) {
            System.out.print("Enter the new quantity of the item: ");
            if (input.hasNextInt()) {
                newQuantity = input.nextInt();
                if (newQuantity > 0) {
                    break;
                } else {
                    System.out.println("Quantity must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }

        while (true) {
            System.out.print("Enter the new price of the item: ");
            if (input.hasNextDouble()) {
                newPrice = input.nextDouble();
                if (newPrice >= 0) {
                    break;
                } else {
                    System.out.println("Price cannot be negative.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }

        inventory.updateItem(itemId, newName, newQuantity, newPrice);
        System.out.println("Item updated successfully.");
    }

    private void deleteItem() {
        UserInterface.clearScreen();
        Scanner input = new Scanner(System.in);
        int itemId;

        System.out.print("Enter the ID of the item you would like to delete: ");
        while (true) {
            if (input.hasNextInt()) {
                itemId = input.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }

        inventory.deleteItem(itemId);
        System.out.println("Item deleted successfully.");
    }

    private void searchItem() {
        UserInterface.clearScreen();
        Scanner input = new Scanner(System.in);
        ArrayList<Item> searchedItems;
        String itemName;

        System.out.println("Enter the name of the item you would like to search: ");
        itemName = input.nextLine();
        searchedItems = inventory.searchItemByName(itemName);
        for(Item item : searchedItems){
            System.out.println(item.toString());
        }
    }
}
