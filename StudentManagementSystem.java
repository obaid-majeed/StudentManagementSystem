<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    saveData();
                    break;
                case 7:
                    loadData();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(nextId++, name, age);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Delete a student
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = students.removeIf(student -> student.getId() == id);
        System.out.println(removed ? "Student deleted!" : "Student not found.");
    }

    // Update a student
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) student.setName(newName);

                System.out.print("Enter new age (0 to keep current): ");
                int newAge = scanner.nextInt();
                if (newAge > 0) student.setAge(newAge);

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search student
    private static void searchStudent() {
        System.out.print("Search by (1) ID or (2) Name: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            students.stream()
                    .filter(s -> s.getId() == id)
                    .forEach(System.out::println);
        } else if (choice == 2) {
            System.out.print("Enter name: ");
            String nameQuery = scanner.nextLine().toLowerCase();
            students.stream()
                    .filter(s -> s.getName().toLowerCase().contains(nameQuery))
                    .forEach(System.out::println);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Save data to file
    private static void saveData() {
        try (FileWriter writer = new FileWriter("students.csv")) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "\n");
            }
            System.out.println("Data saved to students.csv!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    private static void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.csv"))) {
            students.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                students.add(new Student(id, name, age));
                nextId = Math.max(nextId, id + 1);
            }
            System.out.println("Data loaded from students.csv!");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }
}
=======
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Search Student");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    saveData();
                    break;
                case 7:
                    loadData();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(nextId++, name, age);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Delete a student
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = students.removeIf(student -> student.getId() == id);
        System.out.println(removed ? "Student deleted!" : "Student not found.");
    }

    // Update a student
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) student.setName(newName);

                System.out.print("Enter new age (0 to keep current): ");
                int newAge = scanner.nextInt();
                if (newAge > 0) student.setAge(newAge);

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search student
    private static void searchStudent() {
        System.out.print("Search by (1) ID or (2) Name: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            students.stream()
                    .filter(s -> s.getId() == id)
                    .forEach(System.out::println);
        } else if (choice == 2) {
            System.out.print("Enter name: ");
            String nameQuery = scanner.nextLine().toLowerCase();
            students.stream()
                    .filter(s -> s.getName().toLowerCase().contains(nameQuery))
                    .forEach(System.out::println);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Save data to file
    private static void saveData() {
        try (FileWriter writer = new FileWriter("students.csv")) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "\n");
            }
            System.out.println("Data saved to students.csv!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    private static void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.csv"))) {
            students.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                students.add(new Student(id, name, age));
                nextId = Math.max(nextId, id + 1);
            }
            System.out.println("Data loaded from students.csv!");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }
}
>>>>>>> 0a5fd3d612a5b30ed97bb2595f944ea6587dd1f9
