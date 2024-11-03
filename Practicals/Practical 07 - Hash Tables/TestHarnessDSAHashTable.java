import java.util.Scanner;

public class TestHarnessDSAHashTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maximum size of the hash table: ");
        int maxSize = sc.nextInt();
        DSAHashTable hashTable = new DSAHashTable(maxSize);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Put key-value pair");
            System.out.println("2. Get value for key");
            System.out.println("3. Check if key exists");
            System.out.println("4. Remove key-value pair");
            System.out.println("5. Display all key-value pairs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = sc.next();
                    System.out.print("Enter value: ");
                    Object value = sc.next();
                    hashTable.put(key, value);
                    System.out.println("Key-value pair added to hash table.");
                    break;
                    
                case 2:
                    System.out.print("Enter key: ");
                    key = sc.next();
                    value = hashTable.get(key);
                    if (value == null) {
                        System.out.println("Key not found in hash table.");
                    } else {
                        System.out.println("Value for key " + key + " is " + value);
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter key: ");
                    key = sc.next();
                    if (hashTable.hasKey(key)) {
                        System.out.println("Key found in hash table.");
                    } else {
                        System.out.println("Key not found in hash table.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter key: ");
                    key = sc.next();
                    hashTable.remove(key);
                    System.out.println("Key-value pair removed from hash table.");
                    break;
                    
                case 5:
                    System.out.println("All key-value pairs in the hash table:");
                    for (DSAHashEntry entry : hashTable.getAllEntries()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}