import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnitTestItinerary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Itinerary planner = new Itinerary(10);
        String filename = "location.txt";
        System.out.println("from the data of location.txt " + filename);
        System.out.println(" ");
        planner.loadFile(filename);

        System.out.print("Enter the location: ");
        char startLocation = scanner.next().toUpperCase().charAt(0);
        int startVertex = startLocation - 'A';

        System.out.println("\nitinerary from " + startLocation + ":");
        System.out.println(" ");
        planner.planItinerary();

        scanner.close();
    }
}