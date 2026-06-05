package student;

import java.sql.*;

public class StudentDAO {

    
    public void addStudent(Student s) {
        String sql = "INSERT INTO students(name, rollNumber, branch, marks) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
          
            ps.setString(1, s.getName());
            ps.setString(2, s.getRollNumber());
            ps.setString(3, s.getBranch());
            ps.setInt(4, s.getMarks());
             ps.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void viewStudents(){

        String sql = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            System.out.println("\nID | Name | Roll | Branch | Marks");
            System.out.println("------------------------------------");

            while (rs.next()){

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("rollNumber") + " | " +
                    rs.getString("branch") + " | " +
                    rs.getInt("marks")
                );
            }

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void searchStudent(String rollNumber){

        String sql = "SELECT * FROM students WHERE rollNumber=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

              ps.setString(1, rollNumber);
              ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("rollNumber") + " | " +
                    rs.getString("branch") + " | " +
                    rs.getInt("marks")
                );
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void updateMarks(String rollNumber, int marks){
        String sql = "UPDATE students SET marks=? WHERE rollNumber=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, marks);
            ps.setString(2, rollNumber);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Marks updated successfully!");
            else
                System.out.println("Student not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void deleteStudent(String rollNumber){

        String sql = "DELETE FROM students WHERE rollNumber=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, rollNumber);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Student deleted successfully!");
            else
                System.out.println("Student not found!");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
