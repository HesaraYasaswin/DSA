import java.util.Scanner;

public class UnitTestHashTable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.loadFromFile("UAVdata.txt");

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter a location or 'q': ");
            System.out.println("");
            input = scanner.nextLine().trim();

            if (!input.equalsIgnoreCase("q")) {
                hashTable.printUAV(input);
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}