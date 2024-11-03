import java.util.Scanner;

public class UnitTestHeap {
    public static void main(String[] args) 
    {
        Heap heap = new Heap();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of entries you want to add : ");
        int num = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < num; i++) 
        {
            System.out.println("Enter UAV data #" + (i + 1));
            System.out.print("Location: ");
            String location = scanner.nextLine();
            System.out.print("Temperature: ");
            int temperature = scanner.nextInt();
            System.out.print("Humidity: ");
            int humidity = scanner.nextInt();
            System.out.print("Wind Speed: ");
            int windSpeed = scanner.nextInt();
            scanner.nextLine(); 

            int riskLevel = calculateRiskLevel(temperature, humidity, windSpeed);
            Node node = new Node(location, riskLevel);
            heap.insert(node);
        }

        System.out.println("\nhighest risk of bushfires:");
        while (!heap.isEmpty()) {
            Node node = heap.Max();
            System.out.println("the location " + node.getLocation() + ", is at a Risk Level of " + node.getRisk());
        }

        scanner.close();
    }

    private static int calculateRiskLevel(int temperature, int humidity, int windSpeed) 
    {
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

