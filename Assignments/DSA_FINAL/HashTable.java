import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTable { 
    private DSALinkedList[] hashTable;
    private static final int SIZE = 20; //Adjust the table size to 20
    

    public HashTable()  // constructor class
    {
        hashTable = new DSALinkedList[SIZE];  // initialize the hash with the linked list
        for (int i = 0; i < SIZE; i++) {
            hashTable[i] = new DSALinkedList();  //create a linked list at each index of the hash
        }
    }
        
    private int hash(String key) 
    {
        int hValue = 0;
        for (int i = 0; i < key.length(); i++) 
        {
            hValue += key.charAt(i); // Sum the ASCII values 
        }
        return (hValue + SIZE) % SIZE; // Return the hash value
    }

    public void insertfile(String location, int temperature, int humidity, int windSpeed) // insert UAV data to the hash table
    {
        int hValue = hash(location); // Get the hash value for the location
        String data = location + " " + temperature + " " + humidity + " " + windSpeed;
        hashTable[hValue].insertLast(data); // Insert the data into the linked list at the hash 
    }

    public void loadFromFile(String filename)  // Load the data from a file
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = br.readLine()) != null) {         //the token method is done here
                String[] tokens = line.split(" ");         //Split the line into tokens
                String location = tokens[0]; 
                int temperature = Integer.parseInt(tokens[1]); //turn temperature to a integer
                int humidity = Integer.parseInt(tokens[2]);  // turn humidity to a integer
                int windSpeed = Integer.parseInt(tokens[3]); // turn windspeed to a integer
                insertfile(location, temperature, humidity, windSpeed); // Insert the data to the hash table
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public void printUAV(String location) // print the UAV data for the given location
    {
        int hValue = hash(location);    //get the hash value for the given location
        DSALinkedList list = hashTable[hValue];

        for (Object data : list) { 
            String[] tokens = ((String) data).split(" "); // Split the data into tokens
            if (tokens[0].equals(location))         // check if the location,temperature,humidity and wind speed matches with the data file
            {                                 
                System.out.println("Location: " + tokens[0]);
                System.out.println("Temperature: " + tokens[1]);
                System.out.println("Humidity: " + tokens[2]);
                System.out.println("Wind Speed: " + tokens[3]);
                return;
            }
        }

        System.out.println("the specific location not found.");
    }

}
