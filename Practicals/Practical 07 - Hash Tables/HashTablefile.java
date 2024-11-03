import java.io.*;
import java.util.*;

public class HashTablefile {
    public static void main(String[] args) {
        String inputFile = "RandomNames7000.csv";
        String outputFile = "UniqueRandomNames7000.csv";
        Hashtable<Long, String> table = new Hashtable<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine(); // skip the header
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Long key = Long.parseLong(fields[0].trim());
                String value = fields[1].trim();

                // check for duplicates before inserting
                if (!table.containsKey(key)) {
                    table.put(key, value);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("ID,Name\n");
            Enumeration<Long> keys = table.keys();
            while (keys.hasMoreElements()) {
                Long key = keys.nextElement();
                String value = table.get(key);
                writer.write(key + "," + value + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Unique file has been created: UniqueRandomNames7000.csv");
    }
}