package project1Learning;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main obj = new Main();
        
        while (true) {
            System.out.println("\n+++++++++ Student Management System +++++++++");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline character
                
                switch (choice) {
                    case 1 -> obj.addStudent();
                    case 2 -> obj.displayStudents();
                    case 3 -> obj.removeStudent();
                    case 4 -> {
                        System.out.println("Thank you for using Student Management System!");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please enter 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    public void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            Long id = sc.nextLong();
            sc.nextLine(); // Consume newline character
            
            // Check for duplicate ID
            if (students.stream().anyMatch(s -> s.getId().equals(id))) {
                System.out.println("Student with ID " + id + " already exists!");
                return;
            }
            
            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("Student name cannot be empty!");
                return;
            }
            
            System.out.print("Enter student grade: ");
            String grade = sc.nextLine().trim();
            
            if (grade.isEmpty()) {
                System.out.println("Student grade cannot be empty!");
                return;
            }
            
            students.add(new Student(id, name, grade));
            System.out.println("Student added successfully!");
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid ID number.");
            sc.nextLine(); // Clear invalid input
        }
    }

    public void removeStudent() {
        try {
            if (students.isEmpty()) {
                System.out.println("No students to remove. List is empty!");
                return;
            }
            
            System.out.print("Enter student ID to remove: ");
            Long id = sc.nextLong();
            sc.nextLine(); // Consume newline character
            
            boolean removed = students.removeIf(s -> s.getId().equals(id));
            
            if (removed) {
                System.out.println("Student with ID " + id + " removed successfully!");
            } else {
                System.out.println("Student with ID " + id + " not found!");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid ID number.");
            sc.nextLine(); // Clear invalid input
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Student list is empty!");
        } else {
            System.out.println("\n========== Student List ==========");
            System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Grade");
            System.out.println("----------------------------------------");
            
            for (Student s : students) {
                System.out.printf("%-10s %-10s %-10s%n", 
                    s.getId(), s.getName(), s.getGrade());
            }
            System.out.println("========================================");
            System.out.println("Total students: " + students.size());
        }
    }
}
