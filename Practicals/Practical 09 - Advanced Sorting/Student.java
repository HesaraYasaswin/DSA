import java.util.*;
import java.io.*;

public class Student {
    public String name;
    public int id;

    public Student() {
        name = "";
        id = 0;
    }

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    void display() {
        System.out.println("ID : " + id + " Name : " + name);
    }

}
