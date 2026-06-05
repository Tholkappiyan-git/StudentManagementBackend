package student;

import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
             choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    dao.addStudent(new Student(name, roll, branch, marks));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Roll Number to search: ");
                    String searchRoll = sc.nextLine();
                    dao.searchStudent(searchRoll);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Roll Number to update: ");
                    String updateRoll = sc.nextLine();
                    System.out.print("Enter new Marks: ");
                    int newMarks = sc.nextInt();
                    dao.updateMarks(updateRoll, newMarks);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Roll Number to delete: ");
                    String deleteRoll = sc.nextLine();
                    dao.deleteStudent(deleteRoll);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
