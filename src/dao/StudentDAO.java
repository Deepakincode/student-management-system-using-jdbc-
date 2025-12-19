package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO(Connection con) {
        this.con = con;
    }

    // Add Student
    public void addStudent(Student s) throws SQLException {
        String query = "INSERT INTO students(name, email, course, year) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, s.getName());
        pstmt.setString(2, s.getEmail());
        pstmt.setString(3, s.getCourse());
        pstmt.setInt(4, s.getYear());
        pstmt.executeUpdate();
    }

    // Update Student
    public void updateStudent(Student s) throws SQLException {
        String query = "UPDATE students SET name=?, email=?, course=?, year=? WHERE student_id=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, s.getName());
        pstmt.setString(2, s.getEmail());
        pstmt.setString(3, s.getCourse());
        pstmt.setInt(4, s.getYear());
        pstmt.setInt(5, s.getStudentId());
        pstmt.executeUpdate();
    }

    // Delete Student
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE student_id=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    // View Student by ID
    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM students WHERE student_id=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Student(rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("year"));
        }
        return null;
    }

    // View All Students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        ResultSet rs = con.createStatement().executeQuery(query);
        while (rs.next()) {
            list.add(new Student(rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("year")));
        }
        return list;
    }
}