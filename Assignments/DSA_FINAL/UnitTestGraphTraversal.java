import java.util.Scanner;

public class UnitTestGraphTraversal {
    private GraphTraversal graph;

    public UnitTestGraphTraversal(String locationFile, String uavDataFile) {
        graph = new GraphTraversal(locationFile, uavDataFile);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("----- TASK 2 & 3 Test Harness -----");
            System.out.println("1. BreadthFirstSearch ? (Shortest Path)");
            System.out.println("2. DepthFirstSearch ? (Traversal)");
            System.out.println("3. Insert new location");
            System.out.println("4. Delete Location");
            System.out.println("5. Search for the location");
            System.out.println("6. Print UAV");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the start location: ");
                    String startLocation = scanner.nextLine();

                    System.out.print("Enter the end location: ");
                    String endLocation = scanner.nextLine();

                    graph.breathfirstsearch(startLocation, endLocation);
                    break;
                case "2":
                    System.out.print("Enter the start location: ");
                    String dfsStartLocation = scanner.nextLine();

                    graph.depthfirstsearch(dfsStartLocation);
                    break;
                case "3":
                    System.out.print("Enter the new location: ");
                    String location = scanner.nextLine();

                    System.out.print("Enter the temperature: ");
                    int temperature = scanner.nextInt();

                    System.out.print("Enter the humidity: ");
                    int humidity = scanner.nextInt();

                    System.out.print("Enter the wind speed: ");
                    int windSpeed = scanner.nextInt();

                    scanner.nextLine(); 

                    graph.insert(location, temperature, humidity, windSpeed);
                    System.out.println("Location inserted");
                    break;
                case "4":
                    System.out.print("Enter the location to delete: ");
                    String locationToDelete = scanner.nextLine();

                    graph.delete(locationToDelete);
                    System.out.println("Location deleted");
                    break;
                case "5":
                    System.out.print("Enter the location to search: ");
                    String locationToSearch = scanner.nextLine();

                    graph.search(locationToSearch);
                    break;
                case "6":
                    System.out.print("Enter the location to print: ");
                    String locationToPrint = scanner.nextLine();

                    graph.print(locationToPrint);
                    break;
                case "0":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println();
        } while (!choice.equals("0"));

        scanner.close();
    }

    public static void main(String[] args) {
        UnitTestGraphTraversal testHarness = new UnitTestGraphTraversal("location.txt", "UAVdata.txt");
        testHarness.run();
    }
}