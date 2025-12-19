package app;

import dao.StudentDAO;
import model.Student;
import java.sql.*;
import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "deepak";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            StudentDAO dao = new StudentDAO(con);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View Student by ID");
                System.out.println("5. View All Students");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Name: "); String name = sc.next();
                        System.out.print("Email: "); String email = sc.next();
                        System.out.print("Course: "); String course = sc.next();
                        System.out.print("Year: "); int year = sc.nextInt();
                        dao.addStudent(new Student(0, name, email, course, year));
                        System.out.println("✅ Student added!");
                        break;
                    case 2:
                        System.out.print("Student ID: "); int id = sc.nextInt();
                        System.out.print("New Name: "); name = sc.next();
                        System.out.print("New Email: "); email = sc.next();
                        System.out.print("New Course: "); course = sc.next();
                        System.out.print("New Year: "); year = sc.nextInt();
                        dao.updateStudent(new Student(id, name, email, course, year));
                        System.out.println("✅ Student updated!");
                        break;
                    case 3:
                        System.out.print("Student ID: "); id = sc.nextInt();
                        dao.deleteStudent(id);
                        System.out.println("✅ Student deleted!");
                        break;
                    case 4:
                        System.out.print("Student ID: "); id = sc.nextInt();
                        Student s = dao.getStudentById(id);
                        System.out.println(s != null ? s : "❌ Student not found");
                        break;
                    case 5:
                        for (Student st : dao.getAllStudents()) {
                            System.out.println(st);
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}