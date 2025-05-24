
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree<Integer> tree = new AVLTree<>();

        System.out.println("AVL Tree Demo");
        System.out.println("------------------");

        boolean running = true;
        while (running) {
            System.out.println("\nOperations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Size");
            System.out.println("5. Height");
            System.out.println("6. Print Tree (Inorder)");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int insertKey = scanner.nextInt();
                    boolean inserted = tree.insert(insertKey);
                    if (inserted) {
                        System.out.println(insertKey + " inserted successfully.");
                    } else {
                        System.out.println(insertKey + " already exists, not inserted.");
                    }
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int deleteKey = scanner.nextInt();
                    boolean deleted = tree.delete(deleteKey);
                    if (deleted) {
                        System.out.println(deleteKey + " deleted successfully.");
                    } else {
                        System.out.println(deleteKey + " not found, cannot delete.");
                    }
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    int searchKey = scanner.nextInt();
                    boolean found = tree.search(searchKey);
                    if (found) {
                        System.out.println(searchKey + " found in the tree.");
                    } else {
                        System.out.println(searchKey + " not found in the tree.");
                    }
                    break;
                case 4:
                    System.out.println("Tree size: " + tree.size());
                    break;
                case 5:
                    System.out.println("Tree height: " + tree.height());
                    break;
                case 6:
                    System.out.println("Tree elements (Inorder):");
                    ((AVLTree<Integer>)tree).printInorder();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}