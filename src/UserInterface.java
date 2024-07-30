import java.util.Scanner;

public class UserInterface {
    public static void showMenu(){
        System.out.println("""
                =====================================
                       Inventory Management System
                =====================================
                1. Add Item
                2. View Items
                3. Update Item
                4. Delete Item
                5. Search Items
                6. Generate Report
                7. Exit
                =====================================
                Enter your choice: """);
    }

    public static void clearScreen() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public static void promptEnterToContinue() {
        System.out.println("Press enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
