/******************************************************
 *Name         : Hesara Yasaswin Pathirana            *
 *ID           : 20928386                             *
 *Date         : 28/05/2023                           *
 *Description  :COMP1002, Final Assignment            *
 ******************************************************/


 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         Graph graph = null;
         GraphTraversal graphTraversal = null;
         HashTable hashTable = null;
         Heap heap = null;
         Itinerary itinerary = null;
 
         System.out.println("=========Main Menu=========");
         System.out.println("1. Task 1: Graph reader");
         System.out.println("2. Task 2 & 3: Graph Traversal");
         System.out.println("3. Task 4: Hash Table");
         System.out.println("4. Task 5: Heap");
         System.out.println("5. Task 6: Itinerary");
         System.out.println("6. Exit");
 
         while (true) {
             System.out.print("Enter your choice: ");
             int choice = scanner.nextInt();
             scanner.nextLine(); 
             switch (choice) {
                 case 1:
                     if (graph == null) {
                         graph = new Graph("location.txt", 'A');
                     }
                     graph.AdjacencyList('A');
                     break;
 
                 case 2:
                     if (graphTraversal == null) {
                         graphTraversal = new GraphTraversal("location.txt", "UAVdata.txt");
                     }
 
                     while (true) {
                         System.out.println("----- TASK 2 & 3 Test Harness -----");
                         System.out.println("1. BreadthFirstSearch ? (Shortest Path)");
                         System.out.println("2. DepthFirstSearch ? (Traversal)");
                         System.out.println("3. Insert new location");
                         System.out.println("4. Delete Location");
                         System.out.println("5. Search for the location");
                         System.out.println("6. Print UAV");
                         System.out.println("0. Exit");
                         System.out.print("Enter your choice: ");
                         int traversalChoice = scanner.nextInt();
                         scanner.nextLine(); // Consume the newline character
 
                         switch (traversalChoice) {
                             case 1:
                                 System.out.print("Enter the start location: ");
                                 String startLocation = scanner.nextLine();
 
                                 System.out.print("Enter the end location: ");
                                 String endLocation = scanner.nextLine();
 
                                 graphTraversal.breathfirstsearch(startLocation, endLocation);
                                 break;
                             case 2:
                                 System.out.print("Enter the start location: ");
                                 String dfsStartLocation = scanner.nextLine();
 
                                 graphTraversal.depthfirstsearch(dfsStartLocation);
                                 break;
                             case 3:
                                 System.out.print("Enter the new location: ");
                                 String location = scanner.nextLine();
 
                                 System.out.print("Enter the temperature: ");
                                 int temperature = scanner.nextInt();
 
                                 System.out.print("Enter the humidity: ");
                                 int humidity = scanner.nextInt();
 
                                 System.out.print("Enter the wind speed: ");
                                 int windSpeed = scanner.nextInt();
 
                                 scanner.nextLine(); // Consume newline character
 
                                 graphTraversal.insert(location, temperature, humidity, windSpeed);
                                 System.out.println("Location inserted successfully.");
                                 break;
                             case 4:
                                 System.out.print("Enter the location to delete: ");
                                 String locationToDelete = scanner.nextLine();
 
                                 graphTraversal.delete(locationToDelete);
                                 System.out.println("Location deleted successfully.");
                                 break;
                             case 5:
                                 System.out.print("Enter the location to search: ");
                                 String locationToSearch = scanner.nextLine();
 
                                 graphTraversal.search(locationToSearch);
                                 break;
                             case 6:
                                 System.out.print("Enter the location to print UAV data: ");
                                 String locationToPrint = scanner.nextLine();
 
                                 graphTraversal.print(locationToPrint);
                                 break;
                             case 0:
                                 System.out.println("Exit");
                                 break;
                             default:
                                 System.out.println("Invalid choice");
                                 break;
                         }
 
                         if (traversalChoice == 0) {
                             break;
                         }
 
                         System.out.println();
                     }
                     break;
 
                 case 3:
                     if (hashTable == null) {
                         hashTable = new HashTable();
                         hashTable.loadFromFile("UAVdata.txt");
                     }
 
                     System.out.println("=======HASH=======");
                     System.out.println("");
                     System.out.println("Enter a location to print UAV data or 'q' ");
 
                     while (true) {
                         System.out.print("Enter a location: ");
                         String input = scanner.nextLine().trim();
 
                         if (input.equalsIgnoreCase("q")) {
                             break;
                         }
 
                         hashTable.printUAV(input);
                     }
                     break;
 
                 case 4:
                     if (heap == null) {
                         heap = new Heap();
                     }
 
                     System.out.println("=======HEAP=========");
                     System.out.println("");
                     System.out.print("Enter the number of entries you want to add ");
                     int numEntries = scanner.nextInt();
                     scanner.nextLine(); 
 
                     for (int i = 0; i < numEntries; i++) {
                         System.out.println("Enter UAV data #" + (i + 1));
                         System.out.print("Location: ");
                         String location = scanner.nextLine();
                         System.out.print("Temperature: ");
                         int temperature = scanner.nextInt();
                         System.out.print("Humidity: ");
                         int humidity = scanner.nextInt();
                         System.out.print("Wind Speed: ");
                         int windSpeed = scanner.nextInt();
                         scanner.nextLine(); // Consume the newline character
 
                         int riskLevel = calculateRiskLevel(temperature, humidity, windSpeed);
                         Node node = new Node(location, riskLevel);
                         heap.insert(node);
                     }
 
                     System.out.println("\nAreas with the highest risk of bushfires:");
                     while (!heap.isEmpty()) {
                         Node node = heap.Max();
                         System.out.println("the location is " + node.getLocation() + ", is at a Risk Level of " + node.getRisk());
                     }
                     break;
 
                 case 5:
                     if (itinerary == null) {
                         itinerary = new Itinerary(10);
                         itinerary.loadFile("location.txt");
                     }
 
                     System.out.println("=========ITINERARY========");
                     System.out.println("");
                     System.out.print("Enter the starting location (A-J): ");
                     char startLocation = scanner.next().toUpperCase().charAt(0);
                     int startVertex = startLocation - 'A';
 
                     System.out.println("\nPlanning itinerary from " + startLocation + ":");
                     itinerary.planItinerary();
                     break;
 
                 case 6:
                     System.out.println("Exit");
                     scanner.close();
                     System.exit(0);
 
                 default:
                     System.out.println("Invalid choice");
             }
         }
     }
 
     private static int calculateRiskLevel(int temperature, int humidity, int windSpeed) {
         int riskLevel = 0;
         if (temperature >= 33 || humidity < 30 || windSpeed > 55) {
             riskLevel = 3; // high risk
         } else if ((temperature >= 25 && temperature <= 32) || (humidity >= 31 && humidity <= 50) || (windSpeed >= 41 && windSpeed <= 55)) {
             riskLevel = 2; // medium risk
         } else {
             riskLevel = 1; // low risk
         }
         return riskLevel;
     }
 }