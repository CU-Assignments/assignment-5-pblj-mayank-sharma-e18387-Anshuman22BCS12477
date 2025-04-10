// File: StudentMain.java
import java.io.*;

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student(101, "John Doe", 3.8);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Student details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialization
        System.out.println("\nReading from file...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student readStudent = (Student) ois.readObject();
            readStudent.display();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
