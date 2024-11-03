import java.util.*;
import java.io.*;

public class SortsFile {  

    public static void main(String[] args) {
        int i = 0;
        Student[] studList = new Student[7001]; //Student id and array read to an object
        int[] studIds = new int[7001]; // Int array used to parse through sorting algorithms 

        FileInputStream fileStrm = null;  //Csv file reading
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;

        try {
            fileStrm = new FileInputStream("RandomNames7000.csv");
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            lineNum = 0;
            line = bufRdr.readLine();
            while (line != null) {
                lineNum++;
                studList[lineNum] = procLine(line); //Method used to parse known format of csv row
                //studList[lineNum].display();
                studIds[lineNum] = studList[lineNum].getId();
                // System.out.println(studIds[lineNum]);

                line = bufRdr.readLine();
            }
            fileStrm.close();

        } catch (IOException e) {
            if (fileStrm != null) {
                try {
                    fileStrm.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }

        Sorts.bubbleSort(studIds);  //Sorting method from Sorts class
        writeSorted("BubbleSortNames.csv", studIds, studList); //Sorted file written to a csv file
        Sorts.selectionSort(studIds);
        writeSorted("SelectionSortNames.csv", studIds, studList);
        Sorts.insertionSort(studIds);
        writeSorted("InsertionSortNames.csv", studIds, studList);
        

    }

    private static Student procLine(String csvR) throws IllegalStateException {
        String name = "";
        int id = 0;
        Student studentData = new Student();

        String[] tokens = csvR.split(",");
        try {
            id = Integer.parseInt(tokens[0]);
            name = tokens[1];
        
            studentData.setId(id);
            studentData.setName(name);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return studentData;
    }

    public static void writeSorted(String fName, int[] arr, Student[] list)
    {
        FileOutputStream fileStrm = null;
        PrintWriter printW;
        int i;

        try
        {
            fileStrm = new FileOutputStream(fName);
            printW = new PrintWriter(fileStrm);

            for (i = 0; i < arr.length; i++)
            {
                if (list[i] != null)
                {
                    printW.println(arr[i] + "," + list[i].getName());
                }
            }
            printW.close();
        }
        catch (IOException e) //Exception handling
        {
            if (fileStrm != null)
            {
                try 
                { 
                    fileStrm.close(); 
                }
                catch (IOException ex2)
                {

                }
            }
            System.out.println("Error in file writing: " + e.getMessage());
        }
        

    }

    


}


